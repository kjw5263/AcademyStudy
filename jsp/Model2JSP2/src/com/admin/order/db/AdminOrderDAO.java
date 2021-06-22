package com.admin.order.db;

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

import com.order.db.OrderDTO;

public class AdminOrderDAO {
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
		// 1, 2단계 - 드라이버 로드, DB 연결
		// Connection Pool을 사용하지 않을 때, 
/*		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(DBURL, DBID, DBPW);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		
		
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
	
	
	
	// getAdminOrderList()
	public List getAdminOrderList(String id) {
		List adminOrderList = new ArrayList();
		
		
		try {
			conn = getConnection();
			sql = "select o_trade_num, o_g_name, o_g_amount, o_g_size, o_g_color, sum(o_sum_money) as o_sum_money, o_trans_num, o_date, o_status, o_trade_type, o_m_id from itwill_order "
					+ "where o_m_id=? group by o_trade_num order by o_trade_num desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				OrderDTO orDTO = new OrderDTO();
				
				orDTO.setO_date(rs.getDate("o_date"));
				orDTO.setO_g_amount(rs.getInt("o_g_amount"));
				orDTO.setO_g_color(rs.getString("o_g_color"));
				orDTO.setO_g_name(rs.getString("o_g_name"));
				orDTO.setO_g_size(rs.getString("o_g_size"));
				orDTO.setO_trade_num(rs.getString("o_trade_num"));
				orDTO.setO_trans_num(rs.getString("o_trans_num"));
				orDTO.setO_sum_money(rs.getInt("o_sum_money"));
				orDTO.setO_status(rs.getInt("o_status"));
				orDTO.setO_trade_type(rs.getString("o_trade_type"));
				orDTO.setO_m_id(rs.getString("o_m_id"));
				
				// 리스트 한칸에 주문 정보 객체 1개 저장
				
				adminOrderList.add(orDTO);
			}
			
			System.out.println("");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return adminOrderList;
	}
	// getAdminOrderList()
	
	
	
	
	// getAdminOrderDetail(trade_num)
	public List getAdminOrderDetail(String trade_num){
		List adminOrderDetail = new ArrayList();
		
		
		try {
			conn = getConnection();
			sql = "select * from itwill_order where o_trade_num=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, trade_num);
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				OrderDTO orDTO = new OrderDTO();
				
				orDTO.setO_date(rs.getDate("o_date"));
				orDTO.setO_g_amount(rs.getInt("o_g_amount"));
				orDTO.setO_g_color(rs.getString("o_g_color"));
				orDTO.setO_g_name(rs.getString("o_g_name"));
				orDTO.setO_g_size(rs.getString("o_g_size"));
				orDTO.setO_trade_num(rs.getString("o_trade_num"));
				orDTO.setO_trans_num(rs.getString("o_trans_num"));
				orDTO.setO_sum_money(rs.getInt("o_sum_money"));
				orDTO.setO_status(rs.getInt("o_status"));
				orDTO.setO_trade_type(rs.getString("o_trade_type"));
				orDTO.setO_receive_name(rs.getString("o_receive_name"));
				orDTO.setO_receive_phone(rs.getString("o_receive_phone"));
				orDTO.setO_receive_addr1(rs.getString("o_receive_addr1"));
				orDTO.setO_receive_addr2(rs.getString("o_receive_addr2"));
				orDTO.setO_receive_msg(rs.getString("o_receive_msg"));
				
				// 리스트 한칸에 주문 정보 객체 1개 저장
				
				adminOrderDetail.add(orDTO);
			} //while
			
			System.out.println("DAO : 주문 번호에 해당하는 상품 모두 저장 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return null;
	}
	// getAdminOrderDetail(trade_num)
	
	
	
	
	// updateOrder
	public void updateOrder(OrderDTO orderDTO) {
		try {
			conn = getConnection(); 
			sql = "update itwill_order set o_status=?, o_trans_num=? where o_trade_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  orderDTO.getO_status());
			pstmt.setString(2, orderDTO.getO_trans_num());
			pstmt.setString(3, orderDTO.getO_trade_num());
			pstmt.executeUpdate();
			
			System.out.println("DAO : 주문상태, 운송장 ㅈ번호 수정 완료");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
	}
	
	//updateOrder
	
	
}
