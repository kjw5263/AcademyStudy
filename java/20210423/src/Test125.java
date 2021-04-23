/*
	Boxing (박싱)
	- JVM 가상머신의 호출 스택상 메모리 공간에 있던 기본 데이터 타입의 데이터를
	JVM 가상 머신의 heap 상 메모리 공간에 객체를 생성해서 기본 데이터 값을 객체 메모리에 복사해놓는것
	- 기본 자료형의 데이터를 객체의 인스턴스 변수에 저장하는 작업
		--> 박싱한다
	- Boxing(박싱) 하는 방법
	int 데이터를 Integer 클래스의 객체 변수에 저장하는 방법
	-> Integer 클래스의 valueOf() 메소드를 사용함
	
	
*/

public class Test125 {

	public static void main(String[] args) {

		// 기본데이터 타입의 값을 변수에 저장
		int n = 10;
		// 참조 데이터 타입의 변수 num 선언
		Integer num;
		// Integer클래스의 valueOf메소드 호출시 기본데이터 10을 전달하면
		// new Integer(10); 객체에 10을 저장(박싱) 후 
		// new Integer(10); 객체를 리턴해준다
		
		num = Integer.valueOf(n);	// new Integer(10);
		
		/*    
			UnBoxing 언박싱
			// 객체의 인스턴스 변수에 저장되어 있는 기본 데이터 값을 꺼내는 작업
			
			방법
			// Integer class의 intvalue() 메소드를 사용함
			 * 
	*/
		
			Integer it = new Integer(10);
			// 언박싱
			int in = it.intValue();	// 기본 데이터 10을 꺼내온다
			// 언박싱
			int in2 = num.intValue();
			
			
			
			System.out.println(in);
			System.out.println(in2);
		
	}

}
