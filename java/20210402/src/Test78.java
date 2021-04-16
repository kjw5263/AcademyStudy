/*
	상속 개념
	- 상속이란, 기존의 클래스에 기능을 추가하거나 재정의하여 새로운 클래스를 정의하는 것을 의미함
	- 상속을 이용하면 기존에 정의되어 있는 클래스의 모든 변수와 메소드를 물려받아,
	 새로운 클래스를 생성할 수 있다.
	- 기존에 정의되어있던 클래스를 부모 클래스, 상위클래스, 기초 클래스 라고 함
	  상속을 통해 새롭게 작성되는 클래스는 자식 클래스, 하위 클래스, 파생클래스 라고 함
	  
	자식 클래스(child class)
	- 자식 클래스는 부모 클래스의 모든 특성을 물려받아 새롭게 작성된 클래스
	- 자바에서 자식 클래스를 설계하는 문법
	  class 자식클래스명 extends 부모클래스명 {  ...  }
	- // 기존에 존재하는 부모 클래스 
	  class Parent {
	  	public void parentPrn() {
	  		System.out.println("부모클래스 메소드는 상속된다.");
	  	}
	  }
	
	
*/

class Parent {
	

	
	public void parentPrn() {
		System.out.println("부모 클래스의 메소드이다.");
	}
	
}


class Child extends Parent {
	
	/*
		public void parentPrn() {
			System.out.println("부모 클래스의 메소드이다.");
		}
		우리 눈엔 안보이지만, 부모 클래스의 메소드가 있는 것과 마찬가지인 셈이다!
	*/
	
	public void childPrn() {
		System.out.println("자식 클래스의 메소드이다.");
	}
	
}
public class Test78 {

	public static void main(String[] args) {
		// 자식 클래스(Child클래스)를 이용해 객체 생성
		Child child= new Child();
		// 부모 클래스(Parent클래스)로부터 상속받은 parent() 메소드 호출 가능
		child.parentPrn();
		// 자식 클래스(Child클래스) 자기 자신의 child() 메소드 호출 가능
		child.childPrn();
		System.out.println("====================================");
		
		
		Child child2 = new Child();
		child2.parentPrn();
		child2.childPrn();
		
		Parent parent2 = new Parent();
		parent2.parentPrn();
		//parent2.childPrn();
		
		
		
		
		Parent parent = new Parent();
		// 부모 클래스(Parent클래스)자기 자신의 parentPrn() 메소드 호출 가능
		parent.parentPrn();
		// parent.child(); 호출 불가 
		
		// 결론 : 
		// 상속이란 부모가 가진 재산이나 권력을 자식에게 물려주는 것
		// 자식 클래스가 부모 클래스의 멤버를 상속받아서 사용할 뿐,
		// 부모 클래스를 이용해 생성된 객체가 자식 클래스의 메소드를 호출해서 사용할 수 없다
		

	}

}
