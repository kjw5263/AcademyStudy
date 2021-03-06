package com.goods.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.admin.goods.db.GoodsDTO;
import com.basket.db.BasketDTO;

public class GoodsDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = "";
	
	
	//-----------DB 드라이버 정보--------------------
	/*final String DRIVER = "com.mysql.jdbc.Driver";
	final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
	final String DBID = "root";
	final String DBPW = "1234";*/
	
	
	private Connection getConnection() {
		// 커넥션 풀 (Connection pool) : 미리 연결정보(connection)을 생성해서 저장 후 사용(pool) -> 사용 후 반납
		// Context 객체를 생성 (현재 프로젝트 정보를 가지고 있는 객체)
		try {
			Context initCTX = new InitialContext();	 //얘는 인터페이스(부모)!인데 객체 생성(자식)-> 업캐스팅(상속)
			
			// DB 연동 정보를 불러오기 (context.xml)
			DataSource ds = (DataSource) initCTX.lookup("java:comp/env/jdbc/model2DB");	// 다운캐스팅
			
			conn = ds.getConnection();
			
			System.out.println("드라이버 로드, 디비 연결 성공!");
			System.out.println(conn);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return conn;
	}
	
	
	// 자원 해제 코드
	public void closeDB() {
		// 자원 해제
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// getGoodsList() 
	public List getGoodsList(){
		List goodsList = new ArrayList();
		
		
		try {
			
			conn = getConnection();
			sql = "select * from itwill_goods";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				GoodsDTO dto = new GoodsDTO();
				dto.setAmount(rs.getInt("amount"));
				dto.setBest(rs.getInt("best"));
				dto.setCategory(rs.getString("category"));
				dto.setColor(rs.getString("color"));
				dto.setContent(rs.getString("content"));
				dto.setImage(rs.getString("image"));
				dto.setName(rs.getString("name"));
				dto.setNum(rs.getInt("num"));
				dto.setPrice(rs.getInt("price"));
				dto.setSize(rs.getString("size"));
				dto.setDate(rs.getDate("date"));
				
				// 리스트 한칸에 상품 1개를 저장
				goodsList.add(dto);
				
			}
			
			System.out.println("DAO : 상품 정보 저장완료(일반 사용자 상품 목록)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return goodsList;
	}
	// getGoodsList()
	
	
	
	
	// 메소드 오버로딩
	// getGoodsList() 
	public List getGoodsList(String item){
		// item에 따라서 다른결과를 처리해야함
		// item = all/best/그외 카테고리
		List goodsList = new ArrayList();
		
		StringBuffer SQL = new StringBuffer();	// String/StringBuffer차이? Buffer라는 저장공간 유무==> 문자열 변경 사항이 저장된다!
		
		
		try {
			
			conn = getConnection();
			//sql = "select * from itwill_goods";
			SQL.append("select * from itwill_goods");
			if(item.equals("all")){
				
			} else if(item.equals("best")){
				SQL.append(" where best=?");
			} else {
				SQL.append(" where category=?");
			}
			pstmt = conn.prepareStatement(SQL.toString());
			
			// ?
			if(item.equals("all")){
				// 전체를 보여주는 것이니 비워두면 됨! 
			} else if(item.equals("best")){
				pstmt.setInt(1, 1); // 인기상품 1, 일반상품 0
			} else {
				pstmt.setString(1, item);
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				GoodsDTO dto = new GoodsDTO();
				dto.setAmount(rs.getInt("amount"));
				dto.setBest(rs.getInt("best"));
				dto.setCategory(rs.getString("category"));
				dto.setColor(rs.getString("color"));
				dto.setContent(rs.getString("content"));
				dto.setImage(rs.getString("image"));
				dto.setName(rs.getString("name"));
				dto.setNum(rs.getInt("num"));
				dto.setPrice(rs.getInt("price"));
				dto.setSize(rs.getString("size"));
				dto.setDate(rs.getDate("date"));
				
				// 리스트 한칸에 상품 1개를 저장
				goodsList.add(dto);
				
			}
			
			System.out.println("DAO : 상품 정보 저장완료(일반 사용자 상품 목록)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return goodsList;
	}
	// getGoodsList()
	
	
	
	// 상품의 상세정보 받아와야 하므로 리턴정보는 GoodsDTO
	public GoodsDTO getGoods(int num ) {
		GoodsDTO goods = null;
		
		try {
			conn = getConnection();
			sql = "select * from itwill_goods where num=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				goods = new GoodsDTO();
				goods.setName(rs.getString("name"));
				goods.setCategory(rs.getString("category"));
				goods.setBest(rs.getInt("best"));
				goods.setAmount(rs.getInt("amount"));
				goods.setColor(rs.getString("color"));
				goods.setContent(rs.getString("content"));
				goods.setImage(rs.getString("image"));
				goods.setDate(rs.getDate("date"));
				goods.setPrice(rs.getInt("price"));
				goods.setSize(rs.getString("size"));
				goods.setNum(rs.getInt("num"));
			}
			
			System.out.println("DAO : 상품 1개 정보 저장완료 ");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return goods;
		
	}
	
	
	public void updateAmount(List basketList) {
		conn = getConnection();

		try {
			// 주문한 상품 개수만큼 반복 돌리면서 개수 차감해주기
			for(int i=0; i<basketList.size(); i++){
				BasketDTO bkDTO = (BasketDTO)basketList.get(i);
				// 상품번호에 해당하는 장바구니 상품의 개수만큼 차감
				sql = "update itwill_goods set amount= amount-? where num=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bkDTO.getB_g_amount());  // 상품의 개수
				pstmt.setInt(2, bkDTO.getB_g_num());	// 상품 번호
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
			
			
		
		
	}
	
	
	
	
	
}
