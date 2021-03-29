
public class Test61 {

	public static void main(String[] args) {
		// Point 클래스로부터 객체 생성 시 기본 생성자 호출
		Point point = new Point();
		
		// point변수가 참조하는 객체의 변수값 출력 
		System.out.println("x변수의 값 " + point.x);
		System.out.println("y변수의 값 " + point.y);
		
		// prn() 호출
		point.prn();
		
		// point참조변수가 참조하고 있는 객체의 x,y변수값을 10과20으로 다시 저장
		point.x = 10;
		point.y = 20;
		point.prn();
		
		point.setX(100);
		point.setY(200);
		
		System.out.println(point.getX());
		System.out.println(point.getY());
		
		
		System.out.println("==========================================");
		
		
		// x변수의 값을 초기화 시킬 생성자 호출을 이용한 객체 생성
		Point p2 = new Point(300);
		p2.prn();
		
		
		Point p3 = new Point(300, 500);
		p3.prn();
		
		//x변수,
		
		
		
		
		
		
	}

}
