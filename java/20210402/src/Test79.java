
/*
	주제 : 코드를 재활용하는 상속의 장점
	- 기존의 클래스에 새로운 내용을 추가하거나 변경할 때에,
		기존 클래스에 변경된 내용만 추가하여, 새로운 클래스를 만들어
		기존 클래스의 변수나 메소드를 그대로 사용할 수 있다.
	
*/

// 2차원 평면의 좌표값 한점을 나타내는 x, y를 저장하는 Point2D클래스 만들기
class Point2D{
	int n;
	
	// 은닉화시킨 변수
	private int x;
	private int y;
	
	// setter 메소드
	public void setX(int x) {
		this.x = x;
	}
	
	// getter 메소드
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y ;
	}
	
	public int getY() {
		return y;
	}
	
	public void prn() {
		System.out.println(y);
	}
}

// 3차원 공간상의 좌표값 한점을 나타내는 x,y,z를 저장하여 제공하는 Point3D클래스 만들기
class Point3D{
	private int x;	// Point2D 클래스의 x변수와 중복
	private int y;	// Point2D 클래스의 y변수와 중복
	private int z;
	
	
	// get으로 시작하는 메소드가 하는 역할
	// -> private로 선언된 변수값을 외부 클래스에 제공(반환)해줄 목적
	// set으로 시작하는 메소드가 하는 역할
	// -> 외부 클래스에서 현재 클래스의 private으로 선언된 변수에 접근하여 새로운값을 설정할 목적
	
	// 변수 하나당 setter 역할을 하는 메소드 getter 역할을 하는 메소드 만들기 단축키
	// alt + shift + s + r
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
	
}


//====================================================================================
// Point2D 클래스와 Point3D클래스의 중복된 코드간의 상속관계 도입!!!
// Point3D 클래스 수정! -> Point3DTest클래스 새로 만들기
// Point2D 클래스의 모든 멤버들을 상속받아 Point3DTest새로운 클래스 만들기
class Point3DTest extends Point2D{
	
	
	// private int x;
	// private int y;  가 현재 선언되어있는 것과 같은 꼴!
	private int z;
	
	/*
	 * Point2D 클래스로부터 상속받아 사용하는 메소드들 
	public void setX(int x) {
		this.x = x;
	}
	
	// getter 메소드
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y ;
	}
	
	public int getY() {
		return y;
	}
	*/
	public void setZ(int z) {
		this.z = z;
	}
	public int getZ() {
		return z;
	}
}


public class Test79 {

	public static void main(String[] args) {
		// 자식 클래스로부터 객체 생성
		Point3DTest pt = new Point3DTest();
		
		// Point2D 클래스로부터 상속받아 사용하는 setX() 메소드 호출
		pt.setX(10);
		
		// Point2D 클래스로부터 상속받아 사용하는 setY() 메소드 호출
		pt.setY(20);
		
		// Point3DTest클래스를 이용해 생성한 객체 자기자신의 setZ() 메소드 호출
		pt.setZ(30);
		
		// Point2D클래스로부터 상속받아 사용하는 getX() 메소드, getY() 메소드 호출
		System.out.print(pt.getX() + ", " + pt.getY());
		
		// Point3DTest 클래스를 이용해 생성한 객체 자기자신의 getZ() 메소드 호출
		System.out.println(", " + pt.getZ());
		

	}

}
