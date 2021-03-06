package com.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goods.db.GoodsDAO;

public class GoodsListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("C : GoodsListAction_execute() 호출!");
		
		
		// 파라미터를 처리 : goods_list.jsp에서 선택한 옷의 카테고리
		request.setCharacterEncoding("UTF-8");
		// 파라미터를 처리
		// item =best
		String item = request.getParameter("item");
		
		if(item == null ){
			item="all";
		} 
		
		// 디비 처리 객체 DAO 생성
		GoodsDAO gdao = new GoodsDAO();
		
		// 정보 저장 -> 영역 저장도 가능
		// 현재 페이지에서 사용할 경우에 변수에 담아놓고 사용하는 것이지, 사용하지 않을 경우는 바로 써주기
		//request.setAttribute("goodsList", gdao.getGoodsList());
		request.setAttribute("goodsList", gdao.getGoodsList(item));
		
		// 페이지 이동 
		
		ActionForward forward  = new ActionForward();
		forward.setPath("./goods/goods_list.jsp");	// list가 jsp 뷰에 뿌려줘야하기 때문에 jsp 로 넘어가기~
		forward.setRedirect(false);
		return forward;
	}

}
