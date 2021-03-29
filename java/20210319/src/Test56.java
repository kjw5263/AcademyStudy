
/*
	2단계  클래스 설계도 정의
	3단계  객체 생성 후 사용
*/

// 2단계 : 클래스 설계도 정의
// 생성할 클래스명 : Student
	// 클래스 내부의 변수 : 
	// 1. 학번 (4byte) : hakbun
	// 2. 학생이름 (문자열) : name
	// 3. 국어점수 (4byte) : kor
	// 4. 영어점수 (4byte) : eng
	// 5. 수학점수 (4byte) : math
	// 클래스 내부의 메소드 : 
	// 1. sum : 국어+수학+영어 점수 총합 구하는 기능의 메소드 (리턴값 : 총합, 매개변수 X)
	// 2. avg : 총 점수의 평균을 구해 8바이트의 실수값으로 리턴하는 메소드 (리턴값 : 평균값, 매개변수X)

class Student {
	int hakbun;
	String name;
	int kor;
	int eng;
	int math;
	
	int sum() {
		return kor + eng + math;
	}
	
	double avg() {
		return sum()/3.0;
	}
}



public class Test56 {

	public static void main(String[] args) {
		// 3단계 위 2단계에서 정의한 클래서 설계도를 이용해서 객체 생성 후 사용
		
		// Student 클래스를 이용해 객체 메모리를 생성, 생성 후
		// Student 클래스 타입의 s변수에 저장
		Student s = new Student();
		
		// 위 s변수에 저장된 Student객체의 객체변수(인스턴스변수) hakbun에 1 저장
		// 위 s변수에 저장된 Student객체의 객체변수(인스턴스변수) name 에 길동 저장
		// 위 s변수에 저장된 Student객체의 객체변수(인스턴스변수) kor 에 100 저장
		// 위 s변수에 저장된 Student객체의 객체변수(인스턴스변수) eng 에 85 저장
		// 위 s변수에 저장된 Student객체의 객체변수(인스턴스변수) math 에 90 저장
		s.hakbun = 1;
		s.name = "길동";
		s.kor = 100;
		s.eng = 85;
		s.math = 90;
		
		System.out.println(s.name + "의 총점 : " + s.sum());
		System.out.println(s.name + "의 평균 : " + s.avg());
		
		/*
			>>출력결과<<
			길동의 총점 : 275
			길동의 평균 : 91.66666666666667
		*/
		
		// Student 클래스를 이용해 객체 메모리 생성, 생성 후
		// Student 클래스 타입의 s1 변수에 저장
		Student s1 = new Student();
		
		// s1변수에 저장된 Student 객체 메모리 내부에 있는 hakbun객체 변수에 2 저장
		// name 객체 변수에 이몽룡 저장
		// 국어 95, 영어 80, 수학 95
		s1.hakbun = 2;
		s1.name = "이몽룡";
		s1.kor = 95;
		s1.eng = 80;
		s1.math = 95;
		
		System.out.println(s1.hakbun + "학번인 학생의 총점 : " + s1.sum());
		System.out.println(s1.hakbun + "학번인 학생의 평균 : " + s1.avg());
		
		/* 
			>>출력결과<<
			2학번인 학생의 총점 : 270
			2학번인 학생의 평균 : 86.6666666666667 
		 */
		
	}

}
