import java.io.IOException;

/*
	바이트 스트림 방식으로 데이터 주고받기
	
	
*/
public class Test141 {

	public static void main(String[] args) throws IOException {
		// 외부 장치로부터 입력받은 데이터를 저장하기 위한 20바이트 크기의 배열
		byte[] data = new byte[20];
		
		// 문자열 입력하세요 
		System.out.print("문자열 입력 해주세요 : ");
		
		
		// 입력한 전체 문자열 데이터 크기 중에서 1바이트
		//int result = System.in.read();
		//System.out.println(result);
		
		
		// 키보드로 부터 읽어들인 전체 문자열 데이터를 data 배열 크기만큼 읽어서 위 data 배열에 저장
		int bb = System.in.read(data);
		
		// 입력하여 읽어들인 문자열 출력
		System.out.println("inputStream통로로 통해 읽어들인 문자들");
		for(int i: data) {
			System.out.print((char)i + " "); // 문자로 다시 보기 위해 char로 캐스팅 
		}
	}

}
