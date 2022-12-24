package com.cyber.cafe;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.cyber.cafe.dao.MyBatisDAO;

@WebListener
public class Listener implements HttpSessionListener{
	
	@Autowired
	public SqlSession sqlSession;
	
	private int nowCount;
	private int totalCount;
	
	public int getUserCount() {
		return nowCount;
	}

	public int getTotalCount() {
		return totalCount;
	}


	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		// 현재 접속자 수와 누적 접속자 수를 증가 시킨다.
		++nowCount; ++totalCount;
		
        System.out.printf("생성된 SESSIONID %s \n",  se.getSession().getId());
        System.out.printf("로그인된 사용자 수 : %d \n", nowCount);		

        // mapper를 얻어온다.
        //MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);
        
       // mapper.setSessionInfo(se.getSession().getId());
        
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
		// 현재 접속자 수를 감소시킨다.
		--nowCount;
        System.out.printf("제거된 SESSIONID %s \n",  se.getSession().getId());
        System.out.printf("로그인된 사용자 수 : %d \n", nowCount);
		
        // mapper를 얻어온다.
        MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);
        
        // 현재 세션 정보를 db에서 삭제한다.
        mapper.deleteSessionInfo(se.getSession().getId());
        
        
	}

	
	
}
