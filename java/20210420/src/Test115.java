/* 
	Object 클래스의 toString() 메소드
	- 객체 메모리의 정보를 문자열로 변환해서 반환하는 메소드
	
	
	Object.java 소스는 다음과 같이 toString() 메소드를 정의하고 있다
	public String toString() {
		return getClass().getName() + '@' + Integer.toHexString(hashCode());
	}
 
 */

class PointTest extends Object {
	int x, y;

	public PointTest() {}

	// PointTest객체 생성시 x,y변수값을 초기화 할 목적의 생성자
	public PointTest(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// 개발자가 toString을 재정의 해놓으면 형식에 맞게 결과를 출력해준다
	@Override
	public String toString() {
		return "PointTest(" + x + ", " + y + ")";
	}
}



public class Test115 {

	public static void main(String[] args) {
		PointTest pt = new PointTest(2, 3);
		
		// 생성한 PointTest객체 메모리의 정보를 문자열로 출력
		// PointTest 클래스에서 toString()을 재선언한다면, 오버라이딩 된 메소드를 사용한다!
		System.out.println(pt.toString()  );  // PointTest@76ccd017
		// 참고 : Object 클래스의 toString 메소드 - 현 객체 메모리를 생성할 때 사용한 클래스 이름 얻어와서 '@'연결하고
		// 그 객체에 대한 해시코드값을 16진수로 변환하여 연결한 전체 문자열 리턴
		
		
		System.out.println(pt.toString());
		
		// Object 부모 클래스의 toString() 메소드 오버라이딩
		
		
	}

	

}
