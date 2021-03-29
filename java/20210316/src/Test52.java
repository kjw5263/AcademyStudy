/*
	JVM 메모리 구조
	
	Test52.java --컴파일--> Test52.class(자바 프로그램) -> JVM이 실행 ->
	JVM메모리는 운영체제에 의해서 필요한 메모리 할당받음
	
	JVM 메모리 영역 3가지
	1. 메소드 영역 : .class파일 실행시 JVM이 읽어서 .class파일이 저장되는 영역
	2. 호출 스택(콜스택) 영역 : 호출되는 메소드들이 계속 쌓이는 영역
							순서1. 메소드 호출 시 큰 메모리 영역 할당 (메소드 내 연산결과들이 저장되는 곳)
							순서2. 메소드 작업 후, 할당된 메모리 공간은 JVM에 의해 사라진다
	3. Heap 영역 : 클래스 -> 객체 메모리 생성하면 객체 메모리가 올라가는 공간



*/


/* 메소드 호출 시 JVM 메모리 순서 알아보기 */
public class Test52 {

	// 프로그램 시작점 main() 메소드
	
	public static void main(String[] args) {	// -> 호출 스택 영역에 쌓임
		
		System.out.println("main(String[] args) 메소드가 호출되어 시작됨");
		
		firstMethod();
		System.out.println("main(String[] args) 메소드가 모든 코드를 실행 후 끝났음");
	
	}
	
	public static void firstMethod() {
		System.out.println("firstMethod() 메소드가 호출되어 시작됨");
		secondMethod();
		System.out.println("firstMethod() 메소드 코드 실행 후 끝났음");
	}
	
	
	public static void secondMethod() {
		System.out.println("secondMethod() 메소드가 호출되어 시작됨");
		System.out.println("secondMethod() 메소드의 코드 실행 후 끝났음");
	}
	

}
