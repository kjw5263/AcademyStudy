
public class Test120 {

	public static void main(String[] args) {
		// String 클래스
		// -> 한번 생성된 다음 변하지 않는 문자열을 저장할 때 사용
		String str = "Play";
		System.out.println(str);
		
		str = "Life";
		
		System.out.println(str);
		
		// 결론 : 문자열 객체가 생성되면 수정되지 않는다
		//  str =" Life" 
		
		// 새로운 str = "Life" 객체의 메모리를 생성합니다.
		// 그럼, 처음에 선언한 str="Play" 문자열 객체 메모리는 어떻게 될까
		// 사용되지 않는 String 객체 메모리는 가비지컬렉터에 의해 제거
		
		str = str + "and Play";
		System.out.println(str);
		
		/* 
		 * 마찬가지로 String str 변수에 문자열 객체를 새롭게 생성하여
		 * 저장 했으므로 새로운 "Life and Play"문자열을 저장할 객체 메모리가
		 * 만들어지고, 기존에 존재했던 "Play" 문자열 객체 메모리와 
		 * "Life" 문자열 객체 메모리는 가비지 컬렉션에 의해 제거되어 사라짐
		 * 
		 * 문제점 : 같은 String 클래스의 참조변수 str에 문자열 객체를
		 * 생성해서 저장할 때 마다 새로운 String 객체 메모리를 생성해서
		 * 저장하게 되면 , 응용 프로그램 개발 시
		 * 프로그램 속도 느려짐
		 * 그래서 String 클래스에 대한 객체를 생성해야 한ㄴ 경우는
		 * 한번 저장되어 변하지 않는 문자열이 존재할 때만 
		 * String 클래스에 대한 String 객체 메모리를 생성해서 저장해서 사용하자
		 * 
		 * */
		
		
		
		/*
		 * StringBuffer 클래스에 대한 객체 메모리 생성
		 * -> 변할 수 있는 문자열을 저장할 용도의 객체 메모리를 만들 때 사용하는 클래스
		 * (가변 문자열)
		 * 
		 * 
		 */
		
		StringBuffer sBuffer = new StringBuffer("JAVA");
		
		// StringBuffer 객체 메모리에 저장된 "JAVA"문자열에 가변적으로 문자열 추가할 수 있다
		sBuffer.append("Programming");
		System.out.println(sBuffer.toString());
		
		// 결론 : 생성된 StringBuffer 문자열 객체 내부에 저장된 문자열이 수정된다
		// 새로운 StringBuffer문자열 객체가 만ㄷ를어지지않고
		// 처음에 생성한 StringBuffer문자열 객체의 내용이 수정되어 사용되므로
		// 프로그램 속도가 String 객체 메모리를 생성해서 문자열을 저장한것보다 더 빠르다

	}

}
