package com.member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.db.MemberDAO;

public class MemberListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : MemberListAction_execute() 호출!");
		
		// 세션 제어 (관리자 )
		// 세션 제어, update 에서 한글로 데이터 넘기므로 한글처리 
		HttpSession session = request.getSession();

		// 전달된 정보를 저장
		String id = (String)session.getAttribute("id");
		
		
		ActionForward forward = new ActionForward();
		if(id == null || !id.equals("admin")){
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}
		// DAO 객체 -> 회원정보 전부 가져오기 (list 형태)
		MemberDAO dao = new MemberDAO();
		List memberList = dao.getMemberList();
		// list 정보를 저장 (request 영역, session에도 쓸수있지만 한번만 쓰는게 좋으므로 requset)
		request.setAttribute("memberList", memberList);
		
		
		// 페이지 이동 (forward-list.jsp)
		forward.setPath("./member/list.jsp");
		forward.setRedirect(false);
		return forward;
	}
	
}
