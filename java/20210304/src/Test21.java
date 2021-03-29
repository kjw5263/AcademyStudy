/* if 조건문 연습문제1 */

public class Test21 {

	public static void main(String[] args) {
		// 문자열을 저장할 myJob1이라는 이름의 변수 선언 및 "홍길동" 저장
		String myJob1 = "홍길동";
		// 문자열을 저장할 myJob2라는 이름의 변수 선언 및 "이순신" 저장
		String myJob2 = "이순신";
		// 문자열을 저장할 myJob3이라는 이름의 변수 선언 및 "이성계" 저장
		String myJob3 = "이성계";
		// 문자열을 저장할 myJob4라는 이름의 변수 선언 및 "정도전" 저장
		String myJob4 = "정도전";

		// myJob1 변수에 저장된 값이 "홍길동"과 같으면?
		if( myJob1.equals("홍길동")) {
			
			// "홍길동은 의적" 출력
			System.out.println("홍길동은 의적");
		
		} else if ( myJob2.equals("이순신")) { // MyJob2 변수에 저장된 값이 "이순신"과 같으면?
			
			// "이순신은 장군" 출력
			System.out.println("이순신은 장군");
			
		} else if (myJob3.equals("이성계")) {
			
			// "이성계는 왕" 출력
			System.out.println("이성계는 왕");
			
		} else {
			
			// "정도전은 책사" 출력 
			System.out.println("정도전은 책사");
		}
		
		
		/* 
			결론 : 이순신, 이성계, 정도전의 내용은 출력되지 않는다.
			else if문은 이전 문장이 false이고 현재 문장이 true인가?라는 의미이기 때문이다.
			
		*/	
	}

}
