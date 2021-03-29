// 사용자 정의 메소드 만들기 연습
public class Test48 {

	// 메소드 만들기

	// 메소드 이름 : javaSpeak
	// 기능 : "쉬운 자바!" 출력하는 기능
	public static void javaSpeak() {
		System.out.println("쉬운 자바!");
	}

	// 메소드 이름 : absTest
	// 기능 : "절대값을 구하는 메소드" 출력하는 기능
	public static void absTest() {
		System.out.println("절대값을 구하는 메소드");
	}

	// 메소드 이름 : move
	// 기능 : "이동하라!" 출력하는 기능
	public static void move() {
		System.out.println("이동하라!");
	}

	public static void main(String[] args) {

		// 위에 만들어놓은 javaSpeak메소드 호출하여 실행되도록 하기
		Test48.javaSpeak();

		// absTest, move 메소드 각각 호출하여 실행되도록 하기 
		// static 으로 선언한 메소드들은 클래스명.메소드명으로 호출 가능하고,
		// 클래스명 없이 바로 메소드명으로도 호출 가능
		absTest();
		move();
	}

}
