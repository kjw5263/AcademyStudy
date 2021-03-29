/*
	2. do while 반복문
		반복되는 명령문을 일단 한번은 실행한 후, 조건식을 검사함.
		조건식의 결과가 true이면 계속해서 명령어 반복.
		조건식의 결과가 false이면 반복문을 빠져나간다.
		
		문법
			초기식;
			do{
				조건식의 결과가 참인 동안 반복적으로 실행하고자 하는 명령문;
				조건식의 결과를 변경하는 명령문 (증감식);
			} while (조건식);


*/
public class Test32 {

	public static void main(String[] args) {
		// 
		int i =1, j = 1;
		
		while (i < 1) {
			System.out.println("while문이 " + i + "번 째 반복 실행중입니다.");
			i++;
		}
		System.out.println("while문이 종료된 후 변수 i의 값은 " + i);

		
		System.out.println("=========================");
		
		do {
			System.out.println("do while문이 " + i + "번 째 반복 실행중입니다.");
			j++;
		} while (j < 1);
		
		System.out.println("do while문이 종료된 후에 변수 j의 값은" + j + "입니다.");
		/*
			위의 예제가 만약 while문이었다면 단 한번의 출력도 없었을 것이다.
			하지만 do while문은 조건식의 결과와 상관없이 무조건 한번은 do{} 루프를 실행한다.
			
		
		
		*/
	}

}
