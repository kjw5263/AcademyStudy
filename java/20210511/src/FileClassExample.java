import java.io.File;

/*
	File 클래스
	- java.io.File
	- 물리적으로 존재하는 파일을 삭제, 폴더 생성 등 파일 관리 작업을 지원하는 클래스
	- 파일을 읽고 쓰는 작업를 하는 스트림 클래스 종류는?
		FileInputStream
		FileOutputStream
		FileReader
		FileWriter
		등의 파일 입출력 스트림을 이용하고 File 클래스는 이들 스트림 객체를 생성할 때
		파일이 있는 경로를 전달하기 위해 사용하는 클래스이다.
		
		실습 순서
		순서1) C:\\Temp폴더 임의로 만들기
		순서2) C:\\Temp 내부에 ReadMe.txt , FileInfo.txt만들기
		순서3) 
		
*/	
public class FileClassExample {

	public static void main(String[] args) {
		try {
			//C:\\Temp 의 ReadMe.txt 파일에 접근하여 조작하기 위해 File객체 생성
			File f = new File("C:\\Temp", "ReadMe.txt");
			
			
			// File 객체를 통해 파일명을 얻어와 출력
			// getName() : 경로를 지정한 파일의 이름명을 출력 가능
			System.out.println(f.getName());
			
			
			// File 객체를 통해 D:\\Temp 폴더 내부애 파일이 하나라도 존재하는 지 묻는 메소드 호출
			// b파일이 존재하면 true, 없으면 false
			System.out.println(f.exists());	// true
			
			// File 객체를 통해 접근하는 ReadMe.txt 파일의 경로를 알려주는 메소드 호출
			System.out.println(f.getPath());
			
			
			// File 객체를 통해 접근하는 Readme.txt 파일의 크기를 알려주는 메소드 호출
			System.out.println(f.length());
			
			// 현재 운영체제에서 사용하는 경로를 구분하는 경로 구분자를 알려주는 메소드 호출 
			// 윈도우 운영체제의 구분자는 \
			// 유닉스 운영체제의 구분자는 /
			System.out.println(f.separator);
			
			
			// C:\\Temp 폴더 내부에 존재하지 않는 aaa 폴더 생성하는 메소드 호출
			// 폴더 생성에 성공하면 true 반환하고 실패하면 false반환하는 메소드
			boolean b = new File("C:\\Temp\\aaa").mkdir();
			 System.out.println(b);
			
			// C:\\Temp 폴더 내부에 있는 FileInfo.txt 파일 삭제시키는 메소드 호출 
			// 파일 삭제에 성공하면 true 반환, 실패시 false
			boolean b2 = new File("C:\\Temp", "FileInfo.txt").delete();
			System.out.println(b2);
			
			
			// C:\\Temp 폴더 내부에 있는 ~ 파일 및 폴더 정보들을 문자열 배열에 담아 반환하는 메소드 호출
			String[] list = new File("C:\\Temp").list();
			
			// for 반복문을 이용하여 C://Temp 폴더 내부에 존재하는 파일 및 폴더 정보를
			// 위 String 배열에서 꺼내와서 출력
			for(int i=0; i<list.length; i++) {
				System.out.println("Temp 폴더 내부의 내용 : " + list[i]);
			}
			
			
			
			
			
		} catch(Exception e) {
			
		}

	}

}
