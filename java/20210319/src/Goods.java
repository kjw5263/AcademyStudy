
// 문제 : 상품 하나를 표현하는 클래스 Goods 작성
/* 
	상품은 Goods 클래스로 표현
	String타입의 name, int타입의 price, numberOfStock, sold 등 네개의 변수(필드)를 갖는다
	Goods 클래스 내에 main() 메소드를 작성하여 Goods 객체를 하나 생성하고,
	이 객체에 대한 참조변수명은 camera로 하라.
	camera의 상품이름(name)을 "Nikon", 가격(price)을 400,000
	재고 개수(numberOdStock)를 30, 팔린개수(sold)를 50으로 설정하라
	설정된 이 값들을 화면에 출력하기
	
	출력결과
	상품이름 : Nikon
	상품가격 : 400000
	재고수량 : 30
	팔린수량 : 50

*/


public class Goods {
	String name;
	int price;
	int numberOfStock;
	int sold;
		
	
	public static void main(String[] args) {
		Goods camera = new Goods();
		camera.name = "Nikon";
		camera.price = 400000;
		camera.numberOfStock = 30;
		camera.sold = 50;
		
		
		System.out.println("상품이름 : " + camera.name);
		System.out.println("상품가격 : " + camera.price);
		System.out.println("재고수량 : " + camera.numberOfStock);
		System.out.println("팔린수량 : " + camera.sold);
		
		
	}
}
