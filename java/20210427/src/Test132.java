/*
	자바에서 예외처리 방법 2가지
	1. try - catch - finally 
	2. throws 키워드 사용하기
	
	throw 와 throws 키워드
	1. throw 키워드
		-> 예외를 강제로 발생시킬 때 사용하는 키워드 
			(문법) 
*/


class Test {
	// throws Exception
	// a 메소드를 호출한 곳으로 가서 예외처리 하라고 지시
	// throws Exception을 하면, 메소드 내부에 어떤 예외가 발생하면
	// 메소드를 호출한 곳으로 가서 예외 처리 하라는 것
	void a(int num) throws Exception {
		System.out.println("num = " + num);
		
		if(num < 100) {
			// 예외를 인위적으로 발생시키기
			throw new Exception("num값이 100보다 작다");
		}
	}
	
	
	
}
public class Test132 {
	public static void main(String[] args) /* throws Exception */ { // JVM 가장 머신이 main()을 호출하니
		System.out.println("프로그램이 시작되었음");				// JVM에게 예외처리를 떠넘김
		Test test = new Test();
		try {
			test.a(50);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 메소드 안에서 예외처리를 하지 않으면 여기서 예외처리를 하고, 
		// 여기서 예외처리를 하면 메소드 안에서 예외처리 안해도 됨
		
		System.out.println("프로그램 종료");
	}
}
