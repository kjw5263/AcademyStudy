
/*
	하나의 클래스에서 여러개의 클래스를 상속하지 못하는 이유
	-> 다이아몬드 상속에 의한 문제가 발생할 수 있기 때문
	다이아몬드 상속이란? 같은 할아버지를 갖는 아버지뻘 클래스 두개의 상속을 받을 경우
					나에게 상속되는 것(속성이나 메소드)이 어느경로를 통해서 상속된 것인지 애매모호한 
					상황이 되기 때문에 발생한다
					"내 성격 고모?삼촌? 달믕ㄴ거야?"
	그래서 나온것이 인터페이스
	인터페이스는 다중 상속을 지원하는데, 이는 인터페이스의 껍데기(메소드의 구현이없이 상수나 추상 메소드)로만
	구성되어있는것)만 있기 때문에 다이아몬드 상속으로 인한 문제를 일으키지 않기 때문이다. 
	
	인터페이스(interface)란?
	- 추상 클래스와 비슷한 점이 있지만 한단계 더 추상화된 설계도
	
	인터페이스 작성 형식
		interface 인터페이스명{
			//상수
			public static final 타입 상수명 = 값;
			//추상메소드
			public abstract 추상메소드명(매개변수);
			
	인터페이스 사용하는 이유?
		1. 하나의 클래스는 여러개의 클래스를 다중으로 상속할 수 없기 때문에
			하나의 부모 클래스를 상속받고, 한개 이상의 부모인터페이스 내부의
			추상메소드를 자식클래스에 강제로 오버라이딩 해놓을 수 있기 때문
		2. 많은 사람들이 팀프로젝트를 진행할 때, 인터페이스를 통해 프로그램 구조를 만들고
		서로 다른 사람들이 약속된 이름으로 동일한 메소드를 재정의하기 위함.
		서로의 실수를 미연에 방지하고 효율적인 프로그램을 만들 수 있도록 하기 위해 사용
		
*/


// Clock 인터페이스 만들기
interface Clock {
	public static final int ONEDAY = 24;	// 상수
	
	// 추상 메소드
	abstract public int getMinute();		// 추상메소드
	abstract public int getHour();
	abstract public void setMinute(int i);	
	abstract public void setHour(int i);
}


// Car 인터페이스 만들기
interface Car{
	// public static final을 생략해도 아래의 MAX_SPEED는 상수로 인식한다
	/* public static final */ int MAX_SPEED = 260;
	
	// abstract을 생략해도 아래의 moveHandle메소드는 추상메소드로 인식한다.
	public /* abstract */ int moveHandle(int age);
	
	int changeGear(int gear);
}

// 인터페이스의 특징
// - 멤버는 추상 메소드와 상수만으로 구성
// - 모든 메소드는 public abstract이어야 하며, 이를 생략할 수 있다.
// - 모든 상수는 public static final이어야 하며 이를 생략할 수 있다
// - 인터페이스는 추상 메소드를가지기 때문에 객체를 생성할 수 없다. 
// - 인터페이스는 다른 인터페이스에 상속될 수있다.
// - 인터페이스 타입으로 참조변수를 만드는 것도 가능하다. 
// - ex) Clock clock;   Car car;
// - 예약어 implements 사용


public class Test107 {

	public static void main(String[] args) {
		// Clock 인터페이스 타입의 참조변수 clock 선언가능
		Clock clock;
		
		// Car 인터페이스 타입의 참조변수 car 선언 가능
		Car car;
		
		// 인터페이스 내부에 추상 메소드가 존재하기 때문에 객체 생성X -> 메소드 오버라이드 되지만 사용X
		// clock = new Clock();
		// car = new Car();
		
		
		
		
		
		
		

	}

}
