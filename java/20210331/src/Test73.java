// 클래스변수, 인스턴스변수, 클래스메소드, 인스턴스 메소드 만들기 연습

// 상품 클래스 Product 만들기
class Product {
	// 상품명을 문자열로 저장할 클래스변수 modelName 만들기
	static String modelName;
	// 상품의 단가를 정수로 저장할 클래스 변수 unitPrice만들기
	static int unitPrice;
	// 상품명과 단가를 하나의 문자열로 만들어서 출력할 기능의
	// 클래스 메소드 print 만들기
	// 클래스명 생략 가능
	public static void print() {
		System.out.println("상품명 : " + Product.modelName + " 단가 : " + unitPrice);
	}
}
	

// 고객 클래스 Customer만들기
class Customer{
	// 고객명을 문자열로 저장시킬 인스턴스 변수 name만들기
	String name;
	// 고객의 나이를 정수로 저장시킬 인스턴스 변수 age만들기
	int age;
	// 기본 생성자 만들기
	public Customer() {
		
	}
	
	// 새로운 고객명을 매개변수로 전달받아 위 인스턴스 변수에 초기화할 생성자 만들기
	public Customer(String name) {
		this.name = name;
	}
	
	// 새로운 고객 나이만 매개변수로 전달받아 위 인스턴스 변수에 초기화할 생성자 만들기
	public Customer(int age) {
		this.age = age;
	}
	
	// 인스턴스 변수 name과 인스턴스변수 age에 저장된, 고객의 이름과 나이를
	// 하나의 문자열로 반들어서 반환할 인스턴스메소드 print만들기
	public String print() {
		return name + ", " + age ;
		
	}
	
	
	// 위 인스턴스 변수 name데이터와 인스턴스변수 age의 데이터를 하나의 문자열로 합쳐서 
	// 출력할 기능의 인스턴스 메소드 print만들기
	void print2() {
		System.out.println(name + "," + age);
	}
	
}

public class Test73 {

	public static void main(String[] args) {

		Product.modelName = "쉽게 배우는 자바";
		Product.unitPrice = 33000;
		Product.print();
		System.out.println("==========================");
		
		Customer c1 = new Customer();
		c1.name = "재벌 1세";
		c1.age = 31;
		System.out.println(c1.print());
		
		Customer customer2 = new Customer();
		customer2.name = "재벌 2세";
		customer2.age = 33;
		customer2.print2();
		
		
		
		// 출력 결과
		/*
		 	쉽게 배우는 자바, 33000원
		 	----------------------
		 	재벌 1세, 31
		 	재벌 2세, 33
		
		 */

	}

}
