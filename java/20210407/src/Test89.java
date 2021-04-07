/*

	super 키워드 super, super()
	- 상속 관계의 부모 객체를 의미한다.
	- 상속관계의 자식 클래스에서 부모 클래스의 구성요소를 명시적으로 호출할 때 사용
	
	super 키워드 사용하는 2가지 경우
	1. 부모 클래스의 멤버와 자식 클래스의 멤버가 같은 이름일 경우
		-> 부모 클래스의 멤버를 사용할 때 "super.부모멤버이름" 사용
	2. 자식 클래스에서 명시적으로 부모 클래스의 생성자를 호출할 경우 
		-> super(매개변수) 형식으로 사용한다
		-> 주의점 : 반드시 자식 클래스의 생성자를 정의할 때,
				super(매개변수)는 첫번째 행에서 부모 생성자를 호출해야함
	
*/


class Person{	// 사람 클래스 -> 부모 클래스의 역할
	
	int age = 20;
	String name;
	
	public Person(String name) {
		this.name = name;
	}
}

class Man extends Person {
	int age = 40;
	// Person 부모 클래스의 인스턴스 변수 age와 Man 자식 클래스의 인스턴스 변수 이름이 같다.
	
	// 생성자
	public Man(String name) {
		// Person (부모) 생성자는 상속이 안되므로 
		// Man 생성자의 첫번째 행에서 Person(부모)생성자를 super(값)을 통해 호출
		super(name);
		// 명시적으로 부모 생성자를 호출하는 이유는?
		// 인스턴스 변수 name이 Man클래스가 아닌 Person(부모)클래스에 선언된
		// 인스턴스 변수이기 때문에, 변수가 선언된 곳에서 직접 데이터를 저장해야 한다.
		// 그러므로 자식 객체의 생성자를 호출한 후
		// 명시적으로 부모 객체의 생성자를 호출하면서 name값을 전달하여
		// 부모 클래서에서 name 변수의 값을 직접 저장해야한다.
		// 직접 저장한 후, Man에서 Person으로부터 name을 상속받아 사용한다.
		// -> 인스턴스 변수 name이 Man클래스가 아닌 Person부모 클래스에 선언된 인스턴스 변수이기 때문에
		// 변수가 선언된 곳에서 변수 초기화 작업을 해줘야 한다.
	}
	
	// 메소드
	public void getInfo() {
		System.out.println(age);	// 자식클래스 자신의 age변수 나이값 출력
		
		// 1. Person 클래스의 변수 age와 Man 클래스의 변수 age가 이름이 같다.
		// 이때 부모 person 클래스의 멤버를 사용하고 싶을 때
		System.out.println(super.age);
	}
	
	// 메소드
	public void getInfo2() {
		System.out.println("Person 클래스의 name변수값을 상속받아서 출력");
		System.out.println("=> " + name);
	}
}

public class Test89 {

	public static void main(String[] args) {
		// 자식 Man객체 생성시,, 생성자를 호출해 "홍길동" 전달 후 변수값 초기화
		Man man = new Man("홍길동");
		
		// Man() 자식 객체의 age변수 정보와
		// Person(부모) 객체의 age변수 정보를 얻어 출력하는 메소드
		man.getInfo();
		man.getInfo2();
		
		// Person클래스에 저장된 name변수의 값을 상속 받아서 이름 출력하기

	}

}
