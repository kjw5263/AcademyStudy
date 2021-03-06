import java.util.ArrayList;
import java.util.*;

public class ArrayListTest {

	public static void main(String[] args) {
		// 컬렉션 : 자료구조를 클래스로 구현한 형태, 제네릭
		// 컬렌션 중 하나인 ArrayList
		// int[] arr : 고정길이 배열
		// ArrayList : 가변길이 배열(동적배열) -> 데이터 크기 자동으로 변경
		//			(list 계열:순서를기억(index), 중복 허용
		
		
		ArrayList arr = new ArrayList();
		//E : 제네릭 
		
		// arr[0] = 100 (X)
		// 상속은 참조형 자료형들만 되는데, 어떻게 기본 자료형을 사용할 수 있냐?
		// 여기서 100, 200, true는 Wrapper 클래스를 통한 참조변수!
		// -> 기본형 변수를 참조형 타입으로 참조형 변경
		// Integer -> int
		// Character -> char
		// Boolean -> boolean
		
		
		// * 박싱:기본형->참조형 / 언박싱:참조형->기본형
		// => 오토박싱/오토언박싱
		// wrapper를 통해 박싱, 
		arr.add(100);	// wrapper 클래스 : 기본형테이터 타입을 참조형 으로변경
		arr.add(new Integer(200));
		arr.add("Hello");	// String -> Object 업캐스팅
		arr.add(true);		// 기본형 -> 참조형 (오토박싱) -> Object 업캐스팅
		
		
		System.out.println(arr);
		
		System.out.println(arr.get(2));
		
		arr.add(1, 500);
		System.out.println(arr);
		
		arr.remove(1);
		System.out.println(arr);	// 값보다 인덱스를 지우는게 더 효율적
		
		System.out.println(arr.size());
		

	}

}
