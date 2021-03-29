/*
다음과 같은 멤버(private변수,public메소드)를 가지는 직사각형을 표현하는 Rectangle 클래스를 작성하라.

-int 타입의 x1,y1, x2,y2 필드 : 사각형을 구성하는 두점의 좌표
-생성자 2개 : 기본생성자와 x1,y1,x2,y2의 값을 설정하는 생성자
-void set(int x1, int y1, int x2, int y2) : x1,y1,x2,y2좌표 설정
-int square() : 사각형 넓이 리턴
-void show() : 좌표와 넓이 등 직사각형 정보의 화면 출력
-boolean equals(Rectangle r) : 인자로 전달된 객체 r과 현 객체가 동일한 직사각형이면 true 리턴


//Rectangle을 이용한 main()메소드는 다음과 같으며 이main()메소드가 잘 작동하도록하라.

public class RectManager {
	public static void main(String args[]) {
				
		Rectangle r = new Rectangle();
	
		System.out.println("사각형r");
		r.show();
		System.out.println();
	
		System.out.println("사각형s");
	
		Rectangle s = new Rectangle(1, 1, 2, 3);
		s.show();
	
		System.out.println("사각형s의 넓이 : " + s.square());
		System.out.println();
		System.out.println("사각형r의 좌표를 (-2,2), (-1,4)로 수정");
		System.out.println();
	
		System.out.println("사각형r");
	
		r.set(-2, 2, -1, 4);
	
		r.show();
	
		System.out.println("사각형r의 넓이 : " + r.square());
	
		if (r.equals(s)) {
			System.out.println("두 사각형의 넓이는 같습니다.");
		}
	}
}

클래스 파일 2개생성  Rectangle.java   RectManager.java

*/
public class Rectangle {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	// 기본 생성자 
	public Rectangle() {
		
	}

	// 생성자
	public Rectangle(int x1, int y1, int x2, int y2) {
		//super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	// 메소드
	void set(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	// 사각형 넓이 출력
	int square() {
		return Math.abs(x2-x1) * Math.abs(y2-y1);
	}
	
	
	// 결과 출력
	void show() {
		System.out.println("좌표는 (" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + ") 입니다.");
	}
	
//	이 메소드를 호출한 클래스와 받아온r의 넓이를 비교할 것이므로, 이 클래스의 x,y값들로 계산하면된다!
	
	
	boolean equals(Rectangle s) {
		if (Math.abs(this.x2-this.x1) * Math.abs(this.y2-this.y1) == s.square()) {
			return true;
		} else return false;
		
		
	}
	
}
