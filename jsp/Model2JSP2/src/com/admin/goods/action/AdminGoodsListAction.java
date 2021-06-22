package com.admin.goods.action;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.goods.db.AdminGoodsDAO;

public class AdminGoodsListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 상품 등록 후 넘어오는 화면!!
		System.out.println("M : AdminGoodsListAction_execute() 호출 ");
		
		// AdminGoodsDAO 객체 생성
		// getGoodsList();
		
		AdminGoodsDAO agdao = new AdminGoodsDAO();
		List goodsList = agdao.getGoodsList();
		System.out.println("아아아아아아 : " + goodsList);
		// 결과를 받아왔으니 출력할 정보를 가지고 페이지 이동!!!
		request.setAttribute("goodsList", goodsList);
		
		// 이런식으로 전달 해줄 때는 forward 형식으로 전달해주어야함
		ActionForward forward = new ActionForward();
		
		forward.setPath("./admingoods/admin_goods_list.jsp");
		forward.setRedirect(false);	// jsp로 가야하기도 하고, request 정보를 전달해야하기 때문에!!
		//  이 전달된 request정보는 (리턴되는 포워드 값은 ~~ Controller 로 다시 전달되어)
		
		return forward;
	}

}
