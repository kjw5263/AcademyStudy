
/* 	주제 : 자바의 클래스 내부에 존재하는 변수에 대해서 알아보자  */

class Test {
	// 멤버 변수 종류 2가지
	// 1. 객체 변수 (인스턴스 변수)
	// - static단어가 붙어있지 않은 변수
	// - 새로운 new Test() 객체 생성할 때 마다 new Test() 객체 메모리가 개별적으로 가지고 있는 변수
	// - 객체가 생성될 때 마다 Heap영역의 객체 내부에 변수의 메모리를 할당 함 (-> 객체변수)
	int x;

	// 2. 클래스 변수 (정적 변수)
	// - static 단어가 붙은 변수
	// - class Test가 올라가는 JVM의 Method 영역에 메모리를 할당받는 변수
	// - 클래스 단위 당 한번만 메모리 할당함
	// - new Test() 객체 생성 하지 않고도 클래스 이름으로 바로 접근 가능한 변수
	// - 생성된 여러 new Test() 객체들이 공용으로 사용되는 변수 (-> 공용 변수)
	static int y;

	// 생성자
	// 매개변수 z의 값을 전달받아 x변수와 y변수에 각각 누적시키는 생성자
	public Test(int z) {
		x += z;
		y += z;
	}
}

public class Test70 {
	public static void main(String[] args) {
		Test test = new Test(10);
		System.out.println(Test.y);
		
		Test test2 = new Test(20);
		System.out.println(Test.y);
		
		
		
		
		/*
		 * // 1. 클래스 변수 y에 접근하여 출력하기 // 방법 : 객체 생성 없이 클래스명.클래스변수명 //Test test = new
		 * Test(10); System.out.println("클래스명.클래스변수명" + Test.y);
		 * 
		 * // 2. 인스턴스 변수 x를 객체 생성 없이 클래스명.인스턴스변수명으로 // 접근 가능? 불가능
		 * //System.out.println("클래스명.인스턴스변수명 = " + Test.x);
		 * 
		 * // 3. 인스턴스 변수 x에 접근하여 출력하기 위해 // new Test(10); 객체 생성하자 Test t = new Test(10);
		 * System.out.println("Test t1 객체 ");
		 * 
		 * // 인스턴수 변수 x에 접근하여 x변수값을 얻는 방법 // 참조변수명.인스턴스 변수명 System.out.println(t.x);
		 * 
		 * 
		 * // 클래스 변수 y에 접근하여 y변수값을 얻는 방법 // 참조변수명.클래스변수명 System.out.println(t.y);
		 * 
		 * // 결론 // static 으로 선언된 클래스 변수에 접근하는 방법 // 1. 클래스명.클래스변수명 접근가능 // 2. 객체 생성 후
		 * -> 참조변수.클래스변수명 접근가능 // ===========================================
		 * 
		 * 
		 * // Test 클래스로부터 객체 생성, 참조변수명 t2 Test t2 = new Test(10);
		 * System.out.println("Test t2객체");
		 * 
		 * // 인스턴스 변수 x에 접근하는 방법 : 참조변수명.인스턴스변수명 System.out.println(t2.x); // 10
		 * 
		 * // 클래스 변수 y에 접근하는방법 : 참조변수명.클래스변수명 System.out.println(t2.y); // 20
		 * 
		 * 
		 * // 결론 // 위 출력결과를 보면, static으로 선언된 클래스변수 y는? // 하나의 클래스 단위당 한개의 클래스 변수만? JVM
		 * 메모리에 올라가므로 // 위의 t1, t2 참조변수에 저장된 각 객체가 // 클래스변수 y하나를 공유받아 사용하므로, // 기본에 있던
		 * 클래스변수 y내부에 저장된 값이 += 누적된다고 보면됨
		 * 
		 * 
		 * 
		 * // 한번 더 확인! Test t3 = new Test(10); System.out.println("t3 객체"); // 인스턴수변수 x에
		 * 접근하여 인스턴수변수 x의 값 출력 System.out.println(t3.x); // 클래스변수 y에 접근하여 클래스변수 y의 값 출력
		 * // 방법2. 클래스명.클래스변수명; System.out.println(Test.y); // 방법2
		 * System.out.println(t3.y); // 방법1, 참조변수명.클래스변수명 둘다 가능
		 * 
		 * 
		 * 
		 * // y는 객체 메모리 공간에 할당되므로 값을 모두 공유한다 그래서 누적됨
		 * 
		 * 
		 * 
		 * 중요결론: 1. 객체 단위로 메모리 할당하는 인스턴스 변수는 인스턴스(객체) 개별적으로 따로 JVM heap영역에 할당하기 때문에 개별적인
		 * 인스턴스 변수로 10이 각각 저장된다 2. 클래스변수 y는 생성된 각 객체들이 공유받아서 사용할 목적으로 클래스를 설계할 때 생각하고
		 * 만들어주어야 한다. 3.
		 * 
		 * 
		 * 
		 */

	}
}
