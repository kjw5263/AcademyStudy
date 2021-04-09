/* 07. 상속 연습문제 ( 328페이지 )  */
/*
	1. 
	 1) 자바는 다중상속을 허용한다 (O)
	 2) 부모의 메소드를 자식 클래서에서 재정의(오버라이딩)할 수 있다 (O)
	 3) 부모의 private 접근 제한을 갖는 필드와 메소드는 상속의 대상이 아니다 (O)
	 4) protected 멤버는 같은 패키지의 모든 클래스와 다른 패키지의 자식 클래스만 접근할 수 있다 (O)
	 
	2.
	 1) 부모의 메소드는 숨김 효과가 나타난다 (O)
	 2) 재성의 시 접근 제한을 더 강하게 할 수 있다 (X)
	 3) @Override를 붙이면 컴파일러가 재정의를 확인한다 (O)
	 4) 부모 메소드를 호출하고 싶다면 super 키워드를 사용할 수 있다 (X) 
	
	3.
	 1) 모두 상속과 관련이 있다 (X)
	 2) final 메소드를 가진 클래스는 부모 클래스가 될 수 없다 (O)
	 3) final 메소드는 재정의를 할 수 없다 (O)
	 4) final 클래스는 반드시 final 필드가 반드시 있어야한다. (O)
	 
	4. 컴파일 에러 이유 : Child클래스가 Parent클래스를 상속받아 Parent클래스의 멤버에 접근이 가능할지라도,
						this 키워드는 해당 클래스 내부에 존재하는 멤버 변수에 접근하는 키워드이므로
					  Child 클래스 안에서 Parent클래스의 멤버변수인 name에 직접적으로 접근할 수 없게 되어 컴파일 에러가 나게 된다.
					  
	5. 출력결과 :
		Parent(String nation) call
		Parent() call
		Child(String name) call
		Child() call
*/

class Parent{
	public String name;
	public Parent(String name) {
		this.name = name;
	}
}

class Child extends Parent{
	private int studentNo;
	
	public Child(String name, int studentNo) {
		// this.name;		// 4번 문제 
		super(name);
		this.studentNo = studentNo;
	}
}

public class Homework {

	public static void main(String[] args) {
		
		

	}

}
