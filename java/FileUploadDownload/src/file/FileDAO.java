package file;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class FileDAO {
	
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public FileDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/FILE";
			String dbID = "root";
			String dbPassowrd = "1234";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassowrd);
			
		}catch (Exception e) {
			System.out.println("DB�������");
			e.printStackTrace();
		}
	}
	

	
	public int upload(String fileName, String fileRealName) {
		
		String sql = "INSERT INTO FILE VALUES(?,?,0)";  //������ 0�� ���Ͼ��ε�� ���ε��ϴ� ������ �ٿ�ε��� Ƚ���� ����
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fileName);//������ ���ε��� ������ ���� ���ϸ�
			pstmt.setString(2, fileRealName); //���� ������ ���ε�Ǿ� �ö󰡴� ���� ���ϸ�
			return pstmt.executeUpdate(); //�����ϸ� 1�� ��ȯ
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;//�����ϸ� -1 ��ȯ
	}
	
	//����ڰ� ������ �ٿ�ε� �Ҷ� ���� �ٿ�ε��� Ƚ���� DB�� ������Ʈ �ϱ� ���� �޼ҵ�
	public int hit(String fileRealName) {//�ٿ�ε��� ������ ���� �̸��� �Ű������� ���� �ޱ�
		
		//����ڰ� ������ �ٿ�ε� �Ҷ� ���� �ٿ�ε��� ������ �ٿ�ε�Ƚ�� 1������ DB�� ������Ʈ ��Ű��
		String sql = "UPDATE FILE SET downloadCount = downloadCount + 1 "
				   + "WHERE fileRealName = ?";  
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fileRealName);//���� ������ ���ε�Ǿ� �ö� �ִ� �ٿ�ε��ų ���� ���ϸ�
			return pstmt.executeUpdate(); //������ �ٿ�ε�Ƚ�� 1������ �����ϸ� 1�� ��ȯ
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //������ �ٿ�ε�Ƚ�� 1������ �����ϸ� -1 ��ȯ
		
	}
	
	
	
	
	public ArrayList<FileDTO>  AllSelect() {
		
		ArrayList<FileDTO> list = new ArrayList<FileDTO>();
		
		String sql = "SELECT * FROM FILE";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FileDTO dto = new FileDTO(rs.getString("FILENAME"),rs.getString("FILEREALNAME"),rs.getInt("downloadCount"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	

}








