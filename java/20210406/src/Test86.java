// 조합 4가지 중에서 
//-> 조합 2번. 부모클래스에 기본 생성자가 없는 경우 자식 클래스의 생성자와 부모 클래스의 생성자의 조합


class D {	// 부모 클래스 역할을 함
	private int d;
	
//	public D() {
//		
//	}
	
	// d인스턴스 변수의 값을 초기화할 생성자
	public D(int x) {
		this.d = x;
	}
}

class E extends D{
	//부모 클래스와 짝을 이루는 생성자가 없다
	public E() {
		System.out.println("생성자 E");
	}
	
	
	
}


public class Test86 {

	public static void main(String[] args) {
		// 
		E e = new E();
	}
	
	
	/*
	 * Exception in thread "main" java.lang.Error: Unresolved compilation problem:
	 * Implicit super constructor D() is undefined. Must explicitly invoke another
	 * constructor
	 * 
	 * at E.<init>(Test86.java:20) at Test86.main(Test86.java:31)
	 * 
	 * 결론 : 클래스 E의 생성자와 짝을 이룰 기본 생성자가 클래스 D에 없으므로,
	 * 		컴파일러에 의해 오류 메시지가 나타남
	 * 		클래스 D에 아무런 생성자도 정의되어있지 않은 경우에만
	 * 		컴파일러에 의해서 기본 생성자가 자동으로 정의 된다.
	 */	

}
