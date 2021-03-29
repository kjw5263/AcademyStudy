
public class Test6 {

	public static void main(String[] args) {
		/* 자동 형변환, 강제 형변환 연습 */
		/*
		 * byte  1바이트(-128 ~ 127)
		 * short 2바이트(-32768 ~ 32767)
		 * int   4바이트(-2147483648 ~ 2147483847)
		 * long  8바이트(-922경 ~ 922경) 
		 */
		
		// 1바이트 크기의 정수 127을 저장할 b 라는 이름의 변수 선언
		byte b = 127;	// 저장가능
		
		// 4바이트 크기의 정수를 저장시킬 i변수 선언 후 100 저장 
		int i = 100;
		
		// b 변수에 저장된 값 + i 변수에 저장된 값의 결과 출력 
		System.out.println(b + i); 	// + 연산전에 b변수에 저장되어있던 값이 int형으로 자동 형변환 되어
									// i 변수에 저장된 int 값과 + 연산을 하게된다.
		
		System.out.println( 10 / 4 );	// 2
		System.out.println( 10.0 / 4 ); // 실수>정수 이므로 실수형으로 형변환
		
		// 65 아스키코드값을 char형의 문자로 형변환하여 출력
		System.out.println((char)65);
		
		// 2.9 + 1.8 = 3.8 만들기 -> 2.9를 강제로 형변환하여 정수2로 만들어서 계산한다
		System.out.println((int)2.9 + 1.8);
		
		// 2.9 + 1.8 = 4
		System.out.println((int)(2.9 + 1.8));
		
		// 2.9 + 1.8 = 3
		System.out.println((int)2.9 + (int)1.8);
		

	}

}
