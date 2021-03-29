
public class Test30 {

	public static void main(String[] args) {
		// 예제 : 숫자 10부터 1씩 감소하면서 숫자값을 반복 출력하는 예제
		int i = 10;
		while (i >= 0) { // i변수에 저장된 값이 0 이상일 때 까지 명령문 반복 실행
			System.out.println(i--);
		}
		
		// 위 명령문의 i-- 의 --는 후위형 감소연산자이기 때문에 i변수의 값이 출력된 이후에 1 감소
		System.out.println(i);
		
		
		System.out.println("====================================");
		
		// i =2, j=1
		
		// 예제 : while 반복문을 사용해서 구구단을 출력하는 예제 
		i = 2;
		while (i < 10) {	// 바깥쪽 while 반복문 - 단 수
			int j = 1;
			System.out.println("[" + i+"단]");
			while (j < 10) {  // 안쪽 while 반복문 - 곱하는 수
				System.out.println(i + " * " + j + " = " + (i*j));
				j++;
			}
			
			i++;
		}
	}

}
