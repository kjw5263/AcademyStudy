package com.admin.goods.action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.goods.db.AdminGoodsDAO;


public class AdminGoodsDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : AdminGoodsDeleteAction_execute() 호출");
		
		// 해당 상품을 삭제하는 Action
		// 삭제할 상품 번호 저장 (파라미터값)
		int num = Integer.parseInt(request.getParameter("num"));
		
		// DAO 객체 생성 -DeleteGoods(num)
		AdminGoodsDAO agdao = new AdminGoodsDAO();
		agdao.deleteGoods(num);
		
		
		// 페이지 이동 (./AdminGoodsList.ag)
		ActionForward forward = new ActionForward();
		forward.setPath("./AdminGoodsList.ag");
		forward.setRedirect(true);
			
		return forward;
	}

}
