import java.security.AccessControlContext;

/* 
	클래스 내부의 멤버변수 초기화 방법 (멤버변수에 값을 저장하는 방법)
	1. 명시적 초기화 (int a =10; static int b=100;)	
	2. 객체 생성 시 생성자를 호출해 초기화 (new A(10))
	3. 초기화 블럭을 이용
		1) 클래스 변수의 값을 초기화 시키는 클래스
			-> static{
				// 초기화 블럭
				}
		2) 인스턴스 변수의 값을 초기화 시키는 초기화 블럭
			-> {
				// 초기화 블럭
				}


 */


public class Test74 {

	// 1. 명시적 초기화
	int door = 4;
	
	// 2. 생성자를 이용한 초기화
	public Test74() {
		System.out.println("생성자를 이용한 변수값 초기화");
	}
	
	// 3. 초기화 블럭을 이용한 변수의 값 초기화
	// 	1) 클래스 초기화 블럭 이용
	static {
		
		System.out.println("호출 순서");
		System.out.println("static{클래스초기화 블럭사용}");
	}
	
	//  2) 인스턴스 초기화 블럭 이용
	{
		System.out.println("{인스턴스 초기화 블럭사용}");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main메소드로 진입하여 Test74 test74 = new Test74(); 객체생성 ");
		Test74 test74 = new Test74();
		
	}
	
	
	
	/*
		Test74.class 파일을 JVM이 실행하면서 JVM 메모리에 로딩될 때 호출순서
		순서1) static{ } 클래스 변수 초기화 블럭
		순서2) static main() 메소드 호출
		순서3) {  } 인스턴스 변수 초기화 블럭
		순서4) 객체 생성시 호출되는 생성자 실행
		
		실행결과로 알 수 있는것 !
		-> 클래스 변수 초기화 블럭은 처음 JVM 메모리에 로딩될 때 한번만 수행되었지만,
			
	*/


}
