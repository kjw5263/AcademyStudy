
/*
	* 제네릭 메소드
	-> 한번에 서로 다른 데이터 형식을 출력해주는 기능의 메소드

*/
public class Test139 {
//	
//	public static void printArray(Object[] objArray) {
//		
//								// 1. 위와 같이 Object 타입의 매개변수로 모든 자식 배열을 받아야한다.
//								// 2. 아래의 향상된 for문에서도 마찬가지로 object 타입으로 참조해야함ㄴ
//		// 매개변수 intArray로 전달받은 integer 배열에 저장된 Integer 객체의 갯수만큼 반복해서
//		// 꺼내와 출력 -> 향상된 for문 사용
//		
//		
//		// Object 최고 부모 클래스 타입의 문제점
//		// Object 타입의 메모리 공간은 모든 클래스 타입의 최고 부뫃 클랴스 이므로
//		// Object 공간이 더 크므로 메모리 낭비가 된다.
//		// 그러므로 제네릭 메소드 만들어서 사용한다
//		for(Object element : objArray ) {
//			System.out.printf("%s", element);
//		}
//	}
	
	
	
	//  제네릭 메소드란
	//- 매개변수로 전달받은 데이터가 Integer 배열이든 Character 배열이든 상관없이
	// 매개변수로 전달받은 데이터를 그대로 전달바다 동적으로 실행하는 메솓 
	//- <> : of 로 읽음, 객체를 생성할 때 전달받을 타입을 지정하는 오브 기호!
	// 사용자 정의 제네릭 print 메소드 만들기
	public static <E> void printArray(E[] allArray ) {
		// 매개변수로 전달받은 배열의 타입에 맞게 for 조건식의 변수 또한 자동으로 바뀌어서
		// 자동으로 바뀐 클래스 타입의 참조변수에 allArray매개변수에 저장된 전체 배열의 객체들을 꺼내어 담을 수 있다.
		// E : 아직 결정되지 않은 타입
		
		// integer 배열을 받아오면, 메소드 전체의 유형<E>가 Integer로 바뀌고,
		// 그다음 매개변슈 <E>도 Integer로 변경된디ㅏㄴ
		
		for(E element : allArray) {
			System.out.printf("%s" , element);
		}
	}
	
	
	
	public static void main(String[] args) {
		// Integer 객체들을 저장시킬 배열 선언과 생성
		Integer[] intArry = { new Integer(1), 2,3,4,5 };

		// for문을 이용해서 위 integer 배열에 저장된 Integer 객체들을 반복해서 꺼내와 출력해도 되지만
		// 사용자 정의 printArray메소드를 하나 만들어서 main메소드 내부에서 
		// printArray메소드를 호출해보겠습니다.
		printArray(intArry);// -> 위 메소드 호출ㄹ시 Integer 배열 전달

		
		// Character 객체들을 저장시킬 배열 선언과 생성
		Character[] charArry = {'A', new Character('B'), 'C' };
	}

}
