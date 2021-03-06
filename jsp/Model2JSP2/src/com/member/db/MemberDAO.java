package com.member.db;

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

public class MemberDAO {
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
	
	// insertMember(mdto)
	public void insertMember(MemberDTO mdto){
		// 1, 2, 디비 연결
		// 3 sql 작성 & pstmt 객체 생성
		// 4 sql 실행
		
		try {
			conn = getConnection();
			sql = "insert into itwill_member (id,pass,name,age,gender,email,reg_date) "
					+ "values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mdto.getId());
			pstmt.setString(2, mdto.getPass());
			pstmt.setString(3, mdto.getName());
			pstmt.setInt(4, mdto.getAge());
			pstmt.setString(5, mdto.getGender());
			pstmt.setString(6, mdto.getEmail());
			pstmt.setTimestamp(7, mdto.getReg_date());
			
			pstmt.executeUpdate();
			
			System.out.println("DAO : 회원가입 완료 !");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
	}
	// insertMember(mdto)
	
	
	
	// idCheck(id, pass)
	public int idCheck(String id, String pass){
		int check = -1;
		
		try {
			conn = getConnection();
			sql = "select pass from itwill_member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				if(pass.equals(rs.getString("pass"))){
					check=1;
				}else {				
					check=0;    // 비번 틀림
				}
			} else {
				// 회원정보 X
				check = -1;
			}
			
			System.out.println("DAO : 로그인 처리 결과 " + check);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		
		
		return check;
	}
	// idCheck(id,pass)
	
	
	
	// getMember(id)
	public MemberDTO getMember(String id){
		MemberDTO dto = null;
		try {
			// 1, 2 디비 연결
			conn = getConnection();
			
			// 3 sql & pstmt 객체
			sql = "select * from itwill_member where id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			// 4. sql 실행			
			rs = pstmt.executeQuery();
			
			// 5. 데이터 처리
			if(rs.next()){
				dto = new MemberDTO();
				dto.setAge(rs.getInt("age"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("gender"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPass(rs.getString("pass"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
				
			}
			
			System.out.println("DAO : 회원정보 저장완료! ");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		
		
		return dto;
	}
	
	// getMember(id)
	
	
	
	
	//UpdateMember(mdto)
	public int UpdateMember(MemberDTO mdto){
		int check = -1;
		
		
		try {
			conn = getConnection();
			sql ="select pass from itwill_member where id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mdto.getId());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				if(mdto.getPass().equals(rs.getString("pass"))){
					sql ="update itwill_member set email=?, gender=?, name=? , age=? where id=? ";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, mdto.getEmail());
					pstmt.setString(2, mdto.getGender());
					pstmt.setString(3, mdto.getName());
					pstmt.setInt(4, mdto.getAge());
					pstmt.setString(5, mdto.getId());
					pstmt.executeUpdate();
					check = 1;
				}else {
					check = 0;
				}
				
			} else {
				check = -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		System.out.println(check);
		return check;
	}
	
	// UpdateMember(mdto)
	
	
	
	
	
	
	public int deleteMember(String id, String pass) {
		int result = -1;
		
		
		try {
			// 1,2 디비 연결
			conn = getConnection();
			// 3 sql 구문(select), & pstmt 객체 생성
			sql = "select pass from itwill_member where id=?";
			pstmt = conn.prepareStatement(sql);
			// 4 sql 실행
			// 5 데이터 처리
			//    3 sql 구문 (delete ) & pstmt 객체
			//	  4 sql 실행

			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				if(pass.equals(rs.getString("pass"))){
					// 3 sql 구문 (delete) & pstmt 객체
					sql = "delete from itwill_member where id=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					// 4 sql 실행
					result = pstmt.executeUpdate();
				} else {
					result = 0;
				}
			} else {
				result = -1;
			}
			
			System.out.println("DAO : 회원정보 삭제 완료 ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		
		
		return result;
	}
	
	
	// getMemberList()
	public List getMemberList() {
		// 업ㅂ캐스팅 하는 이유 
		// 부모 클래스의 메소드를 사용하거나, 전달했을 때 좀더 쉽게 전달이 가능하기 때문
		List memberList = new ArrayList();
		
		try {
			// 1,2 디비 연결
			conn = getConnection();
			// 3 sql 연결 & pstmt 객체 생성
			sql = "select * from itwill_member where id != 'admin'";
			// 4 sql 실행
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 5 데이터 처리
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setAge(Integer.parseInt(rs.getString("age")));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("Gender"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPass(rs.getString("pass"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
				
				// 리스트 한칸 -> 1명정보 저장 
				memberList.add(dto);
			}
			System.out.println("DAO : 모든 회원 정보 저장 완료 ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		
		return memberList;
	}
	// getMemberList()
}
