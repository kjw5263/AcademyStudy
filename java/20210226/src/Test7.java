
public class Test7 {
	
	public static void main(String[] args) {
	
		// 문제1. 자바의 기본 데이터 타입이 아닌것은?
		// 		1> byte
		//		2> double
		//		3> String	<<<<<< 
		//		4> Boolean
		
		// 문제2. 값이 365인 YEAR, 30인 MONTH, 7인 WEEK 정수(int) 타입의 상수로 선언하라
		final int YEAR = 365;
		final int MONTH = 30;
		final int WEEK = 7;
		
		// 문제3. 다음 중 byte 타입 변수에 대입할 수 없는 값은?
		//		1> 256	 <<<<<<
		//		2> 127
		//		3> 10
		//		4> -99
		
		// 문제4. 다음 수식의 결과값은?
		// (byte)128 + (byte)128 + (int)22.9
		// >>>>>> -234
		System.out.println((byte)128 + (byte)128 + (int)22.9);
		
		
		// 문제5. 다음 각 항목이 나타내는 변수를 선언해라
		// (1) int형 변수 age 선언하기
		int age = 0;
		// (2) 0.25로 값이 초기화된 float형 변수 f 선언하기
		float f = 0.25f;
		// (3) age값과 f값을 더한 값으로 초기화 된 double형 변수 d 선언하기
		double d = age + f;
		// (4) 문자 'a'의 유니코드로 초기화된 char형 변수c
		char c = '\u0061';
		// (5) 자신의 이름으로 초기화된 문자열 변수 name 선언
		String name = "김지원";
		
		
		/* 문제6. 다음 중 식별자 사용이 잘못된 경우를 모두 골라라
		 * 
		 * int _i;
		 * 
		 * int %j;		<<<<<<
		 * 
		 * char 안녕;	// 변수 이름을 한글로 해도 된당. 권장X
		 * 
		 * double 1var; <<<<<<
		 * 
		 * char student_ID;
		 * 
		 * final int abcdefghijklmnopqrstuvwxyz; // 가능하지만 권장X
		 * 
		 */
		
		
		// 문제7. b라는 정수형 변수의 값과 100을 더해서 다시 b변수에 대입하는 자바 문장을 작성하라.
		int b = 0;
		b = b + 100;
		
		// 문제8. 자바의 기본 데이터 타입을 모두 나열하고 각 타입의 크기를 설명하라
		/* 논리형 Boolean 1바이트
		 * 문자형 char 2바이트
		 * 정수형 byte 1바이트 short 2바이트 int 4바이트 long 8바이트 
		 * 실수형 float 4바이트 double 8바이트
		 * 
		 */
		
		
		// 문제9. 다음 수식의 결과 값과 타입은?
		// (1) 67 + 12.8 	double형 79.8
		// (2) 'c' + 1 		int 100
		// (3) 10/3 		int 3
		// (4) 10.0/3 		double 3.3
		
		
	}
	
}
