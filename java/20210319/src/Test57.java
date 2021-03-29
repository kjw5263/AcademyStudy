
// 주제 : 여러개의 객체 메모리를 만든 후, 그 객체 메모리들을 배열에 저장할 수 있다.

// 사람 클래스 만들기
class Person {
	// 변수 : 이름, 나이
		String name;
		int age;
	
	// 메소드 : 이름을 알려주는 메소드 
		String getName() {
			return name;
		}
}

public class Test57 {

	public static void main(String[] args) {
		// 객체 배열이란?
		// 생성된 객체 메모리에 대한 주소를 원소로 갖는 배열
		
		// 배열 생성
		// new Person() 객체 메모리들이 저장되어 있는 배열의 주소값을 담을 profile변수 선언
		// new Person() 객체 메모리들을 저장할 배열 메모리 생성 후 배열메모리의 주소를 profile변수에 저장
		Person[] profile = new Person[10];
		
		
		// profile변수에 저장된 new Person[10] 배열의 크기만큼 반복 -> 객체 10번 생성
		// 배열의 각 인덱스 위치에 저장 시킨다
		for (int i=0; i<profile.length; i++ ) {
			// 배열에 각 인덱스 위치에 새로운 new Person() 객체 생성 후 저장
			profile[i] = new Person();
			
			// 배열의 i변수에 저장된 인덱스에 존재하는 new Person() 객체 내부의 age객체 변수에 접근하여
			// 30~39살까지 저장
			profile[i].age = 30 + i;
			
			System.out.println("배열의 " + i + "번째 인덱스에 저장된 Person객체" + (i+1) + " 객체변수 age = " + profile[i].age);
		}
		
		
		
		// 배열에 각 인덱스 위치에 저장된 new Person()객체 내부의 age변수 값을 얻어 출력
		/*
			배열에 0번째 인덱스에 저장된 Person() 객체
		
		*/

	}

}
