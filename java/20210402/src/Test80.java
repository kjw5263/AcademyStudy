
/*
	상속연습
	(x,y)의 한점을 표현하는 Point 크래스와,
	Point클래스를 상속받아 컬러점을 표현하는 ColorPoint클래스를 새롭게 만들어보자

*/

// (x,y)의 한점을 표현하는 Point클래스(부모 클래스)선언
class Point {
	// 한점을 구성하는 x, y 인스턴스 변수 선언
	private int x;
	private int y;

	// 인스턴스 변수 x, y에 데이터를 새롭게 초기화 시킬 set메소드 만들기
	void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	//한점의 좌표 "(x,y)" 문자열형태로 출력하는 showPoint메소드 만들기 
	void showPoint() {
		System.out.println("(" + x + ", " + y + ")");
	}

}

// Point부모 클래스를 상속받아 새롭게 정의하는 ColorPoint클래스(자식 클래스) 선언
class ColorPoint extends Point{
	private String color;

	//점의 색을 매개변수로 전달 받아 새롭게 초기화시킬 setColor메소드 만들기
	void setColor(String color) {
		this.color = color;
	}
	
	//color변수에 저장된 컬러점의 좌표를 출력하는 기능의  showColorPoint메소드 만들기
		//출력기능
		//1. color변수의 값 출력
		//2. 한점의 좌표 "(x,y)" 문자열형태로 출력
	void showColorPoint() {
		System.out.println(color);
		showPoint();	// Point클래스로부터 상속받은 showPoint() 메소드 호출 가능
	}

}


public class Test80 {

	public static void main(String[] args) {
		// 출력결과
		// red(3,4)
		
		// 1. ColorPoint 객체 생성, 참조변수 이름 cp
		ColorPoint cp = new ColorPoint();
		// 2. 부모 클래스인 Point 클래스로부터 상속받은 set 메소드 호출시 3,4 전달
		cp.set(3, 4);
		// 3. ColorPoint객체의 color변수에 "red"문자열 저장하기 위해 메소드 호출
		cp.setColor("red");
		// 4. 컬러점의 좌표를 출력하는 showColorPoint메소드 호출
		cp.showColorPoint();
	}

}
