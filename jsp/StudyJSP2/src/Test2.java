class Parent {
	public void pprn() {
		System.out.println("부모-pprn()");
	}
}

class Child extends Parent{
	public void cprn() {
		System.out.println("자식-cprn()");
	}
}


public class Test2 {

	public static void main(String[] args) {
				
		Parent p = new Parent();
		p.pprn();
		//p.cprn();
		System.out.println("======================");
		
		Child c = new Child();
		c.cprn();
		c.pprn();

		// 부모는 자식의 메소드를 빼앗아 쓰지 못한다.
		// 자식은 욕심이 많아서, 부모의 메소드까지 사용할 수 있다.
		
		
		System.out.println("=======업캐스팅==========");
		Parent p1 = new Child();		
		/*
			부모 레퍼런스에 자식의 인스턴스를 저장
			[p]
			[c] 의 형태로 붙어있음
		 */
		// 타입이 다른 객체가 저장되었으므로 업캐스팅이 자동으로 이루어졌음을 유추할 수 있고,
		// 상속 관계가 있다는 것 또한 유추할 수 있다. 
		p1.pprn();
		//p1.cprn();
		
		
		System.out.println("=======다운캐스팅==========");
		// 컴파일러가 자동으로 형변환 안해줌 -> 문제가 있기 때문에!
		// 다운캐스팅 : 업캐스팅이 먼저 이루어진 후에 다운캐스팅 해야한다.
		Child c1 = (Child)new Parent();
		//c1.pprn();
		//c1.cprn();	// 여기서 에러가 나는거야!
		
		
		/*
			자식 레퍼런스의 부모의 인스턴스를 저장
			강제형변환 -> 컴파일러에게 문제가 있음을 알고있음에도 실행하라고 하는것
		*/
		
		/*
			업캐스팅, 다운캐스팅 시에는 자바에서는 
			2번의 단계를 사용해서 에러 체크
			1) 컴파일시 - 컴파일 에러 체크 (코드 상 빨간줄)
			2) 실행할 때(런타임 에러) - 예외 체크 (코드에 문제 없을 때)
			
		*
		*/
		
		////////////////////////////////////////////////////
		
		Parent p2 = new Child();
		
		// p2에 child를 가지고 있지만, parent로 묶어놨기 때문에 child가 있는지 몰라!
		// (Child)로 캐스팅 해서 Child가 있다는 것을 알려주기

		Child c2 = (Child)p2;
		c2.cprn();
		c2.pprn();		
		
		
		// 메소드에 오브젝트를 넣는게 보이면, 업캐스팅이 이루어짐을 알면된다!		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
