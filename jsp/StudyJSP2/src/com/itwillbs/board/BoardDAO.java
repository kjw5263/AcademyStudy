package com.itwillbs.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO {
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
	
	/* 글쓰기 동작 => 메소드 insertBoard() start */
	public void insertBoard(BoardBean bb) {
		int num = 0;
		// BoardBean을 받아오는 이유? -> 작성받아온 글 내용이 있어야 insert를 하니까!
		try {
			// 1드라이버 로드,  2디비연결
			conn = getConnection();
			
			// (추가) 3. sql (글번호 계산하는 구문 )
			sql = "select max(num) from itwill_board";
			pstmt = conn.prepareStatement(sql);
			
			// 4. sql 쿼리 실행
			ResultSet rs = pstmt.executeQuery();	// 아직 DB에 입력하기 전!! 번호만 받아오는 과정
			
			//5. 데이터 처리
			// max(num) - sql 함수를 실행했을 경우 커서 이동 가능여부를 확인(데이터 유무 상관없음)
			// rs는 커서를 내릴 수 잇느냐를 판단하는 것, 
			// num      - sql 컬럼의 경우 커서 이동 불가능
			if(rs.next()){
				//num = rs.getInt("max(num)")+1;
				num = rs.getInt(1)+1;       // max(num)를 받아오는 쿼리문의 결과는 1개의 값 뿐이므로, 그값+1 
			}
			
			System.out.println("글 번호 : " + num);
			//////////////////////////////////////////////////////
			// 3sql작성 (insert) & pstmt객체 생성
			sql = "insert into itwill_board"
					+ " values(?,?,?,?,?,?,?,?,?,now(),?,?)";
			// 4sql 실행
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);	// 글 번호 -> 이걸 어떻게 할까?
			pstmt.setString(2, bb.getName());
			pstmt.setString(3, bb.getPass());
			pstmt.setString(4, bb.getSubject());
			pstmt.setString(5, bb.getContent());
			pstmt.setInt(6, bb.getReadcount());
			pstmt.setInt(7, num);	// re_ref에 글번호 num저장
			pstmt.setInt(8, bb.getRe_lev());
			pstmt.setInt(9, bb.getRe_seq());
			pstmt.setString(10, bb.getIp());
			pstmt.setString(11, bb.getFile());
			
			pstmt.executeUpdate();
			System.out.println("SQL 실행 완료 : 글쓰기 성공! ");
		} catch (SQLException e) {
			System.out.println("SQL 연결 실패 " + e.getMessage());
			e.printStackTrace();
		} finally {
			// 자원 해제
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}  
	/* 글쓰기 동작 => 메소드 insertBoard() end */
	
	
	/* 글쓰기 동작 => 메소드 insertBoard() start 
	public void insertBoard(BoardBean bb) {
		// BoardBean을 받아오는 이유? -> 작성받아온 글 내용이 있어야 insert를 하니까!
		
		try {
			// 1드라이버 로드
			Class.forName(DRIVER);
			// 2디비연결
			conn = DriverManager.getConnection(DBURL, DBID, DBPW);
			// 3sql작성 (insert) & pstmt객체 생성
			sql = "insert into itwill_board"
					+ " values(?,?,?,?,?,?,?,?,?,now(),?,?)";
			// 4sql 실행
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);	// 글 번호
			pstmt.setString(2, bb.getName());
			pstmt.setString(3, bb.getPass());
			pstmt.setString(4, bb.getSubject());
			pstmt.setString(5, bb.getContent());
			pstmt.setInt(6, bb.getReadcount());
			pstmt.setInt(7, bb.getRe_ref());
			pstmt.setInt(8, bb.getRe_lev());
			pstmt.setInt(9, bb.getRe_seq());
			pstmt.setString(10, bb.getIp());
			pstmt.setString(11, bb.getFile());
			
			pstmt.executeUpdate();
			System.out.println("SQL 실행 완료 : 글쓰기 성공! ");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패 " + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL 연결 실패 " + e.getMessage());
			e.printStackTrace();
		}

	}  
	 글쓰기 동작 => 메소드 insertBoard() end */
	
	
	// getBoardCount(); : DB에 들어있는 글의 개수 계산 후 리턴하는 메소드
	public int getBoardCount() {
		int cnt = 0;
		
		try {
			//1,2 드라이버 로드, 디비 연결
			conn = getConnection();
			
			//3. sql 작성&pstmt 객체 생성
			sql = "select count(*) from itwill_board";
			pstmt = conn.prepareStatement(sql);
			
			//4. sql 실행
			ResultSet rs = pstmt.executeQuery();
			
			//5. 데이터 처리
			if(rs.next()){
				cnt = rs.getInt(1);	// "count(*)"
				// cnt = rs.getInt("count(*)");
			}
			
			System.out.println("SQL 구문 실행 완료");
			System.out.println("글 개수 : "+cnt + "개");
			
		} catch (Exception e) {
			System.out.println("[게시판 글 개수]_에러발생!");
			e.printStackTrace();
		} finally {
			// 자원 해제
			/*try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}*/
			closeDB();
		}
		
		
		
		
		return cnt;
	} // getBoardCount();
	
	
	
	
	
	// getBoardList()
	public ArrayList getBoardList() {
		// DB에 있는 내용을 -> BoardBean 객체에 저장 -> ArrayList(필통을 여러개 담는 가방 역할)
		// DB데이터 1row 정보를 BoardBean 저장 -> ArrayList 한칸에 저장
		
		// 게시판 글 정보 모두 저장하는 가변길이 배열
		ArrayList boardListAll = new ArrayList();
		
		// 게시판 글 1개의 정보를 저장하는 객체
		BoardBean bb = null;				
		//BoardBean bb = new BoardBean();
		
		
		
		try {

			// 1, 2 드라이버 로드, 디비 연결
			conn = getConnection();
			
			// 3. sql 구문 & pstmt 객체
			sql = "select * from itwill_board";
			
			pstmt = conn.prepareStatement(sql);
			
			// 4 sql 실행
			rs = pstmt.executeQuery();
			
			// 5 데이터 처리
			while(rs.next() ){
				// DB 데이터 있을 때 bb 객체 생성
				bb = new BoardBean();
				
				// DB 정보 -> Bean 저장
				bb.setContent(rs.getString("content"));
				bb.setDate(rs.getDate("date"));
				bb.setFile(rs.getString("file"));
				bb.setIp(rs.getString("ip"));
				bb.setName(rs.getString("name"));
				bb.setNum(rs.getInt("num"));
				bb.setPass(rs.getString("pass"));
				bb.setRe_lev(rs.getInt("re_lev"));
				bb.setRe_ref(rs.getInt("re_ref"));
				bb.setRe_seq(rs.getInt("re_seq"));
				bb.setReadcount(rs.getInt("readcount"));
				bb.setSubject(rs.getString("subject"));
				
				
				// Bean -> ArrayList 한칸에 저장
				boardListAll.add(bb);
			}
			
			System.out.println(" 게시파 모든 정보 저장 완료! ");
			System.out.println(" 총 " + boardListAll.size()+ " 개 ");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		System.out.println(boardListAll);
		
		return boardListAll;
	}
	// getBoardList()
	

	
	
	
	//getBoardList(startRow, pageSize)
	public ArrayList getBoardList(int startRow, int pageSize) {
		// DB에 있는 내용을 -> BoardBean 객체에 저장 -> ArrayList(필통을 여러개 담는 가방 역할)
		// DB데이터 1row 정보를 BoardBean 저장 -> ArrayList 한칸에 저장
		
		
		// 게시판 글 정보 모두 저장하는 가변길이 배열
		ArrayList boardList = new ArrayList();
		
		// 게시판 글 1개의 정보를 저장하는 객체
		BoardBean bb = null;				
		//BoardBean bb = new BoardBean();
		
		
		
		try {

			// 1, 2 드라이버 로드, 디비 연결
			conn = getConnection();
			
			// 3. sql 구문 & pstmt 객체
			// 	글 정보 정렬 - re_ref 값을 최신글 위쪽으로 정렬 (내림차순)
			// 			 - re_seq 값을 사용 오름차순
			//			 - limit a, b (a 시작행-1, b개수)
			// 			ex) 1번글 -> 0번 인덱스
			
			//sql = "select * from itwill_board";
			// sql 문 사이 공백 포함하기 주의!!!!
			sql = "select * from itwill_board "	
					+ "order by re_ref desc, re_seq asc "
					+ "limit ?, ?";
			
			pstmt = conn.prepareStatement(sql);
			
			// ?
			pstmt.setInt(1, startRow-1);	// 1번글이면 0번글 
			pstmt.setInt(2, pageSize);		// pageSize만큼 출력하겟다
			
			// 4 sql 실행
			rs = pstmt.executeQuery();
			
			// 5 데이터 처리
			while(rs.next() ){
				// DB 데이터 있을 때 bb 객체 생성
				bb = new BoardBean();
				
				// DB 정보 -> Bean 저장
				bb.setContent(rs.getString("content"));
				bb.setDate(rs.getDate("date"));
				bb.setFile(rs.getString("file"));
				bb.setIp(rs.getString("ip"));
				bb.setName(rs.getString("name"));
				bb.setNum(rs.getInt("num"));
				bb.setPass(rs.getString("pass"));
				bb.setRe_lev(rs.getInt("re_lev"));
				bb.setRe_ref(rs.getInt("re_ref"));
				bb.setRe_seq(rs.getInt("re_seq"));
				bb.setReadcount(rs.getInt("readcount"));
				bb.setSubject(rs.getString("subject"));
				
				
				// Bean -> ArrayList 한칸에 저장
				boardList.add(bb);
			}
			
			System.out.println(" 게시파 모든 정보 저장 완료! ");
			System.out.println(" 총 " + boardList.size()+ " 개 ");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		System.out.println(boardList);
		
		return boardList;
	}
	//getBoardList(startRow, pageSize);
	

	// updateReadCount(num) 글 조회수 올리기 메소드
	public void updateReadCount(int num) {
		
		try {
			// 디비연결
			conn = getConnection();
			sql = "update itwill_board set readcount = readcount+1 where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num); 	// ? 채우기
			pstmt.executeUpdate();
			
			System.out.println("글 조회수 증가 완료!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}
	
	
	// 글 가져오기 메소드 getBoard()
	public BoardBean getBoard(int num){
		BoardBean bb = null;
		try {
			// 1,2 디비 연결
			conn = getConnection();
			sql = "select * from itwill_board where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			
			
			if(rs.next()){
				bb = new BoardBean();
				bb.setContent(rs.getString("content"));
				bb.setDate(rs.getDate("date"));
				bb.setFile(rs.getString("file"));
				bb.setIp(rs.getString("ip"));
				bb.setName(rs.getString("name"));
				bb.setNum(rs.getInt("num"));
				bb.setPass(rs.getString("pass"));
				bb.setRe_lev(rs.getInt("re_lev"));
				bb.setRe_ref(rs.getInt("re_ref"));
				bb.setRe_seq(rs.getInt("re_seq"));
				bb.setReadcount(rs.getInt("readcount"));
				bb.setSubject(rs.getString("subject"));
				
				
			}
			
			System.out.println(" 해당 게시물 내용 가져오기 성공! ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		
		
		return bb;
	}
	
	// 글 가져오기 메소드 getBoard()
	
	
	
	// 글 수정하기 메소드 updateBoard() 
	public int updateBoard(BoardBean bb) {
		int check = -1;		// 에러가 생겼을 때 
		
		try {
			// 1,2 디비연결
			conn = getConnection();
			// 3 sql 작성(select를 통해 본인확인먼저 하기) & pstmt 객체
			sql = "select pass from itwill_board where num=?";
			pstmt = conn.prepareStatement(sql);
			// 4 sql 실행
			pstmt.setInt(1, bb.getNum());
			rs = pstmt.executeQuery();
			
			// 5 데이터가 있을 때, 다시 sql update & pstmt
			if(rs.next()){
				// 글이 있음
				if(bb.getPass().equals(rs.getString("pass"))){
					// 글 수정시 입력된 비밀번호 =? 글 작성시 입력된 비밀버노 (DB) 
					// 본인글 확인
					// 3 sql (update-글수정) & pstmt
					sql = "update itwill_board set subject=?, content=? where num=?";
					pstmt = conn.prepareStatement(sql);
					
					// 4 sql 실행
					pstmt.setString(1, bb.getSubject());
					pstmt.setString(2, bb.getContent());
					pstmt.setInt(3, bb.getNum());
					
					check = pstmt.executeUpdate();
					
					//check = 1;
				} else {
					// 글은 있지만, 비밀번호 잘못 입력했을 때
					check = 0;
				}
			} else {
				// 글이 없을 때
				check = -1;		
			}
			
			System.out.println(" 글 수정 완료! " +check);
			
		} catch (SQLException e) {
			System.out.println("글 수정 예외 발생 : " + e.getMessage());
		} finally {
			closeDB();
		}
		
		
		return check;
	}
	// r글 수정하기 메소드 updateBoard() 끝
	
	
	
	
	
	public int deleteBoard(BoardBean delBean) {
		int check = -1;
		
		
		try {
			// DB 연결
			conn = getConnection();
			
			// SQL 작성 및 pstmt 생성
			sql = "select pass from itwill_board where num=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, delBean.getNum());
			
			// pstmt 실행하기
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				// 글이 있을 때
				if(delBean.getPass().equals(rs.getString("pass"))){
					sql = "delete from itwill_board where num=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, delBean.getNum());
					
					check = pstmt.executeUpdate();
					System.out.println("check : " + check);
				} else {
					check = 0;
				}
			}
			else {
				// 글이 없을 때
				check = -1;
			}
			
		} catch (SQLException e) {
			System.out.println("글 삭제 예외 발생 : " + e.getMessage());
		} finally {
			closeDB();
		}
		
		
		return check;
		
	}
	
	
	
	
	// reInsertBoard()
	public void reInsertBoard(BoardBean bb){
		int num = 0;
		try {
			
			// 1) 답글 작성 번호 (num) 계산
			// 1, 2 디비 연결
			conn = getConnection();
			
			// 3 sql 쿼리 & pstmt 객체
			sql = "select max(num) from itwill_board";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				rs.getInt("max(num)");
				num = rs.getInt(1)+1;	// 쿼리 실행 결과가 max(num) 열 하나밖에 없으므로 1번 행 지정
				
				
			}
			
			System.out.println("답글 번호 계산 완료 : " + num);
			
			// 2) 답글의 순서 재배치 (정렬)
			// -> re_ref (같은 그룹) 안에서 re_seq(순서)를 정렬
			//            " 안에서 기존의 순서값보다 큰값이 있으면 순서를 1증가
			// 만약 원글의 답글을 단다면 기존의 값은 (ref 0 lev 0 seq 0)
			sql = "update itwill_board set re_seq = re_seq+1 where re_ref=? and re_seq>? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bb.getRe_ref()); // ref 0
			pstmt.setInt(2, bb.getRe_seq()); // seq 0
			
			// sql 실행
			pstmt.executeUpdate();
			
			System.out.println("답글 정렬 완료!");
			
			// 3) 답글 쓰기
			sql = "insert into itwill_board (num, name, pass, subject, content, readcount, re_ref, re_lev, re_seq, date, ip, file) "
					+ "values (?,?,?,?,?,?,?,?,?,now(),?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, bb.getName());
			pstmt.setString(3, bb.getPass());
			pstmt.setString(4, bb.getSubject());
			pstmt.setString(5, bb.getContent());
			pstmt.setInt(6, bb.getReadcount());
			pstmt.setInt(7, bb.getRe_ref());	// re_ref (원글의 그룹번호)
			pstmt.setInt(8, bb.getRe_lev()+1);	// 답글달때 생기는것 re_lev + 1 -> 원글 lev 0번에서 +1 되어 1레벨짜리 글이됨
			pstmt.setInt(9, bb.getRe_seq()+1);	// 답글달때 생기는것 re_seq + 1 -> 원글 seq 0번에서 +1 되어 1레벨짜리 글이됨
			pstmt.setString(10, bb.getIp());
			pstmt.setString(11, bb.getFile());
			
			pstmt.executeUpdate();
			
			System.out.println("업데이트 성공!");
			
			
			// 4) 
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		
		
		
	}
	// reInsertBoard()
	
	
	
	
	
	
}
