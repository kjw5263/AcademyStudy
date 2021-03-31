// 클래스 내부의 멤버 변수 만들기 연습 1

// Student 클래스 만들기
class Student {
	// 인스턴스변수 선언 : 4바이트 크기의 정수를 저장할 num변수 선언 
	int num;
	// 클래스 변수 선언 : 4바이트 크기의 정수를 저장할 static Num변수 선언
	static int Num;	// -> 공용변수다!
	
	// 기본 생성자 선언 : 아무런 일도 하지 않음( 비워두자)
	public Student() {
		
	}
	
	// 메소드 선언 : 매개변수 add로 하나의 정수를 전달받아...
	//			  인스턴스 변수와 클래스 변수에 누적하는 기능의 메소드 선언
	void Add(int add) {
		num += add;
		Num += add;
	}
}

public class Test71 {

	public static void main(String[] args) {
		// 출력결과
		// 참조변수 a_student에 저장된 객체
		// 인스턴스 변수 num의 값 : 5
		// 클래스 변수 staticNum의 값 : 5
		Student a_student = new Student();
		a_student.Add(5);
		System.out.println(a_student.num);
		System.out.println(Student.Num);
		
		// 참조변수 b_student에 저장된 객체
		// 인스턴스 변수 num의 값 : 5
		// 클래스 변수 staticNum의 값 : 10
		Student b_student = new Student();
		b_student.Add(5);
		System.out.println(b_student.num);
		System.out.println(b_student.Num);
		
		
		// 인스턴스 변수와 클래스 변수의 차이점
		// -> 인스턴스 변수는 객체를 생성할 때 마다 객체 내부에 만들어지는 변수
		// -> 클래스 변수는 각 개체들이 공유하여 사용하는 공유 변수이므로,
		//	  맨 처음에 "java 클래스명" 명령문을 이용하여  클래스명.class를 실행할때
		//	  JVM 메모리의 Method 영역에 먼저 올라가는 변수
		
		
	}

}
