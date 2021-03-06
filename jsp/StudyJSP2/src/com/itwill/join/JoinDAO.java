package com.itwill.join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JoinDAO {
	// Data Access Object : DB 데이터 처리 객체
		// => DB에 관한 모든 동작을 하는 객체!
		
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
				DataSource ds = (DataSource) initCTX.lookup("java:comp/env/jdbc/mysqlDB");	// 다운캐스팅
				
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
		
		
		public int onMemberInsert(JoinBean jb) {
			int check = -1;
			
			try {
				conn = getConnection();
				sql ="insert into itwill_join value(?,?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, jb.getId());
				pstmt.setString(2, jb.getPass1());
				pstmt.setString(3, jb.getName());
				pstmt.setString(4, jb.getJumin());
				pstmt.setString(5, jb.getGender());
				pstmt.setString(6, jb.getHobby());
				pstmt.setString(7, jb.getSubject());
				pstmt.setString(8, jb.getComment());
				
				check = pstmt.executeUpdate();
				System.out.println("check >> " + check);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}
			
				
			
			return check;
		}
		
}
