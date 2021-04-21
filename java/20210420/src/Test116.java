// 주제 : 기본 자료형과 클래스형(참조자료형) 비교시 == 차이점
public class Test116 {

	public static void main(String[] args) {
		//1. 기본자료형 == 연산자 사용시
		// 	서로 데이터가 같은지 물어보기 위해 사용 
		int a = 10;
		int b = 10;
		
		String result = (a==b)? "같다" : "다르다";
		System.out.println(result);
		
		
		
		System.out.println("==============================");
		
		
		
		// 2. 클래스형(참조자료형) == 연산자 사용시
		// -> 두 객체가 동일한 메모리에 할당되어 있는지 물어보기 위해 사용
		// -> 두 참조변수에 저장된 객체 메모리가 같은 객체 메모리인지 물어보기 위해 사용
		String str01 = new String("안녕");
		String str02 = new String("안녕");
		System.out.println(str01==str02? "같다":"다르다");
		System.out.println(str01.equals(str02)? "같다":"다르다");
		
		System.out.println("==================================");
		PointTest1 c = new PointTest1(2, 3);
		PointTest1 d = new PointTest1(2, 3);
		PointTest1 e;
		e = c;
		// c 참조변수에 저장된 객체 메모리의 주소와 d 참조변수에 저장된 객체 메모리의 주소가 같은지 비교
		if(c == d ) {
			System.out.println("c == d");
		}
		if(c == e) {
			System.out.println("c == e");
		}
		
		// 결론
		// 1. 기본자료형(기본데이터) 비교시 == 연산자 사용하면
		// 데이터가 같은지 비교한다
		// 2. 참조자료형(객체)비교시 == 연산자 사용하면
		// 두 참조변수가 동일한 객체 메모리를 가리켜서 참조하는지 비교한다
		// 즉, 두 객체 메모리의 주소를 비교한다
	}

}


class PointTest1 {
	int x, y;

	public PointTest1(int x, int y) {
		// super();
		this.x = x;
		this.y = y;
	}
	
}