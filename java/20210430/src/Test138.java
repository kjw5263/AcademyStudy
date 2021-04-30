import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;	// Map 인터페이스 타입의 참조변수 선언하기 위해 import 필수
import java.util.Set;


/*
	컬렉션 API 에서 제공해주는 HshMap 클래스
	최상위 인터페이스 Collection - 자식 인터페이스 Map - 자식클래스 HashMap
	
	Map 인터페이스를 구현한(추상메소드를 오버라이딩 해놓은) HashMap 자식클래스!
	- (키, 객체) 한쌍으로 묶어서 HashMap 에 저장
	- HashMap 객체 메모리는 한쌍의 데이터들을 순서를 유지하지 않는 객체(데이터)들의 집합
	- 키는 중복허용 X
	- 객체는 중복허용 O
	
*/
public class Test138 {

	public static void main(String[] args) {
		// 부모 Map 인터페이스 타입의 참조변수 map에 new Hashmap() 자식 객체를 생성해서 저장
		Map map = new HashMap(); // 업캐스팅
		
		// Map인터페이스 내부에 만들어져있는 추상 메소드
			// Object put(Object key, Object value) 메소드
				// 매개변수 value로 전달받는 객체(데이터)를 매개변수 key로 전달받는 키값에 연결하여
				// Map인터페이스를 구현한 자식 객체에 저장시키는 메소드
		
		// 참고 : HashMap 클래스에는 Map 인터페이스에 만들어져있는 put 추상 메소드를 오버라이딩 하여 정의해놓았음
		
		/* Hashmap 객체의 put 메소드를 이용하여 key와 value를 한쌍으로 묶어 한쌍씩 저장 */
		map.put(10, "one");
		map.put(20, "Two");
		map.put(30, "Three");
		map.put(10, "Four");
		map.put(20, "Five");
		map.put(30, "Six");
		map.put(70, "Seven");
		map.put(80, "Egiht");
		
		
		
		/* HashMap 객체에 저장된 모든 key들만 반환하여 Set 인터페이스를 구현한 
		 * KeySet 자식객체에 저장후 반환하기 때문에 Set부모 인페 타입의 참조변수에 keyset 자식객체 배열을 저장해야한다  */
		Set keys = map.keySet();	// Keyset 배열 -> [10,20,30, 60,70]
		
		
		// Set keySet() 메소드
		// -> Set : 리턴타입, KeySet() : 메소드 이름
		// -> HashMap 객체 내부에 저장된 모든 key 만 반환하는 메소드
		
		// Set 인터페이스 타입으로 반환된 객체를  저장하는 이유는?
		// -> HashMap 객체에 저장된 key들은 중복을 허용하지 않고 
		// Set 메소드 
		
		// Iterator인페로 출력하기
		Iterator itr = keys.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
			
			// 각각의 key를 이용하여 HashMap 객체 메모리에 저장되어 있는 value 객체 얻기
			// -> get(key넣기) 메소드 호출
			String value = (String)map.get(keys);
			
			System.out.println(keys + ":" + value);
		}
		
//		request.setAttribute(key, value);
//		request.getAttribute(key);
//		
//		HashMap.put(key, value);
//		HashMap.get(key);
		
//		request.setAttribute("List", new ArrayList());
//		request.getAttribute("List");
		
		
		
		// Vector, ArrayList, HashMap 무족권 아셔야 해여
		
		
		
	}

}
