package com.basket.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.admin.goods.db.GoodsDTO;

public class BasketDAO {
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
	
	
	
	
	// checkGoods
	public int checkGoods(BasketDTO bkDTO){
		int result = 0;
		
		
		try {
			conn = getConnection();
			// 전달 받은 옵션값들(b_g_num, b_g_color, b_g_size, b_m_id) 사용하여 
			// 기존에 추가된 상품이 있는지 체크 => 상품이 있을 때(1) + 상품 수량 업데이트
			//									==> 상품이 없을 때, 0 리턴
			sql = "select * from itwill_basket where b_g_num=? and b_g_color=? and b_g_size=? and b_m_id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bkDTO.getB_g_num());
			pstmt.setString(2, bkDTO.getB_g_color());
			pstmt.setString(3, bkDTO.getB_g_size());
			pstmt.setString(4, bkDTO.getB_m_id());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				//result = 1;
				
				// 장바구니 상품의 정보 수량 수정
				sql = "update itwill_basket set b_g_amount= b_g_amount + ? where b_m_id=? and b_g_num=? and b_g_color=? and b_g_size=? ";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, bkDTO.getB_g_amount());
				pstmt.setString(2, bkDTO.getB_m_id());
				pstmt.setInt(3, bkDTO.getB_g_num());
				pstmt.setString(4, bkDTO.getB_g_color());
				pstmt.setString(5, bkDTO.getB_g_size());
				
				result = pstmt.executeUpdate();
				
			}
			
			System.out.println("[BasketDAO] 장바구니 상품 체크 완료 " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	// checkGoods
	
	
	
	
	// basketAdd(bkDTO) : 장바구니 추가 - 
	public void basketAdd(BasketDTO bkDTO){
		// 장바구니 번호
		int b_num = 0;
		
		try {
			conn = getConnection();		
			//상품 번호 계산 : 기존의 장바구니가 있으면 해당번호 + 1
			sql = "select max(b_num) from itwill_basket";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			
			// 장바구니 번호 + 1
			if(rs.next()){
				b_num = rs.getInt(1)+1;
			}
			
			System.out.println("DAO : 장바구니 번호 " + b_num);
			
			// 상품을 장바구니에 추가
			sql = "insert into itwill_basket values(?,?,?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, b_num);
			pstmt.setString(2, bkDTO.getB_m_id());
			pstmt.setInt(3, bkDTO.getB_g_num());
			pstmt.setInt(4, bkDTO.getB_g_amount());
			pstmt.setString(5, bkDTO.getB_g_size());
			pstmt.setString(6, bkDTO.getB_g_color());
			
			pstmt.executeUpdate();
			
			System.out.println("[BasketDAO] 장바구니 추가 완료 ! ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	} 
	
	// basketAdd(bkDTO)	
	
	
	
	
	// getBasketList : 장바구니 목록
	// 서버 쪽에 list 형태 데이터 저장해야한다면 vector 쓰는게 좋음	
	public Vector getBasketList(String id) {
		// <장바구니 정보(List) + 상품정보(list)> (상품이름, 가격, 이미지 ... )
		// Vector [[장바구니 정보 List][상품정보 List]]
		Vector  totalVector = new Vector();
		
		List basketList = new ArrayList();
		List goodsList = new ArrayList();
		
		
		try {
			// id에 해당하는 장바구니 정보 저장
			conn = getConnection();
			sql = "select * from itwill_basket where b_m_id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			
				// * 장바구니가 있을 때마다 장바구니의 상품정보를 추가적으로 저장해야함
				while(rs.next()) {
					BasketDTO bkDTO = new BasketDTO();
					bkDTO.setB_date(rs.getDate("b_date"));
					bkDTO.setB_g_amount(rs.getInt("b_g_amount"));
					bkDTO.setB_g_color(rs.getString("b_g_color"));
					bkDTO.setB_g_num(rs.getInt("b_g_num"));
					bkDTO.setB_g_size(rs.getString("b_g_size"));
					bkDTO.setB_m_id(rs.getString("b_m_id"));
					bkDTO.setB_num(rs.getInt("b_num"));
					
					// 장바구니 List 한칸에 저장 하기
					basketList.add(bkDTO);
					
					// 장바구니 상품에 해당하는 정보 저장(이름, 가격, 이미지...)
					//* 기존의 데이터를 사용하는데 문제없이 쓰기 위해서
					// pstmt2, rs2 객체를 생성
					sql = "select * from itwill_goods where num=?";
					PreparedStatement pstmt2 = conn.prepareStatement(sql);
					pstmt2.setInt(1, bkDTO.getB_g_num());
					
					ResultSet rs2 = pstmt2.executeQuery();
					
					if(rs2.next()){
						// 장바구니에 상품 정보가 있을 때
						GoodsDTO gdto = new GoodsDTO();
						gdto.setName(rs2.getString("name"));
						gdto.setPrice(rs2.getInt("price"));
						gdto.setImage(rs2.getString("image"));
						
						// 추가정보 필요시 저장
						
						// 상품 리스트 한칸에 저장
						goodsList.add(gdto);
					} 
					
					System.out.println("[BasketDAO] 상품 정보 저장 완료!");
				} 
				
				
				
				// while문이 다시 올라갈때, rs값은 이미 바뀌어버려서 결과값은 하나밖에 안나온다 -> 수정해줘야함 
				// -> 어캐?
			 // while
				
			
			totalVector.add(basketList);
			totalVector.add(goodsList);
			System.out.println("[BasketDAO] 장바구니 저장 및 상품 정보 저장 완료!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return totalVector;
	}
	
	
	public void basketDelete(int b_num) {
		
		
		try {
			conn = getConnection();
			sql = "delete from itwill_basket where b_num=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, b_num);
			
			pstmt.executeUpdate();
			System.out.println("DAO: 회원 장바구니 정보 삭제 완료 !");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}
	
	
	
	// 구매 후 장바구니 전체 제거하는 메소드
	public void basketDelete(String id) {	
		try {
			conn = getConnection();
			// 구매 후 아이디에 해당하는 모든 장바구니 초기화
			sql = "delete from itwill_basket where b_m_id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			System.out.println("DAO : 구매 후 장바구니제거 ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		
	}
}
