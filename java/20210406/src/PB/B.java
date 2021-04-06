package PB;

// 다른 패키지 (PB)에 있는 B클래스

// 다른 패키지(PA)에 있는 A 클래스를 상속받아 B 클래스를 정의하려면?
// import 구문이 필요하다 
import PA.A;


public class B extends A{
	
	void set() {
		// 다른 패키지의 default멤버 접근 불가능
		// i = 1;
		// 다른 패키지의 부모 클래스의 protected 멤버 접근 가능
		pro = 2;
		// 다른 패키지의 부모 클래서의 private 멤버 접근 불가능
		// pri = 3;
		pub = 4;
	}
	public static void main(String[] args) {
		B b = new B();
		b.set();
		b.print();
		
		
		
	}
}
