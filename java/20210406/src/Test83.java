
// 주제 : 같은 패키지 내부에서 접근하는 접근 제어자 연습
class Super {
	
	// 접근제어자 public, 4바이트 크기의 정수를 저장할 num1변수 선언 후 10 초기화
	public int num1 = 10;
	// 접근제어자 protected, 4바이트 크기의 정수를 저장할 num2 변수 선언후 20 초기화
	protected int num2 = 20;;
	// 접근제어자 default, 4바이트 크기의 정수를 저장할 num3변수 선언 후 30 초기화 
	int num3 = 30;
	// 접근제어자 private, 4바이트 크기의 정수를 저장할 num4변수 선언후 40 초기화
	private int num4 = 40;
	
	// private으로 선언된 num4변수의 값을 반환하는 getNum4메소드 선언(접근 제어자 public)
	public int getNum4() {
		return num4;
	}
	
	
	
}

// Super 클래스를 상속받아 새롭게 정의하는 Sub클래스 만들기 
class Sub extends Super{
	// 접근제어자 private, 4바이트 크기의 정수를 저장할 num5변수 선언
	private int num5;
	// 접근 제어자 public , 리턴없음, return 메소드 선언
	public void print() {
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		//System.out.println(num4);
		System.out.println(getNum4());
		System.out.println(num5);
	}
	
}

public class Test83 {

	public static void main(String[] args) {
		// Sub 객체 생성 후 print 메소드 호출
		Sub sub = new Sub();
		sub.print();
		
	}

}
