package com.member.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.db.MemberDAO;
import com.member.db.MemberDTO;

public class MemberJoinAction implements Action {

	// 회원가입에 대한 처리
	// 1) 전달된 정보 저장 -> JoinForm.jsp에서 보낸 정보?
	// 		자바와 jsp연결 어캐 하노? -> Action 인터페이스 ->오버라이딩 필수
	//		그럼 request, response를 어디서 받아? 
	// 	---> 컨트롤러에서 MemJoinAction 객체 생성할 때, execute메소드 파라미터로 넘겨준값 받아온다! 와 너무 이해돼!
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : MemberJoinAction_execute 호출 !!");
		
		// 1. MemberJoinForm에서 전달된 정보 저장하기 (파라미터 저장)
		MemberDTO mdto = new MemberDTO();
		request.setCharacterEncoding("UTF-8");
		// Controller에서 보내준 request를 이용해 파라미터값 받아올수있게됐어!
		mdto.setId(request.getParameter("id"));
		mdto.setAge(Integer.parseInt(request.getParameter("age")));
		mdto.setEmail(request.getParameter("email"));
		mdto.setGender(request.getParameter("gender"));
		mdto.setName(request.getParameter("name"));
		mdto.setPass(request.getParameter("pass"));
		mdto.setReg_date(new Timestamp(System.currentTimeMillis()));
		
		System.out.println(mdto.toString());
		
		// DB에 저장하기 
		MemberDAO mdao = new MemberDAO();
		// 회원가입 메소드 - insertMember(mdto);
		mdao.insertMember(mdto);
		
		// 데이터 저장하고, Db 다녀오는거까지 했으니
		// 이제 남은 것은 페이지 이동 남았다!
		// 페이지 이동할 떄는?? forward 쓰기로 했엉!!->ActionForward 객체
		// 엥 근데 Controller로만 움직인다고 하지 않았어?
		// ** 이 execute 메소드 리턴값이 ActionForward임!
		// -> 이 메소드를 호출했던 곳이 어디? Controller !!!!!
		// 그럼 컨트롤러는 ActionForward(페이지 이동) 정보를 리턴받는다 !!
		
		// 그럼 페이지 이동 객체 만들자!
		// 현재 MemberJoinAction.me 페이지에서 MemberLogin.me 화면으로 이동해야한다
		// 그럼 로그인으로 url 로 바껴야하므로 forward가 아닌 redirect로 넘겨야해!
		ActionForward forward = new ActionForward();
		forward.setPath("./MemberLogin.me");
		forward.setRedirect(true);
		return forward;
	}
	
	
	// 2) DB 저장
	// 3) 페이지 이동 (컨트롤러가 이동할 준비)

}
