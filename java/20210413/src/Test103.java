/*
	추상 클래스의 추상 메소드를 자식 클래스 내부에 재구현(오버라이딩) 하지 않으려면?
	-> 자식 클래스 역시 추상클래스로 선언되어야 한다.
		하지만 최종적으로 자식객체를 생성하려면, 추상메소드를 강제로 반드시 오버라이딩 해야함
*/

// 추상 클래스
abstract class AbstractSuper {
	// 추상 메소드 : 실질적인 구현이 없는 메소드
	abstract void Method01();
	
	// 일반 메소드
	void Method02() {
		System.out.println("Method:추상클래스 AbstractSuper에서 구현된 일반 메소드");
	}	
}

// 위 Method01 추상메소드를 오버라이딩 하지 않으려면
// MiddleClass 자식 클래스를 추상 클래스로 만들어야 함
abstract class MiddleClass extends AbstractSuper{	// 자식 클래스
	
	// 추상 클래스가 된 MiddleClass의 일반 메소드
	void Method03() {
		System.out.println("Method03:추상클래스 MiddleClass에서 구현된 일반 메소드");
	}

}

// 위 추상 클래스 MiddleClass를 상속받는 자식 Sub클래스 만들기
class Sub extends MiddleClass {
	
	// 눈엔 안보이지만 MiddleClass가 AbstractSuper의 메소드를 가지고 있는데
	// 추상 메소드를 오버라이딩 해주지 않았기 때문에 에러가 남
	// 추상클래스는 객체생성이 되지 않으므로, 객체를 생성하려면
	// Sub클래스에서 반드시 추상 클래스의 메소드를 상속받아 사용하지 않고
	// 강제로 메소드 오버라이딩해서 사용해야 함
	
	@Override
	void Method01() {
		System.out.println("Method01: 추상클래스 MiddleClass로부터 오버라이딩 된 메소드");
		
	}
}


public class Test103 {

	public static void main(String[] args) {
		Sub sub = new Sub();
		
		// 오버라이딩된 메소드 호출 가능
		sub.Method01();
		
		// 추상 클래스 AbstractSuper로 부터 상속받은 일반 메소드 호출 가능
		sub.Method02();
		
		// 추상 클래스 MiddleClass로부터 상속받은 일반 메소드 호출 가능
		sub.Method03();

	}

}
