/*
 	5. 논리 연산자
 		- 논리 연산자는 주어진 논리식을 판단하여, 참(true) 또는 거짓(false)을 결정하는 연산자
 		- 논리연산자 종류
 		
 		- 논리 연산자의 모든 동작의 결과를 보여주는 진리표
 		A변수	B변수	A&&B	A||B	!A
 		true	true	true	true	false
 		true	false	false	true	false
 		false	true	false	true	true
 		false	false	false	false	true
 			
 */
public class Test11 {

	public static void main(String[] args) {
		boolean a = true;
		boolean b = false;
		
		System.out.println("===========AND 연산===========");
		System.out.println(a && b);
		System.out.println(a && a);
		System.out.println(b && b);
		
		System.out.println("===========OR 연산===========");
		System.out.println(a || a);
		System.out.println(a || b);
		System.out.println(b || b);
		
		System.out.println("===========NOT 연산===========");
		System.out.println(!a);
		System.out.println(!b);
		
		System.out.println("===========비교&논리 연산 함께 사용===========");
		
		/* 비교 연산자와 논리 연산자 함께 사용하기 */
		int x = 10;
		int y = 15;
		
		// 참고 : 비교 연산자가 논리 연산자 보다 연산의 우선순위가 높다
		// x > 5 true 구하고, x < 25 true 구하여 두 피연산자값을 && 연산함
		System.out.println( x > 5 && x < 25 );  // >>> true
		System.out.println( x > 8 && y < 10 );  // >>> false
		System.out.println( x > 15 || x < 25 ); // >>> true
		System.out.println( x > 8 || y < 10 );  // >>> true
		
		
		System.out.println("===========문자끼리 비교===========");
		/* char형 문자끼리도 그 크기를 서로 비교할 수 있다. */
		char ch1 = 'b', ch2 = 'B';
		boolean result1, result2;
		
		result1 = (ch1 > 'a' && ch1 < 'z');
		System.out.println("&& 연산자에 의한 결과 : " + result1);
		
		result2 = (ch2 < 'A') || (ch2 < 'Z');
		System.out.println("|| 연산자에 의한 결과 : " + result2);
		
	
		System.out.println("! 연산자에 의한 결과 : " + !result2); 
	}

}
