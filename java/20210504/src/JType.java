import java.io.FileInputStream;
import java.io.IOException;

// 주제 : FileInputStream 클래스를 이용한 도스의 Type 프로그램 만들기

// 도스로 실행하는 방법
// 예)DOS 명령어 중 Type 프로ㅡ램을 통해 텍파 내용 읽을 수 있음

// 방법
// 1. cmd입력후 dos 창 열기
// 2. A.txt 파일 존ㅈㅐ하는 D:로 이동
// 3. type 프로그램을 통해 a.txt 파일 내용 읽어 출력
//		소스코드 -> type 텍스트파일명 - [엔터키]

// Type 과 같은 프로그램 만들어보자! 



// Dos의 Type 프로그램과 유사한 JType 프로그램 만들어서 사용해보기
public class JType {

	public static void main(String[] args) throws IOException {
		/* 
			주기억장치 : 프로그램은 실제 주기억장치에 존재, 그러므로 실제 CPU는 주기억장치를 통해 프로그램 접근하여 사용
		
		
			보조기억장치(USB, 외장하드) :
			 CPU가 사용할 수 없는 파일이 들어있는 장치
			 
			 결론 ㅣ CPU는 보조기억 장치에 직접 접근 할 수  없으므로
					보조기억 장치에 있는 파일을 주기억 장치 메모리에 올려놓기위해
					주기억장치 내부에 파일이 저장될 수 있는 메모리 공간만들기
					-> FileInputStream 클래스에 대한 객체 메모리 생성
			
			주기억 장치에 읽어오기 위한 파일을 저장할  수 있는 메모리 공간을 마련하기 위해 객체 생성
			어떤? 파일을 주기억장치에 올릴 것인가에 대해서 생성자 매개변수로 전달
			1. 직접 파일을 불러올 수 있는 주소를 적는 방법
			2. 명령 인자를 통해 불러올 수 있는 파일을 입력받는 방법
		 */

		
		
		// 우리가 입력한 파이의 내용을 바이트 단위로 읽어들일 스트림 통로 객체 생성, 실제 입력받는 값은 Main 메소드에서
		FileInputStream fileInputStream = new FileInputStream(args[0]);
		
		// 파일의 내용을 한바이트씩 읽어들여 저장할 변수
		int i;
		
		// 한 바이트씩 파일의 내용 읽어들이기 위해 do while 반복문 실행 
		do {
			i = fileInputStream.read();
			
			// 읽어들일 데이터가 계속 존재하면 ( i 변수값이 -1과 다르면)
			if( i != -1) {
				// 읽어들인 데이터 바로 콘솔 출력
				System.out.println((char)i);
			}
		} 
		// 파일로부터 읽어들일 데이터가 존재할 때까지 반복
		while( i != -1 );
		
		// FileInputStream 객체 메모리 자원해제
		fileInputStream.close();
		
	}

}
