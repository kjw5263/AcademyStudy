import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// 주제  : 파일 복사 프로그램 만들기
// A 파일의 내용을 읽어들여서 B파일에 A파일의 내용 복사하기


public class JCopy {

	public static void main(String[] args) throws Exception{
		// 파일의 내용을 읽어들이기 위한 스트림 객체를 저장할 변수 선언
		FileInputStream fin;
		//파일에 내용을 쓰기 위한 스트림 객체를 저장할 변수 선언
		FileOutputStream fout;
		
		// cmd 명령 프롬프터 창에서 명령어를 입력하고 JCopy 프로그램을 실행할 때
		// 만약 java JCpoy A.txt newA.txt 일 경우
		// A.txt 를 적어주지 않을 수 있으므로
		// 명령인자에 따른 갯수가 부족할때 예외 발생 가능
		// 그래서 전체를 배열에 관한 예외처리를 해야함
		try {
			// 어떤 특정한 파일의 내용을 읽어들일 스트림 객체 생성
			try {
				fin = new FileInputStream(args[0]);
				
				
				
				
			} catch (FileNotFoundException e) {
				System.out.println("파일을 찾을 수 없습니다.");
				return; // 파일을 찾을 수 없으니 프로그램을 끝냄
				
			}
				// 어떤 특정파일에 데이터를 쓰기(출력)하기 위한 스트림 객체 생성
				try {
					fout = new FileOutputStream(args[1]);
				} catch (FileNotFoundException e) {
					System.out.println("파일을 찾을 수 없습니다.");
					return; // 파일을 찾을 수 없으니 끝내기
				}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("사용법 : java JCopy 원본파일명 복사할파일명  형식으로 작성하세요.");
			return;
			
		}
		
		// 원본 파일의 내용을 읽어 들여서 복사할 파일에 내용 복사
		int i;
		
		try {
			do {
				i = fin.read();	// a.txt 파일의 데이터를 한 바이트씩 읽어들여 저장하기
				// 만약 a.txt 파일에 듥어들일 데이터가 더이상 존재하지 않으면 
				if(i != -1) {
					// b.txt 파일에 a.txt 파일로부터 읽어들인 데이터를 내보낸다 (출력, 쓴다)
					fout.write(i);
				}
				
			}while(i != -1);
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			// FileInputStream 스트림 통로 메모리 자원 해제
			// FileOutputStream 스트림 통로 메모리 자원 해제
			// 자원 해제 이유 : 다른 파일을 열어볼 수 있게 하기 위해서
			fin.close();
			fout.close();
			
			
			
		}
		
		
		

	}

}
