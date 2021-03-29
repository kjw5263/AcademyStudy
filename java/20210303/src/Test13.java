/* 
 	7. 삼항 연산자
 		- 자바에서 유일하게 피연산자를 세 개를 가지는 조건 연산자
 		- 삼항 연산자 형식
 			조건식 ? 반환값1 : 반환값2
 			해석 : 조건식에 따라 결과값이 참이면 반환값1을 반환하고, 거짓이면 반환값2를 반환한다.
 			
 			
 
 
 */

public class Test13 {
	public static void main(String[] args) {
		int num1 = 5, num2 = 7;
		int result;
		
		result = (num1 - num2 > 0) ? num1 : num2;
		System.out.println("두 정수 중 더 큰 수는 " +result + "입니다.");
		System.out.println("=========================================\n\n\n");
		
		// 예제) 삼항연산자를 이용해서 3개의 변수에 저장된 값들 중에서 최대값을 구하는 프로그램
		int c = 12;
		int d = 4;
		int e = 19;
		
		// c변수값과 d변수값 비교해서 큰 값을 변수 max에 저장
		// max변수에 저장되어 있는 12와 e변수에 저장되어 있는 19를 비교해서 큰 값을 max변수에 다시 저장
		int max = (c > d) ? c : d;
	}
}
