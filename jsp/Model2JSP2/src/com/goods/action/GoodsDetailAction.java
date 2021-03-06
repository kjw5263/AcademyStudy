package com.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goods.db.GoodsDAO;

public class GoodsDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : GoodsDetailAction_execute() 호출 ");
		
		// 상품 상세 페이지
		// 전달된 파라미터값 저장
		int num = Integer.parseInt(request.getParameter("num"));
		
		// DAO 객체 생성 - getGoods(num);
		GoodsDAO gdao = new GoodsDAO();
		gdao.getGoods(num);
		
		// DB 에서 가조온 정보 저장
		request.setAttribute("goods", gdao.getGoods(num));
		
		
		// DB에서 가져온 정보를 저장 (request 영역에 저장)
		// 페이지 이동 (./goods/goods_detail.jsp)
		ActionForward forward = new ActionForward();
		forward.setPath("./goods/goods_detail.jsp");
		forward.setRedirect(false);
		
		
		
		return forward;
	}

}
