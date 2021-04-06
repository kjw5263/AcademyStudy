
/*
	주제 : 상속 관계에서의 private 멤버 알아보기
	
	
 */

class A {
	public int p;
	
	// private (캡슐화, 은닉, 보호) 접근 제어자를 이용해 변수 n 선언 
	private int n;
	
	// 위 private으로 선언한 n변수에 새로운 데이터를 저장하기 위해서
	// public으로 선언된 setN메소드 만들기
	public void setN(int n) {
		this.n = n;
	}
	
	// 위 은닉, 보호된 private으로 선언된 n변수에 저장된 값을 외부 클래서에 제공해주기 위해
	// public으로 선언한 getN() 메소드 만들기
	public int getN() {
		return n;
	}
	
	
}	// class A


// A 클래스를 상속받아 새로 정의하는 B 클래스 만들기
class B extends A{
	private int m;

	
	public int getM() {	// -> private으로 선언된 m변수의 값을 새로운 값을 외부 클래스 영역에 제공 
		return m;
	}

	public void setM(int m) { //-> private으로 선언된 m변수의 값을 새로운 값으로 초기화
		this.m = m;
	}
	
	// n인스턴스 변수에 저장된 문자열 + getN() + m인스턴스 변수에 저장된 문자열 
	public String toString() {
		return "n=" + getN() + ", m=" + getM();
	}
	
	
	
}



public class Test81 {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		// 클래스 B에도 A의 n변수까지도 상속은 받는다
		// but 접근을 할 수 없다!!
		
		// 생성된 두 객체 A, B 내부의 멤버에(변수, 메소드)에 접근하기
		a.p = 5;
		// A객체의 n변수는 private으로 선언되어있다, 다른 클래스에서 접근불가
		// a.n = 5;
		
		b.p = 5;
		// B객체의 상속받은 n변수는 private로 선언되어있음, 다른 클래스에서 접근 불가
		// public으로 선언한 getN메소드 받기
		//b.n = 5;	
		
		b.setN(10);	// public 접근 제어자로 만들어놓은 setN메소드 접근 가능
		// m변수는 private 멤버 변수이기 때문에 다른 클래서에서 접근 불가능
		//b.m = 20;
		b.setM(20);
		
		System.out.println(b.toString());
		System.out.println(a.p);
		
		
		/* A 객체 내부에 접근 가능한 멤버
				a.p = 5;
				a.setN(0);
				a.getN();
				
			B객체 내부에 접근 가능한 멤버
				b.p = 5;
				b.setN(0);
				b.getN();
				b.setM(0);
				b.getM();
				b.toString();
		 */

	}

}
