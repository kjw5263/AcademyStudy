/*  
	인터페이스를 이용한 다형성
	- 부모 인터페이스 타입의 참조변수에 자식객체 저장(업캐스팅)
	- 부모 인터페이스 타입의 참조변수에 저장된 자식객체의 주소를 이용하여
		자식객체 메모리의 멤버들을 참조할 수 있다. (업캐스팅)
	- 인터페이스 타입으로의 형변환도 가능하다.
	
 	
 
 */
interface X {
	public abstract void print();
	
}


class A implements X {

	@Override
	public void print() {
		System.out.println("난 A다");
		
	}
	
}


class B implements X {
	@Override
	public void print() {
		System.out.println("난 B다");
	}
}

// 인터페이스
interface Parsable {
	// 구문분석을 수행하는 기능을 구현할 목적으로 추상메소드 parse(String fileName)정의
	public abstract void parse(String fileName);
}


// 파일의 확장자가 xml이라는 것을 출력해주는 기능의 클래스
class XMLParser implements Parsable {

	@Override
	public void parse(String fileName) {
		// 구문 분석 작업을 수행하는 코드를 적는다.
		System.out.println(fileName + "-XML parsing completed.");	
	}
}

class HTMLParser implements Parsable {

	@Override
	public void parse(String fileName) {
		// 구문분석 작업을 수행하는 코드를 적는다.
		System.out.println(fileName + " - HTML parsing completed.");
		
	}	
}

class ParserManager {
	// 파일 형식을 화긴 후 그 형식에 해당하는 객체를 반환함
	public static Parsable getParser(String type) {
		// 만약 파일 확장자가 "XML" 이라면
		if(type.equals("XML")) {
			// XMLParser자식 객체 생성하여 메소드를 호출한 곳으로 리턴
			return new XMLParser();
		} else {	// "XML" 확장자가 아니라면
			//업캐스팅 
			Parsable p = new HTMLParser();
			return p;
			// 위 두줄을 한줄로 간단하게 나타내면 return new HTMLParser();
		}
	}
}

public class Test111 {

	public static void main(String[] args) {
		// X부모 인터페이스 타입의 참조변수에 자식객체 저장 (업캐스팅)
		X x = (X)new A();
		  x = new B();
		// ------------------------------------------------

		  // 업캐스팅
		  // 부모 인터페이스 타입 (Parseable) 참조변수 parser에 자식객체 저장
		  // XMLParser y = (XMLParser)ParserManager.getParser("XML");
		  Parsable parser = (Parsable)ParserManager.getParser("XML");	// new XMLParser();
		  					// new XMLParser().parse("document.xml");
		  parser.parse("document.xml");
		  
		  // 업캐스팅
		  	parser = ParserManager.getParser("HTML"); // new HTMLParser();
		  	// new HTMLParser().parse("document2.html");
		  	parser.parse("document2.html");
		  
	}

}
