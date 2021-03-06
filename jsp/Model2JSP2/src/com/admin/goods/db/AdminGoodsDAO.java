package com.admin.goods.db;

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

public class AdminGoodsDAO {
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
	
	
	// insertGoods(gdto)
	public void insertGoods(GoodsDTO gdto){
		int num = 0;
		
		try {
			// 1 . 상품 번호 계산 
			conn  = getConnection();
			sql = "select max(num) from itwill_goods";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			// "select max(num) from itwill_goods"
			// sql 내장함수 호출하는 경우, 항상 커서가 존재함(rs.next()== true)
			// 따라서 rs.next()가 없을 경우인 else 부분은 사실상 불필요한 코드임 
			// select num from itwill_goods
			// => 값이 없을 경우 null 표시, 커서는 X(rs.next() == false)
			
			if(rs.next()){ // 데이터가 있을 때, 커서는 > 모양임!!
				num = rs.getInt(1)+1;
				// num = rs.getInt("max(num)")+1;
			}
			// else {} 
			System.out.println("DAO : 상품번호 = " + num);
			
			// 2. 상품 등록
			sql = "insert into itwill_goods(num,category,name,content,size,color,amount,price,image,best,date) "
					+ "values(?,?,?,?,?,?,?,?,?,?,now())";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, gdto.getCategory());
			pstmt.setString(3, gdto.getName());
			pstmt.setString(4, gdto.getContent());
			pstmt.setString(5, gdto.getSize());
			pstmt.setString(6, gdto.getColor());
			pstmt.setInt(7, gdto.getAmount());
			pstmt.setInt(8, gdto.getPrice());
			pstmt.setString(9, gdto.getImage());
			pstmt.setInt(10, gdto.getBest());
			
			pstmt.executeUpdate();
			
			System.out.println("DAO : 관리자 상품 등록 완료! ");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		// 2. 상품 등록
	}
	// insertGoods(gdto)
	
	
	// getGoodsList()
	public List getGoodsList(){
		List goodsList = new ArrayList();
		
		
		try {
			conn = getConnection();
			sql = "select * from itwill_goods";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				// 데이터 있을 때
				// rs(row) -> DTO 객체 하나에 저장
				GoodsDTO dto = new GoodsDTO();
				dto.setNum(rs.getInt("num"));
				dto.setAmount(rs.getInt("amount"));
				dto.setBest(rs.getInt("best"));
				dto.setCategory(rs.getString("category"));
				dto.setColor(rs.getString("color"));
				dto.setContent(rs.getString("content"));
				dto.setDate(rs.getDate("date"));
				dto.setImage(rs.getString("image"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getInt("price"));
				dto.setSize(rs.getString("size"));
				
				goodsList.add(dto);
			}
			
			System.out.println("DAO : 관리자 상품 리스트 저장 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return goodsList;
	}
	// getGoodsList()
	
	
	
	//getGoods(num) : 상품 정보 가져오기
	public GoodsDTO getGoods(int num){
		GoodsDTO dto = null;
		
		try {
			conn = getConnection();
			sql = "select * from itwill_goods where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dto = new GoodsDTO();
				
				dto.setNum(rs.getInt("num"));
				dto.setAmount(rs.getInt("amount"));
				dto.setBest(rs.getInt("best"));
				dto.setCategory(rs.getString("category"));
				dto.setColor(rs.getString("color"));
				dto.setContent(rs.getString("content"));
				dto.setDate(rs.getDate("date"));
				dto.setImage(rs.getString("image"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getInt("price"));
				dto.setSize(rs.getString("size"));
				
			}	// if
			System.out.println("DAO : 수정할 상품 정보를 저장 완료 ! ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		
		return dto;
	}
	//getGoods(num)
	
	
	public void modifyGoods(GoodsDTO gdto){
		
		try {
			conn = getConnection();
			sql = "update itwill_goods set category=?,name=?,price=?,color=?,amount=?,size=?,best=?,content=? where num=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, gdto.getCategory());
			pstmt.setString(2, gdto.getName());
			pstmt.setInt(3, gdto.getPrice());
			pstmt.setString(4, gdto.getColor());
			pstmt.setInt(5, gdto.getAmount());
			pstmt.setString(6, gdto.getSize());
			pstmt.setInt(7, gdto.getBest());
			pstmt.setString(8, gdto.getContent());
			pstmt.setInt(9, gdto.getNum());
			
			pstmt.executeUpdate();
			
			System.out.println("상품정보 수정 완료!!!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		
	}
	
	
	/*
	 * @메소드명 : deleteGoods
	 * @메소드 기능 : 상품번호를 받아서 상품 삭제
	 * @param : 상품정보 num
	 * @return 없음
	 */
	// deleteGoods(num)
	public void deleteGoods(int num){
		
		try {
			conn = getConnection();
			sql = "delete from itwill_goods where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			System.out.println("DAO : 관리자 상품정보 삭제 완료 ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
	}
	// deleteGoods(num)
	
	
	
}
