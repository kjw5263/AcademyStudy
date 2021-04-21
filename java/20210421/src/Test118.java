/* 
	java.lang.String 클래스
	- 자바에서 문자열을 담아두는 클래스
	- String 클래스를 이용해 String 객체 메모리가 한번 생성된 다음 변하지 않는 문자열을 저장해주기 위해 사용
	- String 객체 메모리에 문자열을 저장해두면 변경되지 않음을 보장
	

 
 */


public class Test118 {

	public static void main(String[] args) {
		
		// String 클래스를 이용해 객체 생성 방법 2가지
		// 방법1. 문자열 리터럴 상수를 직접 입력하여 String 객체 메모리를 생성하는 방법
		String s1 = "JAVA"; 
		
		// 방법2-1. String 클래스의 생성자를 사용하여 String 객체 메모리를 생성하는 방법
		//		   생성자의 매개변수로 문자열 리터럴 상수를 전달하여 문자열을 저장시킴
		String s2 = new String("programming");
		
		// 방법2-2. String 클래스의 생성자를 사용하지만, 문자열 초기화를 위해서
		//			전달받는 생성자의 매개변수가 char배열 타입의 변수로 선언
		char[] charArr = {'S', 't', 'r', 'i', 'n', 'g' };
		String s3 = new String(charArr);
		
		
		System.out.println("s1 참조변수에 저장된 String 객체 : " + s1);
		System.out.println("s2 참조변수에 저장된 String 객체 : " + s2);
		System.out.println("s3 참조변수에 저장된 String 객체 : " + s3);
		
		System.out.println("=====================================");
		
		// String 클래스로부터 객체 생성 2가지 방법의 의미
		// --> 객체 메모리를 JVM의 heap 영역에 할당하는 차이점
		// 방법2. String 클래스의 생성자를 이용하여 String 객체 메모리 생성
		String str1 = new String("JAVA");
		String str2 = new String("JAVA");

		
		// str1, str2 참조변수에 각각 동일한 String 객체 메모리를 사용할 수 있는지 비교
		if(str1 == str2) {
			System.out.println("서로 같은 String 객체 메모리를 사용!");
		} else {
			System.out.println("서로 다른 String 객체 메모리를 사용!");
		}
		
		
		
		// 방법1. 문자열 리터럴 상수를 이용하여 String 객체 메모리 생성
		String str3 = "JSP";		// str3 참조변수 --> "JSP" 문자열 객체 메모리 하나 
		String str4 = "JSP";		// str4 참조변수 -->
		
		
		if(str3 == str4) {
			System.out.println("서로 같은 String 객체 메모리를 사용!");
		} else {
			// 똑같은 문자열을 저장할 용도의 String 객체 메모리는 메모리를 더 사용하지 않고 재사용한다 
			System.out.println("서로 다른 String 객체 메모리를 사용!");
		}
		
		
		/*
			결론
			String 클래스는 같은 문자열 상수를 이용해 객체 메모리를 생성하게 되면
			같은 문자열 상수 "JSP" 데이터를 String 객체 메모리를 한번만 생성해서 저장하게 되며
			두 참조변수 str3, str4가 동시에 하나의 String 객체 메모리에 접근할 수 있게 된다.
		*/
		
		// String 클래스 내부에 만들어져 있는 다양한 메소드들
		String str5 = "JAVA_Study";
		//			   0123456789
		
		// String 객체 메모리에 저장된 문자열의 문자 갯수를 알아내기 위한 메소드 호출 - length()
		System.out.println("저장된 문자열의 문자 개수 : " + str5.length());
		
		// String 객체 메모리에 저장된 전체 문자열의 특정 인덱스 위치에 존재하는 문자 알아내는 메소드 호출, 인덱스는 0부터시자
		System.out.println("9인덱스 위치에 존재하는 특정 문자 : " + str5.charAt(9));
	}

}
