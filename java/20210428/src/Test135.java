import java.util.HashSet;
import java.util.Set;

/*
	최상위 Collection 인터페이스 - Set 인터페이스 - HashSet클래스
	잘 안쓰이긴 해
	
	// Hashset 클래스
	  1. 객체(데이터)를 추가하면 순서대로 저장되지 않고, 랜덤으로 저장되는 공간
	  2. 객체(데이터)를 중복으로 저장할 수 없다.
	  
	  
	// 주제 : set인터페이스를 구현한 Hashset 배열
*/


public class Test135 {

	public static void main(String[] args) {
		// 부모 set 인터페이스 타입의 참조변수에 자식 HashSet 객체를 생성해서 저장할 수 있다. (업캐스팅)
		Set set = new HashSet();	// Hashset set = new HashSet(); 가능
		
		
		// HashSet 컬렉션 공간 안의 객체(데이터)개수 : 0
		System.out.println("HashSet 컬렉션 공간 안의 객체(데이터)갯수 : "+ set.size());
		
		// HashSet 컬렉션 객체에 객체(데이터) 추가
		set.add("한나");
		set.add(new Integer(2));
		set.add(2);					// 2가 중복
		set.add(3.46);
		set.add(new Float(5.23));
		set.add("여섯");
		set.add(7);

		
		System.out.println("HashSet 컬렉션 공간 안의 객체(데이터)갯수 : "+ set.size());
		// -----> 2가 중복이 되므로, 이전에 저장되어있던 2가 사라진당
		
		
		// Hashset 컬렉션 객체 메모리에 저장된 모든 데이터를 가져와서 출력하기
		System.out.println(set.toString());
		
		
		
		/*
			HashSet 클래스 APi에서 add(E e) 메소드 살펴보기
			
			boolean add(E e) 메소드 : 지정된 요소가 이세트의 요소로서 존재하지 않은 경우에 그 요소를 셋에 저장
			
			해설 : 추가시킬 객체(데이터)가 HashSet 컬렉션 배열 공간에 저장되어있지 않은 경우에,
				추가시킬 객체(데이터)를HashSet 컬렉션 배열 공간에 추가시킨다는 듯
				
			////////////////////////////////////////////////////////
			boolean add(E e) 메소드의 매개변수 타입에 대해서 알아보자
			///////////////////////////////////////////////////////
			
			 매개변슈 E타입이라는 것은 모든 객체를 전달 받을 수 있는 제네릭 타입을 말하고
			 제네릭 타입이라는 것은 아직 결정되지 않은 타입이라는 뜻이다.
			 
			 new HashSet()<String>;
			
		*/
		
		HashSet<String> hashSet = new HashSet<String>();
		
		//hashSet.add(1);	// String 객체만 저장할 수 있다.
		//hashSet.add(new Character('고')); 		//String 객체만 저장할 수 있다
		hashSet.add("String타입"); // 가능
		
		// 결론 : 1. HashSet 컬렉션 배열에는 객체(데이터)가 순서없이 랜덤으로 저장됨
		//		2. 중복 저장 X
		
		
		
		
		
		
		
		
		
		
		
	}

}
