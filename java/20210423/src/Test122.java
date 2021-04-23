/*
	주제 : 자바의 Wrapper 클래스들에 대해서 알아보자
	Wrapper 역할을 하는 클래스란?
	- 기본 자료형의 데이터들을 객체의 변수에 저장하기 위해 사용되는 클래스
	
	Wrapper 역할을 하는 클래스들의 종류
	- int -> Integer클래스
	- float -> Float 클래스
	- double -> Double 클래스
	- boolean -> Boolean 클래스
	- byte -> Byte 클래스
	- char -> Character
	- .....
	
	
	예) int a = 1;
		Object obj = 1;	// 1은 int 데이터이기 때문에 int-> Integer
		Object obj2 = 10.1;  10.1 double 데이터이기 때문에 double-> Double new Double(10.1)
							float -> Float  new Float();
	
	기본 자료형의 데이터를 Wrapper 클래스에 대한 객체에 저장하는 이유는?
	예) 
		showData(Object obj) 메소드를 만드시 활용해야하는 상황
		
		
		int -> 7
		int -> Integer 래퍼 클래스 제공 -> new Integer(7);
		
	public static void showData(Object obj) {
		// Object 클래스의 toString() 메소드를 통하여 반환되는 문자열 출력
		System.out.println(obj.toString());
	}
	
	
	이 메소드를 통해서 출력해야 하는 데이터가 정수 3과 정수 7이다
	이러한 상황에서 정수 3과 정수 7이 Object 클래스를 상속하는 객체 형태가 되어야만
	showData(Object obj) 메소드 호출 시 전달인자로 전달될 수 있다.
	객체의 참조값을 전달 받는 자리에는 기본 자료형 데이터를 전달해야 할 경우
	기본 자료형의 데이터를 기본 자료형의 대응되는 각각의 Wrapper 클래스들에 대한 객체의 변수에 저장 후
	매개변수로 Wrapper 역할을 하는 클래스에 객체 자체를 전달해서 사용해아한다.



*/

// int 데이터 저장하기 위한 Wrapper 역할을 하는 Integer 클래스 만들어보기
class IntWrapper extends Object {
	
	// int 데이터를 저장할 변수
	private int num;
	
	public IntWrapper(int data) {
		num = data;
	}

	
	
	// Object 클래스의 toString() 메소드를 IntWrapper 클래스에 맞게 오버라이딩
	@Override
	public String toString() {
		return num+"";
	}
	
	
}


public class Test122 {
	
	// 기본 데이터 정수 3과 정수 7을 Wrapper클래스에 대한 객체를 생성해서
	// 매개변수로 전달받아 정보를 출력해줄 메소드
	public static void showData(Object obj) {
		System.out.println(obj.toString());
	}
	
	

	public static void main(String[] args) {
		//IntWrapper intWrapper = 3;	// intWrapper 참조변수에는 원래 객체의 주소를 저장하기 때문에,
										// 기본 자료형의 값을 저장할 수 없다
										// IntWrapper 객체 생성해서 기본자료형(3)을 묶어 그 객체의
										// 주속밧을 갖고 있도록 하기
		IntWrapper intWrapper = new IntWrapper(3);
		// 기본자료형의 데이터를 객체로 묶는 작업 -> Boxing
		
		// new IntWrapper(3); 객체에 3이 저장되어 있으므로
		// new IntWrapper(3); 객체를 showData 메소드 호출시 전달하여 사용할 수 있따.
		Test122.showData(intWrapper);
		
		
		
		// 정수 7을 showData 메소드 호출시 전달하여 "7" 문자열 출력하기
		showData(new IntWrapper(7));
		
	}

}
