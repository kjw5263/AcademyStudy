package com.admin.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.order.db.AdminOrderDAO;
import com.order.db.OrderDTO;

public class AdminOrderModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : AdminOrderModifyAction_execute() 호출");
		
		// 관리자 세션 제어
		
		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 전달 정보 저장 (trade_num, status, trans_num) : 이름 헷갈리지 않도록 주의 할 것
		// => OrderDTO 에 저장
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setO_trade_num(request.getParameter("o_trade_num"));
		orderDTO.setO_status(Integer.parseInt(request.getParameter("status")));
		orderDTO.setO_trans_num(request.getParameter("o_trans_num"));
		
		
		// AdminOrderDAO 객체 생성 - 상태 & 운송장 번호 수정 메소드
		AdminOrderDAO aoDAO = new AdminOrderDAO();
		aoDAO.updateOrder(orderDTO);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./AdminOrderList.ao");
		forward.setRedirect(true);
		
		return forward;
	}

}
