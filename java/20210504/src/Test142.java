import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
	바이트 스트림 방식을 대표로 하는 두가지 최상위 클래스
	1. InputStream 클래스 (최고 부모클래스, 추상클래스)
	2. OutputStream 클래스 (최고 부모 클래스, 추상클래스)
	
	
*/

public class Test142 {

	// 키보드로부터 입력받은 데이터를 바이트 단위로 읽어들이기 위한 InpuStream 객체와
	// 읽어들인 데이터를 출력하기 위한 OutputStream 객체를 매개변수로 전달받아 사용하는 메소드 만들기\
	public static void streamTest(InputStream is, OutputStream os) {
		try {
			// 매개변수로 전달받은 inputStream 통로 역할을 하는 객체의 메소드를 이용해서
			// 반복해서 입력받은 데이터를 바이트 단위로 읽어들이기 
			while (true) {
				// 키보드로부터 하나의 키를 눌러 읽어들인 정수 (아스키코드) 얻기
				int i = is.read(); // 한번 읽기
				if(i == -1 ) {	// 입력한 데이터들 중에서 더이상 읽어들일 데이터가 없으면
					break;		// while 반복문 빠져나가자
				}
				
				// 키보드로부터 읽어들인 데이터를 console로 띄우기
				// 아스키코드값을 문자열로 반환 
				//System.out.print((char)i);  --> 한글이 꺠져보임
				
				
				os.write(i);	// 한글 안깨짐 _ D드라이브에 txt 파일 하나 만들기
				
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) {
		// streamTest 메소드 호출시
		// System.in : 키보드로부터 입력받은 데이터를 바이트 단위로 읽어들이기 위해 사용되는 InputStream 객체
		// System.out : 읽어들인 데이터를 바이트 단위로 모니터 화면에 출력하기 위해 사용되는 OutputStream 
		streamTest(System.in, System.out);
		

	}

}
