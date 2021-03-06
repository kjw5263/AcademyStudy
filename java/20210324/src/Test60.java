/*
	생성자?
	- 객체 생성 시 딱 한번만 호출되는 메소드의 종류
	- 생성자의 역할 : 클래스로부터 객체 생성 시, 객체의 변수(상태)값을 초기화 하려는 목ㄱ 

*/


class Number {
	// 변수
	int number;
	
	// 생성자1
	// - new Number(); -> Number객체 호출 시 생성자를 호출하여 number변수의 값을 초기화한 것이었음! 
	// - 매개변수로 값을 전달받지 않고, number변수의 값을 10으로 초기화할 생성자
	public Number() {
		number = 10;
		System.out.println("기본 생성자 호출되었음, number = " + number);
	}
	
	
	// 생성자2
	// - 하나의 값을 매개변수로 전달받아 number 변수에 저장시키는 생성자
	public Number(int n) {
		number = n;
		System.out.println("생성자(매개변수1)가 호출되었음, number = "+ number);
	}
	
	
	// 메소드
	// - 위 Number 객체 생성 시, 객체 변수 num에 저장된 값을 반환하는 메소드
	public int getNumber() {
		return number;
	}
	
}



public class Test60 {

	public static void main(String[] args) {
		// Number 클래스를 이용하여 객체 생성하기
		
		// Number() 생성자 호출-> number변수값 초기화 -> Number객체의 주소값을 num1참조변수에 저장
		Number num1 = new Number();				
		System.out.println(num1.getNumber());

		// Number() 객체 생성 시 Number(int n) 생성자 호출 시 30을 넘겨주어 number값 초기화 
		Number num2 = new Number(20);
		System.out.println(num2.getNumber());
		
		Number num3 = new Number(40);
		System.out.println(num3.getNumber());
		
		// 결론 : 객체 생성 시 생성자를 호출하면,
		// 1. 객체를 생성하는 동시에 인스턴스 변수의 값을 초기화 할 수 있다. (한줄로 코드를 작성할 수 있다.)
		// 2. 단 한번만 호출되는 생성자이므로 final로 선언된 인스턴스 변수의 초기화에도 사용이 가능하다.
	}

}
