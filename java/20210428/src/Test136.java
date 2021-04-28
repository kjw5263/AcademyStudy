import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/*
	// * Enumerator 인터페이스
	 Enumerator 먼저 나오고 그다음에 iterator나옴

	Enumerator 인터페이스?
		-> 모든 컬렉션 배열 객체에 저장되어 있는
		각 객체(데이터)들을 반복해서 얻어올 때 사용되는 메소드들을 제공해주는 인터페이스
	
	  iterator 인터페이스의 추상 메소드
	  -> hasMoreElements : Enumerator인터페이스를 구현한 자식 객체에,
	 			컬렉션 배열에서 꺼내온 데이터들을 저장하고 있는지 물어보는 메소드 
	 			저장되어 있으면 true반환, 저장되어 있지 않으면 false 반환
	 			
	  -> nextElement() : Enumerator 인터페이스를 구현한 자식객체에
	  			컬렉션 배열에서 꺼내온 데이터들을 순서대로 꺼내올 때(얻을때, 리턴받을때) 사용하는 메소드
	  			
	  // Iterator 인터페이스보다 먼저 자바에서 소개된 인터페이스 이다.
	  
	  
	  // 주제 : Collection 최상위 인터페이스 - List 인터페이스 - Vector 클래스 <- Enumeration 인터페이스와 같이 사용해보기
	
*/
public class Test136 {

	public static void main(String[] args) {
		// Vector 컬렉션 클래스? 
		// - ArrayList 와 같은 객체(데이터)가 가득 차면 자동으로 저장영역을 늘려주는 가변길이 배열 공간
		
		// 4개의 객체(데이터)를 저장할수 있는 벡터 가변길이 배열공간 생성
		// 4개의 데이터가 모두 저장되면 하나의 데이터를 추가할 때마다, 3칸씩 자동으로 저장영역 늘려줌
		Vector vector = new Vector(4, 3);
		
		// 벡터에 저장된 객체(데이터)의 개수 출력
		System.out.println("벡터 배열에 저장된 객체(데이터)의 갯수 출력 : " +vector.size() + "개");
		
		
		// 벡터의 용량을 반환하여 출력 - capacity()
		System.out.println("벡터의 용량 : " + vector.capacity() + "칸");
		
		
		// for반복문을 이용하여 벡터에 0, 10, 20, 30, 40 추가
		for(int i=0; i<5; i++) {
			vector.add(i*10);
		}
		
		
		
		// 벡터에 저장된 객체(데이터)의 개수 출력
		System.out.println("벡터 배열에 저장된 객체(데이터)의 갯수 출력 : " +vector.size() + "개");
		
		// 벡터의 용량을 반환하여 출력 - capacity()
		System.out.println("벡터의 용량 : " + vector.capacity() + "칸");
		
		
		// 벡터 배열에 저장된 첫번째 객체(데이터) 꺼내와 출력 
		System.out.println("첫번째 객체(데이터) : " + vector.firstElement()); // 0
		
		// 벡터 배열에 저장된 두번째 객체(데이터) 꺼내와 출력 
		System.out.println("두번째 객체(데이터) : " + vector.get(1)); // 10
		
		
		// 벡터 배열에 저장된 마지막번째 객체(데이터) 꺼내와 출력 
		System.out.println("마지막번째 객체(데이터) : " + vector.lastElement()); // 0
		
		
		
		System.out.println("=========================================================");
		
		System.out.println("----------------for문을 이용해서 출력--------------------");
		for(int i=0; i<vector.size(); i++) {
			System.out.print(vector.get(i)+ " ");
		}
		
		System.out.println();
		System.out.println("---------------Iterator 이용해서 출력--------------------");
		Iterator it = vector.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		
		System.out.println();
		System.out.println("---------------Enumeration 이용해서 출력------------------");
		Enumeration enumeration = vector.elements();
		while(enumeration.hasMoreElements()) {
			System.out.print(enumeration.nextElement() + " ");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
