
public class Test34 {

	public static void main(String[] args) {

		// 문제 : for문을 이용하여 "Hello World" 문자열을 10번 반복하여 출력
		for(int i=0; i<10; i++) {
			System.out.println("Hello World");
		}
		
		
		// 문제 : 0과 10사이의 짝수들 합 구하기
		// 출력결과
		/*
		 * 0 : 0
		 * 2 : 2
		 * 4 : 6
		 * 6 : 12
		 * 8 : 20
		 * 10 : 30
		 * 
		 */
		
		// 4바이트 크기의 정수값을 저장할 sum1변수 선언 후 0 저장
		// for 반복문을 이용, 초기식-> int j=0; 조건식-> j변수의 값이 10보다 작거나 같나?
		// 증감식 -> j 변수에 저장된 값을 2씩 증가
		
		int sum1 = 0;
		for(int j=0; j<=10; j += 2) {
			sum1 += j;
			System.out.println(j + " : "+ sum1);
		}
		
		System.out.println("===============================");
		
		
		int sumOdd =0;
		for(int i= 1; i<=10; i += 2){
			sumOdd += i;
		
		}
		System.out.println("총 합계는 " + sumOdd);
		System.out.println("for 반복문을 빠져나옴");
		System.out.println("===============================");
		
		
		// 문제 : 1부터 100까지의 짝수합 (2550 출력)
		int sum =0;
		for(int i=1; i<=100; i++) {
			if((i%2) == 0) {	// i 변수에 저장된 값이 짝수 라면?
				// sum변수에 짝수 값 누적
				sum += i;
				System.out.println(sum);
			}
		}
		
		System.out.println("===========================");
		
		/*
			break문
			break문은 현재 위치에서 가장 가까운 반복문을 벗어나는 데 사용
			주로 if문과 함께 사용되어 특정 조건식을 만족하면 반복문을 벗어나는데 사용		
		*/
		// 10번 반복하여 i변수 값 출력하되, i변수에 저장된 값이 5가 되면, for반복문을 완전히 빠져나가기
		for(int i=0; i<10; i++) {
			if(i == 5)	break;
			System.out.println(i);
		}
		
		System.out.println("============================");
		
		// 문제: for문을 이용하여 구구단 출력하기
		// 단 제목 붙이기 표시
		for(int i=2; i<10; i++) {
			System.out.printf("%8d", i);
		}
		System.out.println();
		for(int i=1; i<10; i++) {
				
			for(int j=2; j<10; j++) {
				//System.out.print(j + "*" + i + "=" + (i*j) + " ");
				System.out.printf("%d*%d=%2d   ",i, j, i*j );
			}
			
			System.out.println();
		}
		
		
		
		System.out.println("=====================================");
		/*
			*
			**
			***
			****
			*****
		*/
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i; j++) { 	// i변수에 저장된 값 만큼 반복
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
