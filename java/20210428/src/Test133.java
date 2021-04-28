import java.util.ArrayList;
import java.util.Iterator;

/*
	자바에서 제공해주는 컬렉션 API
	- 객체(요소, 데이터)를 담는 가변적 공간을 나타내는 클래스들의 묶음
	
	컬렉션 API
	
	- 최상위 Collection 인터페이스 제공
	- Set 인터페이스 제공
	- List 인터페이스 제공
	- Map 인터페이스 제공
	
	
	- Set 인터페이스를 구현한 자식클래스들 : 데이터를 순서없이 저장, 중복된 데이터 저장 불가능
	- List 인터페이스를 구현한 자식 클래스들 : 추가한 순서대로 데이터가 저장, 데이터 중복 저장가능
	- Map 인터페이스를 구현한 자식 클래스들 : 데이터 저장시 key:value를 한쌍으로 묶어서 저장,
	 								  이후에는 key를 이용해 Value얻는다
	 								  key <- 중복 저장 불가능
	 								  value <- 중복 저장 불가능
	
	주제 : Collection 최상위 인터페이스 - List 인터페이스 - ArrayList 클래스 
	
	
	
*/
public class Test133 {
	public static void main(String[] args) {
		// 기본 데이터들을 저장할 고정 배열
		int[] arr = {10, 20, 30};
		
		// 컬렉션 API에서 제공해주는 ArrayList 가변길이 배열?
		// -> 새로운 객체 데이터를 ArrrayList가변길이 배열에 추가할 때마다 배열 메모리 공간이 가변으로 늘어나는 가변길이 배열
		ArrayList a1 = new ArrayList();
		
		// 참고 : 최상위 Collection인터페이스의 추상 메소드를 구현한 ArrayList 클래스는
		// 데이터를 추가, 삭제, 데이터 갯수 등을 알아내는 Collection 인터페이스의
		// add() remove() size() 메소드 등을 이용할 수 있다.
		
		
		// auto Boxing에 의해 Object 객체(new Integer(10))로 업캐스팅 - 객체 저장 성공시 true (boolean값)
		// ArrayList배열에 0번째 인덱스 위치에 숫자 10을 오토박싱하여 저장
		a1.add(10);  
		
		// ArrayList 배열의 1번째 인덱스 위치에 숫자 20을 오토박싱하여 저장
		a1.add(20);
		
		a1.add(new Integer(30));
		
		
		// ArrayList 배열의 크기 : size() 메소드 호출
		// ArrayList 배열의 각 인덱스 위치에 저장된 객체 얻기 : get(intdex) 메소드 호출
		// ArrayList 가변길이 배열에 저장된 데이터의 개수만큼 반복하여
		// ArrayList 가변길이 배열에 저장된 데이터 얻기
		for(int i=0; i<a1.size(); i++) {
			//Object obj = a1.get(i);
			System.out.println(a1.get(i));
		}
		System.out.println("=====");
		
		// ArrayList 가변길이 배열의 특정 인덱스 위치에 저장된 객체(데이터) 제거 : remove(index) 메소드 호출
		a1.remove(1);
		
		for(int i=0; i<a1.size(); i++) {
			//Object obj = a1.get(i);
			System.out.println(a1.get(i));
		}
		System.out.println("=====");
		
		
		// ArrayList 가변길이 배열의 특정 인덱스 위치에 객체(데이터) 삽입 : set(index, value) 메소드 호출
		a1.set(1, 40);	// 1번째에 있던 값이 40으로 덮어써짐
		
		
		for(int i=0; i<a1.size(); i++) {
			//Object obj = a1.get(i);
			System.out.println(a1.get(i));
		}
		System.out.println("=====");
		
		
		System.out.println("==============================================");
		/* Iterator 인터페이스?
			-> 모든 컬렉션 배열 객체에 저장되어 있는
			각 객체(데이터)들을 반복해서 얻어올 때 사용되는 메소드들을 제공해주는 인터페이스
		
		  iterator 인터페이스의 추상 메소드
		  -> hasNext() : Iterator인터페이스를 구현한 자식 객체에,
		 			컬렉션 배열에서 꺼내온 데이터들을 저장하고 있는지 물어보는 메소드 
		 			저장되어 있으면 true반환, 저장되어 있지 않으면 false 반환
		 			
		  -> next() : Iterator 인터페이스를 구현한 자식객체에
		  			컬렉션 배열에서 꺼내온 데이터들을 순서대로 꺼내올 때(얻을때, 리턴받을때) 사용하는 메소드
		  
		
		
		*/
		
		
		
		ArrayList arrayList = new ArrayList();
		arrayList.add("Hi");
		arrayList.add("I\'m");
		arrayList.add("Jiwon");
		arrayList.add(3.14);
		arrayList.add(10);
		
		
		// 중요!! 
		// arrayList의 Iterator() 메소드를 호출하면
		//  ArrayList 배열에 저장된 모든 객체(데이터)들을 꺼내서
		// Iterator 부모 인터페이스를 구현한 자식 객체ArrayList$Itr에 저장 후
		// 자식 객체 자체(ArrayList$Itr 배열)를 반환한다.
		
		Iterator it = arrayList.iterator();
		// 즉 arraylist 배열. iterator 메소드 구현하면, 똑같은 새로운 배열을 만든다.
		// 그러면, 그 배열을 Iterator타입으로 반환한다 
		// ArrayList$Itr배열 ArrayList 배열에서 꺼내온 값이 저장되어 있는 동안만 반복 
		while(it.hasNext()) {
			// ArrayList$Itr 배열에 저장된 데이터를 순서대로 꺼내온다
			System.out.println(it.next());
		}
		
		
		
		
		// -> 전체를 for문으로 바꾼다면?
		for(Iterator iterator = arrayList.iterator(); iterator.hasNext(); ) {
			System.out.println(iterator.next());
		}
		
		
		//참조 : Iterator 인터페이스는 Collection 인터페이스의 iterator() 메소드를 상속받음
		//		Collection 최상위 인터페이스의 추상 메소드를 오버라이딩 해놓은 자식 컬렉션 클래스들에서
		//		iterator 메소드 사용 가능
	}
}
