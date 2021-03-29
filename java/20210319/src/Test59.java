// Test 55.java 파일에 작성한 과일장수 이야기 업그레이드 시키기

// (2단계) 클래스 설계도 만들기
// 과일 판매자 FruitSeller 클래스 만들기
class FruitSeller {
// 변수
	// 사과 한개당 가격
	/* final */ int apple_price; /* =1000 */
	
	// 보유하고 있는 사과 개수
	int numOfApples;
	
	// 판매수익 저장
	int myMoney;
	
	
// 메소드	
	// 사과 판매하는 행동의 메소드
	int saleApple(int money) {		// 과일 구매자로부터 받은 돈을 매개변수로 얻는다
		// 판매한 사과 개수 = 사과 구매자로부터 받은 금액 / 사과 1개당 가격
		int num = money/apple_price;
		
		// 사과 판매 후 판매자의 보유 사과 개수 -> 차감
		numOfApples -= num;
		
		// 판매수익 누적
		myMoney += money;
		
		// 실제 판매(구매)가 발생한 사과 개수 반환
		return num;
		
	}
	
	
	
	// 사과 판매 후 현재 상태 출력하는 메소드
	void showSaleResult() {
		System.out.println("남은 사과 개수 : " + numOfApples);
		System.out.println("판매수익 : " + myMoney);
		System.out.println("");
	}
	
	
	// 추가할 메소드의 기능 : 과일 판매자의 처음 상태값을 저장시킬 기능의 메소드(초기금액,사과개수,사과금액)
	void initMembers(int money, int appleNum, int price) {
		myMoney = money;		// 판매자의 초기 자본금을 myMoney에 저장
		numOfApples = appleNum;	// 판매자가 처음 갖고 있는 사과 개수
		apple_price = price;	// 사과 개당 금액
	}
	
	
}


// 과일 구매자 FruitBuyer 클래스 만들기
class FruitBuyer {
// 변수
	// 원래는 초기값 설정 x
	// 현재 소유 금액
	int myMoney = 10000;
	
	// 현재 소유하고 있는 사과 개수
	int numOfApples = 0;
	
	
// 메소드
	// 과일 구매의 메소드
	// 매개변수 : 과일을 구매하기 위한 판매자 대상 객체를 전달받은 변수
	//			과일 구매시 지불할 금액을 전달받을 변수
	void buyApple(FruitSeller seller, int money) {
		// 과일 판매자 객체(seller참조변수활용)에게 과일을 구매하기 위해서
		// 과일 판매자 객체의 slaeApple(int money)메소드 호출 시, 돈을 매개변수로 전달
		// 그리고 과일 판매자가 판매한(과일 구매자가 구매한) 사과 개수 반환 받아옴
		// 과일 구매자 객체 관점에서, 구매한 사과 개수를 자신이 현재 소유한 사과개수에 누적
		numOfApples += seller.saleApple(money);
		
		// 과일 구매자는 과일 구매 후 사용한 돈만큼 차감 되야함
		myMoney -= money;
	}
	
	// 과일 구매 후 과일 구매자의 현재 남은 돈과 현재 갖고있는 사과 개수 출력
	void showBuyResult () {
		System.out.println("현재 잔액 : " + myMoney);
		System.out.println("현재 사과 개수 : " + numOfApples);
	}
}





public class Test59 {

	public static void main(String[] args) {
		// 과일 판매자1 객체 생성
		FruitSeller seller1 = new FruitSeller();
		// 판매자1 ) 과일 판매자 잔고(0원), 보유 사과 개수(30), 개당가격(1500원) 확인하기
		seller1.initMembers(0, 30, 1500);
		
		
		
		// 과일 판매자2 객체 생성
		FruitSeller seller2 = new FruitSeller();
		// 판매자2 ) 잔고(0원), 보유사과 개수(20), 개당가격(1000원)
		seller2.initMembers(0, 20, 1000);
		
		
		
		// 과일 구매자1 객체 생성
		FruitBuyer buyer1 = new FruitBuyer();
		// 과일 구매자1 객체는 과일판매자1 객체에게 4500원어치 사과 구매하기 위해
		// 과일 구매자 객체의 buyApple(FruitSeller seller, int money) 메소드 호출시
		// 과일 판매자 객체(new FruitSeller())를 매개변수로 전달하고,
		// 과일 구매 금액을 int money매개변수로 전달한다.
		buyer1.buyApple(seller1, 4500);
		
		// 과일 구매자1 객체는 과일판매자2 객체에게 2000원 어치 사과 구매
		buyer1.buyApple(seller2, 2000);
		
		
		
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer1.showBuyResult();
		
		
		
		/* 이 프로그램의 문제점 2가지 
		 * 1. 과일장수1, 2 객체를 생성하고 난 후에 상태값 초기화 해야한다.
		 * 		즉, 두 줄에 걸쳐서 문장을 구성해야 하나의 객체 생성을 완료할 수 있다.
		 * 
		 * 2. FruitSeller(과일장수) 클래스의 변수 APPLE_PRICE의 final 선언이 사라졌습니다.
		 * 		[final이 빠진 것이 왜 문제가 되는가?]
		 * 		클래스를 정의할 때, 과일장수가 판매하는 사과 한개당 가격은 변경되지 않는다는 가정을 두고,
		 * 		인스턴스 변수 APPLE_PRICE 를 final로 선언 했었습니다.
		 * 		그러나 메소드 내에서 APPLE_PRICE 가격을 초기화 하려다 보니, 
		 *		어쩔 수 없이 final 선언을 강제로 삭제 시켰습니다. 
		 *		메소드는 여러번 호출할 수 있으므로, 
		 *		initMember() 메소드를 여러번 호출 한다면,
		 *		객체가 다시 초기화되는 실수를 범할 수 있기 때문에, 딱 한번만 호출되는 ㅁ네소드를 사용해서 객체의 상태값을 단 한번만 
		 *		초기화 해서 생성해야함~~~
		 *
		 *
		 *	이 프로그램 문제점 해결 방법  : 딱 한번만 호출되는 메소드의 종류인? 생성자 이용
		 *
		 * */
		

	}

}
