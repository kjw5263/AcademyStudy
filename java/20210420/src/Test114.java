/*
	Object 클래스
	
	1. java.lang.Object클래스
	2. 모든 자바 클래스의 최상위 클래스 (부모 클래스)
	3. 명시적으로 특정 자식 클래스 extends 특정 부모 클래스를 상속받지 않으면
		Object클래스를 특정 자식클래스에서 상속받음
	4. Object 클래스 내부에 만들어져 있는 자주 사용되는 생성자와 메소드들
		- protected Object clone() 메소드 : 현 객체와 똑같은 객체를 복사해서 만들어 리턴하는 메소드
		- boolean equals(Object obj) 메소드 : 매개변수 obj로 전달받는 객체와 현재 객체를 비교하여 같은 객체이면 true 리턴
		- int hashCode() : 현 객체 메모리를 식별할 수 있는 정수값인 해쉬코드 리턴
		- String toString() : 현 객체 메모리의 정보를 문자열 형태로 리턴하는 메소드
		- protected void finalize() : 객체를 더이상 사용하지 않을 때 쓰레기 수집기능 수행하는 메소드
		- void notify() : 현 객체에 대해 대기하고 있는 하나의 스레드를 깨우는 기능의 메소드
		- void notifyAll(): 현 객체에 대해 대기하고 있는 모든 스레드를 깨움
		- void wait() : 다른 스레드를 깨울 때 까지 현재 스레드를 대기 시키는 기능의 메소드
		- Class getClass() 메소드 : 현 객체를 생성할 때 클래스 이름을 Class클래스 타입으로 리턴하는 메소드
		
  */

class Point /* extends Object */{
	/* Point 클래스는 특정 부모 클래스를 상속받도록 명시적으로 작성해놓지 않았기 때문에 
	 * 모든 클래스의 최고 클래스인 Object 클래스를 상속 받은 클래스.
	 * 따라서 Object 클래스의 모든 메소드를 Point 클래스 내부에서 접근해서 사용할 수 있다. */
}


public class Test114 {

	public static void main(String[] args) {
		Object obj = new Point();
		// obj 참조변수가 참조할 수 있는 Point 객체 생성 시 사용한 클래스 이름 얻기
		System.out.println(obj.getClass()); 	// class Point
		
		// obj 참조변수가 참조할 수 있는 Point 객체 생성 시 사용한 클래스 이름을 문자열로 변환해서 반환
		System.out.println(obj.getClass().getName());  // Point
		
		
		// obj 참조변수에 저장된 Point 객체 메모리의 주소값을 10진수 고유코드 값 (해시코드)로 반환
		System.out.println(obj.hashCode());
		
		// obj 참조변수에 저장된 Point 객체 메모리의 정보를 문자열로 만들어서 반환
		// 문자열 정보 : (클래스 이름)@(16진수 형태의 해시코드 값) 반환
		System.out.println(obj.toString()); // Point@주소
		System.out.println(new Point().toString());  // Point@주소		

	}

}
