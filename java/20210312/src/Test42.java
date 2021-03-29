/*
	4. 향상된 for반복문
		- JDK 1.5부터 배열의 모든 요소를 참조하기 위해 새롭게 추가된 반복문
		- 형식
			for(자료형 변수이름 : 배열명) {
				배열의 길이만큼 반복적으로 실행하고자 하는 명령문;
			}
			
		- 설명 : 배열명 <- 배열
				타입 변수 이름 <- 변수

				배열의 길이만큼 for반복하는데, 먼저 배열의 0번째 인덱스 위치의 값부터 꺼내어서 변수에 저장 후
				반복적으로 실행하고자 하는 명령문을 실행
				그리고 다시 배열의 1번째 인덱스 값을 꺼내어서 변수에 저장 후
				반복적으로 실행하고자ㅏ 하는 명령문을 수행함
				더이상 배열 메모리에서 꺼내올 값이 존재하지 않으면 for반복문을 빠져나온다
				
*/ 
public class Test42 {

	public static void main(String[] args) {
		// 배열 선언, 생성, 초기화
		String[] colors = new String[] {"Red", "Green", "Blue"};

		// 향상된 for 반복문 사용 - 배열에 저장된 데이터 갯수만큼 반복 
		for(String i : colors) {
			System.out.println(i);
		}
		// 향상된 for반복문 사용 장점 : 인덱스 위치값 사용하지 않아도 됨
		
		
		System.out.println("==============================");
		
		
		// 일반 for반복문 사용
		for(int i=0; i<colors.length; i++) {
			System.out.println(colors[i]);
		}
	}

}
