package com.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.db.MemberDAO;
import com.member.db.MemberDTO;

public class MemberInfoAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : MemberInfoAction_execute() 호출");
		
		// 세션 정보 제어
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		ActionForward forward = new ActionForward();
		if(id == null){
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}
		
		// DAO 객체 생성 -> getMember(id)=> 회원정보 가져오기
		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = mdao.getMember(id);
		request.setAttribute("mdto", mdto);
		
		//request.setAttribute("mdto", mdao.getMember(id));
		// -> 위 2줄을 한번에 적은 것
		
		// 페이지 이동 -> view Page 
		// 대부분 jsp 페이지로 이동하면 forward, 그때 forward를 넘길 땐
		// request 객체에 넘김
		forward.setPath("./member/info.jsp");
		forward.setRedirect(false);
		return forward;
		
		
		// DB에서 전달받은 정보를 저장 (request 영역 )(
		
		
		
		// 페이지 이동 ! -> View 페이지 (./member/info.jsp)
		// 이 액션의 결과는? 회원의 정보를 보여줘야하기 때문에
		// 회원 정보를 보여주는 페이지가 필요해
		// 그래서 페이지를 만든거야~
	}
	

}
