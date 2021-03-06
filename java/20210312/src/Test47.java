/*
	메소드(함수)란?
	: 어떤 특정한 기능을 처리하기 위한 명령어들을 묶어놓은 작은 프로그램 단위
	
	1. 메소드(함수)란?
		어떤 특정한 기능을 처리하기 위한 명령어들을 묶어놓은 작은 프로그램 단위
		
	2. 자바 메소드 종류 2가지
		(1) 내장 메소드 : 자주 사용하는 기능을 미리 만들어서 자바에서 제공하는 메소드
		<자바 API 문서 참고>
		- String 클래스 내부에 toString() 메소드 : 특정 데이터를 문자열로 변환하는 기능의 메소드
		- Math 클래스 내부에 random() 메소드 : 0.0~1.0 랜덤값을 제공해주는 기능의 메소드
		- Date 클래스 내부에 getDate()메소드 : 현재 날짜 및 시간 관련 데이터 제공하는 메소드
		
		(2) 사용자 정의 메소드 : 개발자가 특정 기능을 필요로 할 때마다 새롭게 기능을 추가해서 만드는 메소드
			1. 매개변수가 없고 반환할 값이 없는 메소드를 만들 수 있다.
			2. 매개변수가 있고 반환할 값이 없는 메소드를 만들 수 있다.
			3. 매개변수와 반환할 값이 있는 메소드를 만들 수 있다.
			
		(2-1) 사용자 정의 메소드 생성 형식
			접근지정자 반환형식 메소드명(매개변수 선언) {			<---- 메소드 선언부
				// 메소드 구현부 : 메소드 기능을 코드로 작성
			 
				// 메소드를 호출 한 장소로 반환할 값 작성
				return 반환할값;
			}

*/
public class Test47 {
	
	// 자바 프로그램의 시작점 main() 메소드
	// -> 메소드명 : main
	// -> 프로그램을 시작시키는 기능
	// -> main메소드 내부에서 다른 메소드를 호출해서 사용할 수 있다
	// -> 같은 클래스 내부의 다른 메소드 호출시   클래스명.메소드명  
	// -> main메소드의 중괄호 {} 기호 내에 존재하는 문장들이 순차적으로 JVM에 의해 실행됨
	
	public static void main(String[] args) {	// 메소드 선언부 
		// main 메소드 내부에서 다른 메소드 호출 가능
		// 첫번째)
		// System 클래스 내부에, out 상수에 저장된 PrintStream객체에 접근하여
		// PrintStream 객체 내부에 println 메소드가 만들어져 있으므로 메소드를 호출하여 사용가능
		// --> println(String value) 메소드 기능 : 매개변수 value로 전달받은 데이터 출력
		System.out.println("안녕");	
		
		
		
		
		// 두번째)
		hi();	// 만들어놓은 hi라는 이름의 메소드 호출!
				
		hello();
		
		for(int i=0; i<4; i++) {
			hello();	
		}
		
		
	}
	
	
	// main메소드와 다른이름으로 사용자 정의 메소드 만들기
	/*
		hello! 라고 출력하는 기능의 hello라는 이름의 메소드(함수) 만들기
	 */
	public static void hello() {
		System.out.println("hello!");
	}
	
	
	
	/*
		hi! 라고 출력하는 hi라는 이름의 메소드 만들기
	*/
	public static void hi() {
		System.out.println("hi!");
	}
}
