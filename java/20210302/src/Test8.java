/*
 * 연산자(operator) : 자바에서 여러 종류의 연산을 수행하기 위한 다양한 기호
 * 연산자 종류
 * 		1. 산술 연산자
 * 		2. 대입 연산자
 * 		3. 증감 연산자
 * 		4. 비교 연산자
 * 		5. 논리 연산자
 * 		6. 비트 연산자
 * 		7. 삼항 연산자
 * 
 * 1. 산술 연산자란?
 * 	- 사칙 연산을 다루는 연산자
 * 	- 산술 연산자의 종류										설명
 * 			+
 * 			-
 * 			*
 * 			/
 * 			%
 * 
 * 
 *
 */
public class Test8 {

	public static void main(String[] args) {
		int num1 = 8;
		int num2 = 4;
		
		// 1. 산술 연산자     문자열 데이터는 12바이트 차지
		System.out.println("+ 연산자에 의한 결과 : " + (num1 + num2) );
		System.out.println("- 연산자에 의한 결과 : " + (num1 - num2) );
		System.out.println("* 연산자에 의한 결과 : " + (num1 * num2) );
		System.out.println("/ 연산자에 의한 결과 : " + (num1 / num2) );
		System.out.println("% 연산자에 의한 결과 : " + (num1 % num2) );
		
		System.out.println("---------------------------------------");

		System.out.println(10 + 5);
		System.out.println( 5 - 2); 
		System.out.println( 4 * 3);
		System.out.println(14 / 3);
		System.out.println(3.2 / 2);
		System.out.println( 5 % 3);
		
		System.out.println("---복합대입 연산자-----------------------------");
		
		int num3 = 7, num4 = 7, num5 = 7;
		num3 = num3 - 3;	// 7-3
		num4 -= 3;
		// 순서1 ) num4 - 3;
		// 순서2 ) num4 = num4 - 3;
		
		num5 -= 3;
		// 순서1 ) num5 - 3;
		// 순서2 ) num5 = num5 - 3;
		
		int a = 10;
		int b = a;	// 변수 a에 저장되어 있는 값 10을 변수 b에 대입
		System.out.println(b);
		
		b += a;
		System.out.println(b);
		
		b -= a;
		System.out.println(b);
		
		b *= a;
		System.out.println(b);
		
		b /= a;
		System.out.println(b);
		
		b %= a;
		System.out.println(b);
		
		

	}

}
