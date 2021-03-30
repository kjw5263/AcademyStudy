package app;	// app 패키지 내부에 B클래스가 만들어져 있다
				// 라고 컴파일러에게 알려주는 구문이 자동으로 생성됨
// import 문 사용하기 
// - 다른 패키지 (lib패키지) 내부에 작성되어있는 A 클래스를
// 현재 B 클래스 내부에서 사용하기 위해 컴파일러에게 패키지명을 포함한 A 클래스의 경로를 알려줘야한다.
// 그럴 때 import문을 사용한다.
import lib.A;

public class B {

	public static void main(String[] args) {
		A a = new A();
		A a1 = new A(1,2);
		a1.prn();
	}

}
