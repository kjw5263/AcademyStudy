
// System.out.println() 메소드 호출 부분 직접 만들어보기

// System1 클래스 만들기
class System1 {
	static PrintStream1 out = new PrintStream1();
	
	
	
}

// PrintStream1 클래스 만들기
class PrintStream1 {
	// 메소드들 오버로딩 해놓자
	
	// 한줄 띄우는 기능의 println메소드 오버로딩
	void println() {
		System.out.println();
	}
	
	// 논리값을 매개변수로 전달받아 출력하는 기능의 println 메소드 오버로딩
	void println(boolean x) {
		System.out.println(x); // 기능
	}
	
	// 정수값을 매겨변수로 전달받아 출력하는 기능의 println메소드 오버로딩
	void println(int x) {
		System.out.println(x);
	}
	
	
	// 실수값을 매개변수로 전달받아 출력하는 기능의 println메소드 오버로딩
	void println(double x) {
		System.out.println(x);
	}
	
	// 문자열을 매개변수로 전달받아 출력하는 기능의 println메소드 오버로딩 
	void println(String x) {
		System.out.println(x);
	}
	
}


// PrintStream1클래스 만들기
public class Test68 {

	public static void main(String[] args) {
		System1.out.println();	// 한줄 띄우기
		System1.out.println(2);
		System1.out.println(1.2);
		System1.out.println("만든문자열");
		
	}

}
