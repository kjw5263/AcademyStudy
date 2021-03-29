package practice;

public class Fibonacci {

	public static void main(String[] args) {
		// 피보나치 수열
		// 0 1 1 2 3 5 8 13 ...
		int a1 = 1;
		int a2 = 1;
		int a3 = 0;
		int sum = 0;
		System.out.println(a1);
		System.out.println(a2);
		
		// a3(합의 결과)이 4백만보다 작을 때 까지 반복
		while(a3 <= 4000000) {
			a3 = a1 + a2;	// 전전값 + 전값 을 더한 값
			a1 = a2;		// 전전값은 전값이 된다
			a2 = a3; 		// 전값은 합값을 받게 된다 
			// 4백만 이하의 짝수 값들의 합을 구하기
			if( a3 % 2 == 0) { sum += a3; }
			System.out.println("a3 = " + a3);
		}
		System.out.println("sum = " + sum);
	}
				
}
