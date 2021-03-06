package com.admin.goods.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.goods.db.AdminGoodsDAO;
import com.admin.goods.db.GoodsDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

// 같은 패키지 내의 Action을 구현하도록 하기
public class GoodsAddAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : GoodsAddAction_execute() 호출");
		
		// 파일 업로드 우선!
		// upload 폴더 생성
		
		// ServletContext : 내 프로젝트 정보
		// request.getRealPath("/upload");	// 권장하지 않는 방법
		ServletContext ctx = request.getServletContext();
		String realpath = ctx.getRealPath("/upload");
		
		int maxSize = 5 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(
				request,
				realpath,
				maxSize,
				"UTF-8",
				new DefaultFileRenamePolicy() 
				);
		
		//new DefaultFileRenamePolicy() : 중복된 이름 있을 때 name(1), name(2)식으로 작명
		
		System.out.println("M : 파일 업로드 완료 ! ");
		
		// 나머지 전달 정보를 DB에 저장
		// GoodsDTO 객체 생성 후 전달된 정보를 저장
		GoodsDTO gdto= new GoodsDTO();
		gdto.setAmount(Integer.parseInt(multi.getParameter("amount")));
		gdto.setBest(0); 	// 0-일반상품, 1-인기상품
		gdto.setCategory(multi.getParameter("category"));
		gdto.setColor(multi.getParameter("color"));
		gdto.setContent(multi.getParameter("content"));
		gdto.setName(multi.getParameter("name"));
		gdto.setPrice(Integer.parseInt(multi.getParameter("price")));
		gdto.setSize(multi.getParameter("size"));
		
		String image = multi.getFilesystemName("file1")	+ ","
					+ multi.getFilesystemName("file2") + ","
					+ multi.getFilesystemName("file3") + ","
					+ multi.getFilesystemName("file4");
		gdto.setImage(image);
		
		System.out.println("M = 이미지 정보 : " + image);
		
		
		// AdminGoodsDAO 객체 생성
		AdminGoodsDAO  agdao = new AdminGoodsDAO();
		agdao.insertGoods(gdto);
		
		
		// 페이지 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./AdminGoodsList.ag");
		forward.setRedirect(true); // -> 주소가 바뀌면서 화면도 바뀌기 때문에 redirect 방식으로 보냄!
		
		return forward;
	}
	
	

}
