/*
	예외 : 프로그램이 실행되는 도중에 발생하는 예기치 않은 에러
	
	예외처리 
*/
public class Test128 {

	public static void main(String[] args) {
		int a = 10;
		int b01 = 0;
		int b02 = 2;
		int c = 10;
		
		// a 변수에 저장된 값을 b02변수에 저장된 값으로 나누기 위하여 예외가 발생 예상되는 부분을
		// 조건검사 해주기
		if( b02 == 0 ) {
			System.out.println("예외 상황이 발생됩니다.");
		} else {
			c = a / b02	;	//  b02변수에 저장된 값이 0이 아닐때만 나누자	
			System.out.println("c-> "+c);
		}

		if( b01 == 0) {
			System.out.println("예외 상황이 발생됩니다.");
		} else {
			c = a/b01;  // 예외가 발생하는 코드
			System.out.println("c-> "+c);
		}
		
		System.out.println("프로그램 종료");

	}

}
