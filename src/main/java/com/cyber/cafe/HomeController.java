package com.cyber.cafe;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyber.cafe.dao.MyBatisDAO;
import com.cyber.cafe.vo.MemberVO;
import com.cyber.cafe.vo.RoomList;
import com.cyber.cafe.vo.RoomVO;
import com.cyber.cafe.Alert;

@Controller
public class HomeController {
	
	@Autowired
	public SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String home() {
		return "redirect:main";
	}

	@RequestMapping("/main")
	public String main(HttpServletRequest request, Model model) {
		// mapper를 얻어온다.
		MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);

		// 이미 생성된 방이 있는지 확인한다.
		
		
		return "main";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/loginOK")
	public String loginOK(HttpServletRequest request, Model model, MemberVO memberVO, HttpServletResponse response) {
		// mapper를 얻어온다.
		MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);
		
		// 입력한 아이디와 일치하는 vo를 db에서 얻어온다.
		MemberVO dbvo = mapper.getId(memberVO);
		if (dbvo.getPassword().trim().equals(memberVO.getPassword())) {
			// 입력한 비밀번호와 db에서 얻어온 비밀번호가 일치할 경우 로그인 정보를 세션에 저장한다.
			HttpSession session = request.getSession();
			session.setAttribute("id", dbvo.getId());
			session.setAttribute("nickname", dbvo.getNickname());
			session.setAttribute("password", dbvo.getPassword());
			session.setAttribute("sdate", dbvo.getSdate());
			
			// 메인 페이지로 돌아간다.
			Alert.alertAndGo(response, "로그인되었습니다.", "main");
		} else {
			Alert.alertAndGo(response, "로그인에 실패했습니다.", "login");			
		}
		
		return "";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, Model model, MemberVO memberVO, HttpServletResponse response) {
		// 직전 페이지의 주소를 얻어온다.
		// String ogUrl = request.getHeader("referer");
		// ogUrl = ogUrl.substring(29);

		// 세션에서 로그인 정보를 삭제한다.
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		session.removeAttribute("nickname");
		session.removeAttribute("password");
		session.removeAttribute("sdate");
		
		// 메인 페이지로 돌아간다.
		Alert.alertAndGo(response, "로그아웃되었습니다.", "main");
		return "";
	}
	
	@RequestMapping("/joinmember")
	public String joinmember() {
		return "joinmember";
	}
	
	@RequestMapping("/joinOK")
	public String joinOK(HttpServletRequest request, Model model, MemberVO memberVO, HttpServletResponse response) {
		// mapper를 얻어온다.
		MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);
		
		// 회원가입을 한다.
		mapper.joinmember(memberVO);
		Alert.alertAndGo(response, "회원가입이 완료되었습니다.", "main");
		
		return "main";
	}
	
	@RequestMapping("makeRoom")
	public String makeRoom(HttpServletRequest request, Model model, HttpServletResponse response) {
		
		return "makeRoom";
	}
	
	@RequestMapping("makeRoomOK")
	public String makeRoomOK(HttpServletRequest request, Model model, HttpServletResponse response, RoomVO roomVO) {
		// mapper를 얻어온다.
		MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);

		// 이전 페이지에서 넘어온 id를 받는다.
		String id = request.getParameter("id");
		
		// 같은 아이디로 이미 생성된 방이 있을 경우 기존 방 데이터를 삭제한다.
		int eNum = mapper.roomExist(id);
		if (eNum > 0) {
			mapper.deleteExistance(id);
		}
		
		// 현재 로그인한 사람의 아이디를 roomVO의 RoomHost에 넣어준다.
		roomVO.setRoomHost(id);
		
		// 입력한 방 정보를 db에 저장한다(방을 만든다).
		mapper.makeNewRoom(roomVO);
		
		// 방의 정보를 넘겨준다.
		model.addAttribute("id", id);

		// 생성된 방 페이지로 넘어간다.
//		Alert.alertAndGo(response, "방이 생성되었습니다.", "roomView?roomIdx=" + roomVO.getRoomIdx());
		
		return "redirect:roomView";
	}
	
	@RequestMapping("roomView")
	public String roomView(HttpServletRequest request, Model model) {
		// mapper를 얻어온다.
		MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);
		String roomHost = request.getParameter("id");
		
		// 전 페이지에서 넘어온 roomHost로 방 정보를 얻어와서 넘겨준다.
		RoomVO roomVO = mapper.getRoomInfo(roomHost);
		model.addAttribute("roomVO", roomVO);
		
		// 테마를 얻어온다.
		
		// 현재 방을 제외한 다른 방 목록을 얻어와서 넘겨준다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		RoomList roomList = ctx.getBean("roomList", RoomList.class);
		
		roomList.setList(mapper.getRooms(roomHost));
		model.addAttribute("roomList", roomList);
		
		// 채팅 내용을 얻어온다. (iframe으로 할까?)
		
		
		return "roomView";
	}
	
	@RequestMapping("findRoom")
	public String findRoom(HttpServletRequest request, Model model) {
		// mapper를 얻어온다.
		MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);		
		
		// 이전 페이지에서 넘어오는 화면에 표시할 페이지 번호를 받는다.
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));		
		} catch (NumberFormatException e) {
			
		}
		
		// 한 페이지에 표시할 방의 개수, 브라우저에 표시할 페이지 번호, 전체 글의 개수를 저장한다.
		int pageSize = 8;
		int totalCount = mapper.selectRoomCount();
				
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		RoomList roomList = ctx.getBean("roomList", RoomList.class);
		roomList.initRoomList(pageSize, totalCount, currentPage);
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("startNo", roomList.getStartNo());
		hmap.put("endNo", roomList.getEndNo());
		
		roomList.setList(mapper.getRoomList(hmap));
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("roomList", roomList);
		
		return "roomList";
	}
	
}