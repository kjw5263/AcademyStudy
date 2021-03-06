package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Vector;

public class MemberDAO {
	
	// 접속할 오라클 DBMS DB 서버주소
	String url = "jdbc:oracle:thin:@192.168.2.4:1521:XE";
	
	// 접속할 ID, PASS 저장
	String dbid = "system", dbpass="1234";
	
	Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql ="";
	
	// getConn 메소드 시작
	public void getConn() {
		try{
			Class.forName("oracle.jdbc.drivcer.OracleDriver");
			
			conn = DriverManager.getConnection(url, dbid, dbpass);
		} catch(Exception e){
			System.out.println("오라클 드라이버 등록 실패"+e);
		}
	}
	// getConn 메소드 끝
	
	
	// 실제 앱에서 입력한 회원정보들을 DB에 추가시키기
	public void insertMember(MemberBean bean){
		// Connection을 얻기 위해 getConn() 메소드 호출
		getConn();
		
		try {
			pstmt = conn.prepareStatement("insert into member values(?,?,?,?,?)");
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPass());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getPhone());
			pstmt.setString(5, bean.getEmail());
			
			pstmt.executeUpdate();
			
			// 자원해제
			pstmt.close();
			conn.close();
			
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	// insertMember() 메소드 끝
	
	
	
	// getAllMember()
	public Iterator<MemberBean> getAllMember(){
		getConn();
		
		// SQL 준비
		sql = "select * from member";
		MemberBean bean; 
		
		Vector<MemberBean> vec = new Vector<MemberBean>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				bean = new MemberBean();
				
				bean.setId(rs.getString("id"));
				bean.setPass(rs.getString("pass"));
				bean.setName(rs.getString("name"));
				bean.setPhone(rs.getString("phone"));
				bean.setEmail(rs.getString("email"));
				
				vec.add(bean);
			}
			// 자원 해제 
			rs.close();
			pstmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return vec.iterator(); // MemberBean 객체들이 저장되어있는 iterator 배열을 리턴
	}
	// getAllMember()
	
} //MemberDAO 클래스 끝

