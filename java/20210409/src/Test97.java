/*
	메소드 오버라이딩이란?
	- 상속관계의 부모클래스의 메소드 선언부(메소드이름, 매개변수 이름, 리턴타입)를 모두 동일하게
	 자식클래스 내부에 정의하되 메소드의 구현부 내용만 재정의 하는 것
	  
	
*/

class P{
	public void p() {	// 메소드의 선언부
		System.out.println("부모 P클래스 내부의 메소드 ");	// 메소드의 구현부
	}
	
}

class C extends P{	// P클래스의 모든 멤버를 물려받는 C자식 클래스
	public void c() {
		System.out.println("자식 C클래스 내부의 메소드");
	}
	
//	public void p() {
//		System.out.println("부모P클래스 내부의 메소드");
//	}
	
	
	
	
	// 메소드 오버라이딩(재구현) : 단축키 -> alt+shift + s + v
	
	@Override	// <-- 현재 아래에 있는 p() 메소드는 부모 클래스로부터 재정의된 메소드이다 라고 표현
	public void p() {	// 메소드의 선언부는 부모 클래스에 있는 부분 그대로 작성
		// 메소드의 구현부를 재정의 시키자
		System.out.println("자식 C클래스에서 재정의된 p메소드");
	}
}

public class Test97 {

	public static void main(String[] args) {	
		// C 클래스로부터 객체 생성
		C c = new C();
		// 부모 클래스로부터 오버라이딩 된 메소드 호출 가능?
		c.p(); 		// 가능
		// C내부에 있는 메소드 호출 가능?
		c.c();
		
		

	}

}
