package com.cyber.cafe;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyber.cafe.dao.MyBatisDAO;
import com.cyber.cafe.vo.ChatList;
import com.cyber.cafe.vo.ChatVO;
import com.cyber.cafe.vo.FriendList;
import com.cyber.cafe.vo.FriendVO;
import com.cyber.cafe.vo.MemberVO;
import com.cyber.cafe.vo.RoomList;
import com.cyber.cafe.vo.RoomVO;
import com.cyber.cafe.vo.TodoList;
import com.cyber.cafe.vo.TodoVO;

@Controller
public class HomeController {
	
	@Autowired
	public SqlSession sqlSession;
	
	@Autowired
	
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
		
		// 현재 로그인한 사람 수를 받아서 넘겨준다.
//		model.addAttribute("userCount", new Listener().getUserCount());
//		model.addAttribute("totalCount", new Listener().getTotalCount());
		model.addAttribute("wantF", request.getParameter("wantF"));	
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
		MemberVO dbvo = mapper.getId(memberVO.getId());
		if (dbvo.getPassword().trim().equals(memberVO.getPassword())) {
			
			// 입력한 비밀번호와 db에서 얻어온 비밀번호가 일치할 경우 로그인 정보를 세션에 저장한다.
			HttpSession session = request.getSession();
			session.setAttribute("id", dbvo.getId());
			session.setAttribute("nickname", dbvo.getNickname());
			session.setAttribute("password", dbvo.getPassword());
			session.setAttribute("sdate", dbvo.getSdate());
			
			// 친구 신청중인 아이디가 있는지 확인한다. 
			AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
			FriendList wantF = ctx.getBean("friendList", FriendList.class);
			wantF.setList(mapper.whoWantsToBeFriend(dbvo.getId()));
			
			System.out.println("친구 원함 " +wantF);
			
			model.addAttribute("wantF", wantF);			
			session.setAttribute("wantF", wantF);			
			
			// 메인 페이지로 돌아간다.
			return "redirect:main";
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

		
		// 얻어온 세션 정보와 id, 방 번호를 DB에 저장한다.
		
		
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
	
	@RequestMapping("profile")
	public String profile(HttpServletRequest request, Model model) {
		// mapper를 얻어온다.
		MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);		
		
		// 전 페이지에서 프로필을 얻어올 id와 현재 로그인 중인 id를 받아온다.
		String fid = request.getParameter("fid");
		String mid = request.getParameter("mid");
		
		 // id에 해당하는 프로필을 받아온다.
		MemberVO memberVO =  mapper.getId(fid);
		
		// friendVO에 해당하는 친구 상태를 얻어온다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		FriendVO friendVO = ctx.getBean("friendVO", FriendVO.class);
		friendVO.setFid(fid);
		friendVO.setMid(mid);
		String rel = mapper.getRel(friendVO);
		
		// 얻어온 프로필과 친구 상태를 뷰페이지로 넘겨준다.
		model.addAttribute("memberVO", memberVO);
		model.addAttribute("rel", rel);		
		
		return "profileView";
	}
	
	@RequestMapping("friendOK")
	public String friendOK(HttpServletRequest request, Model model, FriendVO friendVO, HttpServletResponse response) {
		// mapper를 얻어온다.
		MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);		
		
		int mode = Integer.parseInt(request.getParameter("mode"));
		if (mode == 1) {
			
			// 이미 같은 사람에게 친구 신청을 보낸 적 있는지 확인한다.
			
			// friendVO의 mid가 friendVO의 fid로 친구 신청을 보낸다.
			mapper.friendRequest(friendVO);
			
			// 친구 신청을 보냈을 때 상대도 이미 나에게 친구 신청을 보냈는 지 확인한다.
			int cr = mapper.counterRequest(friendVO);
			if (cr > 0) {
				// cr이 0보다 크다면 상대가 나에게 친구를 신청한 적 있다는 뜻이므로 친구 상태가 된다.
				friendVO.setRelation("친구");
			} else {
				// cr이 0이라면 상대가 나에게 친구를 신청한 적이 없다는 뜻이므로 친구 신청중 상태가 된다.
				friendVO.setRelation("친구 신청중");			
			}
			mapper.changeRelation(friendVO);
			
			Alert.alertAndGo(response, "친구 신청을 완료했습니다.", "main");
			
		} else if (mode == 2) {
			// 친구를 삭제한다.
			mapper.deleteFriend(friendVO);
			Alert.alertAndGo(response, "친구를 삭제했습니다.", "main");
		}
		return "";
	}
	
	@RequestMapping("myPage")
	public String myPage(HttpServletRequest request, Model model) {
		// mapper를 얻어온다.
		MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);		
		
		// 내 정보를 불러와서 넘겨준다.
		String id = request.getParameter("id");
		MemberVO memberVO =  mapper.getId(id);		
		model.addAttribute("memberVO", memberVO);
		
		// 친구 목록을 불러와서 넘겨준다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		FriendList friendList = ctx.getBean("friendList", FriendList.class);
		friendList.setList(mapper.getFriendList(id));
		model.addAttribute("friendList", friendList);
		
		
		return "myPageView";
	}
		
	@ResponseBody
	@RequestMapping(value="/goChat", produces="application/text; charset=utf8")
	public String goChat(HttpServletRequest request, Model model, ChatVO chatVO) {
		// mapper를 얻어온다.
		MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);		
		
		// 방 idx, 채팅 내용과 닉네임을 얻어와 Chat 테이블에 입력한다.
		mapper.goChat(chatVO);
		System.out.println("저기요"+chatVO);
		
		// 같은 방의 채팅 목록을 불러온다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		ChatList chatList = ctx.getBean("chatList",ChatList.class);
		chatList.setList(mapper.getChatList(chatVO.getChatRoomIdx()));
		
		// 불러온 데이터를 ajax로 main.js의 goChat 함수에 넣어준다.
		StringBuffer result = new StringBuffer();

		result.append("{\"result\": ["); // json 시작
//		데이터의 개수만큼 반복하며 json 형태의 문자열을 만든다.
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		for (ChatVO vo : chatList.getList()) {
			result.append("[{\"value\": \"" + vo.getChatNickname() + "\"},");
			result.append("{\"value\": \"" + vo.getChatContent() + "\"},");
			result.append("{\"value\": \"" + sdf.format(vo.getChatTime()) + "\"}]");
		}
		result.append("]}");

		return result.toString(); 
	}	
	
	
	@RequestMapping("changeInfo")	
	public String goChat(HttpServletRequest request, Model model, MemberVO memberVO) {
		// mapper를 얻어온다.
		MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);		
		
		// 정보를 수정한다.
		mapper.changeInfo(memberVO);
	
		// 다시 마이페이지로 돌아가기 위해 id를 넘겨준다.
		model.addAttribute("id", memberVO.getId());
		return "redirect:myPage";
	}	
	
	@RequestMapping("addTodo")
	public String addTodo(HttpServletRequest request, Model model, TodoVO todoVO) {
		
		// mapper를 얻어온다.
		MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);		
		
		// 투두 리스트에 추가한다.
		mapper.addTodo(todoVO);
		
		// 투두 리스트를 모두 불러온다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		TodoList todoList = ctx.getBean("todoList", TodoList.class);
		todoList.setList(mapper.getTodo(todoVO.getId()));
		
		return todoList.toString();
	}
}