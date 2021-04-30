import java.util.Iterator;
import java.util.Vector;

// 주제 : Vector 배열 내부에 저장된 객체 (데이터) 검색과 삭제 연습
/*
	참고!
	Vector 클래스 내부의 메소드
	
		int indexOf(Object 0) 메소드
		- 지정된 객체 (데이터)가 Vector 배열 내부에서 최초로 검출된 인덱스 위치번호를 반환

		E  remove(int index) 메소드
		- Vector배열 내부에서 지정된 인덱스 위치의 객체(데이터)

		boolean remove(Object 0) 메소드
		- Vector 배열 내부에 최초로 검출(검색)된 객체를 삭제하는 메소드, 삭제하면 true 실패하면 false
		
		boolean contains(Object o) 메소드
		- Vector 배열 내부에 매개변수로 전달받은 객체(데이터)가 포함되어 있으면 true 반환, 포함되어있지 않으면 false 반환
		
		

 */


public class Test137 {

	public static void main(String[] args) {
		// 컬렉션 API 내부에 존재하는 Vector 클래스에 대한 객체 생성
		Vector vector = new Vector();
		
		// 기본 생성자로 벡터 배열 객체를 생성하면 초기 용량은 10칸, 데이터가 모두 저장되어있는 상태에서
		// 새로운 데이터를 벡터에 추가하면 한칸식 늘어남
		
		
		double[] arr = new double[] {38.6, 9.2, 45.3, 6.1, 4.7, 1.6};
		
		for(int i=0; i<arr.length; i++) {
			// 위 Vector 배열에 new double[] 배열에 저장된 모든 데이터들을 꺼내어 추가 (저장)
			vector.add(arr[i]);
		}
		
		// 위 Vector 객체 배열에 저장된 객체(데이터)를 반복해서 얻어 출력
		for(int i=0; i<vector.size(); i++) {
			System.out.println(vector.get(i));
		}
		
		// 한줄 띄우기
		System.out.println();
		
		// Vector 객체 배열 내부에 저장된 데이터 검색
		// 1. 검색할 데이터를 저장할 변수 선언 후 6.1 저장
		double searchData = 6.1;
		//		6.1이 Vector 객체 배열에 저장되어 있으면 6.1이 저장되어 있는 위치의 인덱스 번호 반환
		int index = vector.indexOf(searchData);
		
		// 조건식
		if(index != -1 ) {
			// Vector 배열 내부에 검색한 6.1이 저장되어 있으면
			// index 변수에 저장되어 있는 값이 -1 이 아니면, 검색한 데이터가 저장되어 있다는 뜻
			System.out.println("검색 성공! 검색한 " + searchData + "는 ? " +vector.indexOf(searchData) + "번쨰 위치");
			
		} else {	// 검색할 데이터인 6.1이 Vector 배열 내부에 저장되어있지 않으면
			System.out.println("검색 실패 ");
		}
		
		
		// -------------------------------------------------------------
		// Vector 객체 배열 내부에 저장된 데이터 삭제
		// 1. 삭제할 데이터를 저장할 변수 선언하고 45.3 저장
		double delData = 45.3;
		// 2. Vector객체 배열 내부에 삭제할 데이터가 저장되어 있는지 판단 해주는 메소드 호출하여 조건판단하기
		if(vector.contains(delData)) {
			// 해당 delData변수의 값 45.3을 Vector 객체 배열 내부에서 삭제
			boolean result = vector.remove(delData);
			// result 변수에 값이 true 라면? -> 삭제완료 출력
			if(result == true) {
				System.out.println("삭제 완료");
			} else {
				// result 변수값이 false라면 -> 삭제 실패 
				System.out.println("삭제 실패");
			}
			
			// Iterator 인터페이스를 구현한 자식 배열 객체ㅔ Vector 배열에 저장된 모든 객체를 꺼내어 저장후 while문 이용해서 출력하자
			Iterator it = vector.iterator();
			
			while (it.hasNext()) {
				System.out.println(it.next());
			}
		}
	}

}
