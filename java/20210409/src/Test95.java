/*
	다운캐스팅
	- 업 캐스팅으로 인하여 부모클래스 타입의 참조변수로
	  자식 객체의 모든 멤버에 접근하는 것이 불가능 하여
	  다운 캐스팅이라는 개념이 나옴 
	- 다운 캐스팅이란, 자식 클래스 타입의 참조 변수에 부모 클래스의 참조변수에 저장된 자식 객체의 주소를
	  다시 저장하는 형태
	  자식 클래스 멤버 참조가 가능해진다. 
 */

class Parent1 {
	public void parentPrn() {
		System.out.println("부모 클래스 : parentPrn메소드");
	}
}

class Child1 extends Parent1{
	public void childPrn() {
		System.out.println("자식 클래스 : childPrn 메소드");
	}
}

public class Test95 {

	public static void main(String[] args) {
		/* 다운 캐스팅이라는 개념이 나옴 
			- 다운 캐스팅이란, 자식 클래스 타입의 참조 변수에 부모 클래스의 참조변수에 저장된 자식 객체의 주소를
			  다시 저장하는 형태     */
		
		// 부모 클래스 타입의 참조변수를 선언하고, 참조변수에 부모객체 생성하여 주소 저장
		Parent1 p1 = new Parent1();
		
		// 자식 클래스 타입의 참조변수 선언
		Child1 c1;
		
		// 다운 캐스팅~!
		//c1 = p1;	// 자동형변환이 안돼서 에러남
		c1 = (Child1)p1;	// 명시적으로 자식 클래스 타입으로 형변환 필요
		//------------사실상 이것도 잘못된 예제! ----------
		
		// 잘못된 다운캐스팅의 예 ! 이유 : 업캐스팅 하지 않고 다운 캐스팅 했음
		Child c2 = (Child)new Parent();
		
		
		
		
	}

}
