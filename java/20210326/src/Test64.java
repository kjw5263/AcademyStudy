// 지난 Test 59.java 파일에 작성한 과일장수 이야기
// 생성자를 이용하는 방법으로 업그레이드 시키기

/*
	FruitSeller(과일장수) 클래스 내부 수정
	1. 사과 한개당 가격을 저장할 APPLE_PRICE변수에 final 붙이자
	2. 추가한 initMembers 메소드 삭제
	3. 판매수익, 사과보유개수, 사과 한개당 가격을 변수에 저장시킬 생성자 추가
	
	
	
*/

// (2단계) 클래스 설계도 만들기
// 과일 판매자 FruitSeller 클래스 만들기
class FruitSeller {
// 변수
	// 사과 한개당 가격
	final int apple_price;
	
	// 보유하고 있는 사과 개수
	int numOfApples;
	
	// 판매수익 저장
	int myMoney;
	
	
	
	// 개발자가 생성자 한개 이상을 만들어 놓으면 JVM은 기본생성자를 만들지 않기 때문에
	// 직접 개발자가 생성자를 만들어 놓아야 한다.
//	public FruitSeller() {
//			// TODO Auto-generated constructor stub
//	}
	
	
	// 생성자 추가
	// new FruitSeller 객체 생성하는 동시에 호출되는 생성자 만들기
	// 생성자의 역할 : 판매수억, 사과보유개수, 사과 한개당 가격을 각 변수에 저장
	public FruitSeller(int apple_price, int numOfApples, int myMoney) {
		this.apple_price = apple_price;	// 사과 한개당 가격을 상수에 저장
		this.numOfApples = numOfApples;	// 사과 보유 개수 변수에 저장
		this.myMoney = myMoney;		// 과일장수 현재 잔액을 myMoney변수에 저장하자
	}




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
	
}



/*
	FruitBuyer(과일 구매자) 클래스 내부 수정
	1. 현재 보유하고 있는 현금 0원, 현재 소유하고 있는 사과수 0개로 저장
	2. 객체 생성시 구매자의 현재 소유하고 있는 현금, 사과 보유개수를 저장할 생성자 추가
	
	


*/

// 과일 구매자 FruitBuyer 클래스 만들기
class FruitBuyer {
// 변수
	// 원래는 초기값 설정 x
	// 현재 소유 금액
	int myMoney;
	
	// 현재 소유하고 있는 사과 개수
	int numOfApples;
	
	
	
// 생성자
	// new FruitBuyer(10000); 객체 생성시...
	// 또는 
	// new FruitBuyer(20000); 객체 생성 시
	// 현재 소유 금액을 생성자의 매개변수로 전달해서, 위 int myMoney변수에
	public FruitBuyer(int myMoney, int numOfApples) {
			this.myMoney = myMoney;
			this.numOfApples = numOfApples;
	}

// 메소드
	// 과일 구매의 메소드
	// 매개변수 : 과일을 구매하기 위한 판매자 대상 객체를 전달받은 변수
	//			과일 구매시 지불할 금액을 전달받을 변수
	void buyApple(FruitSeller seller, int money) {
		// seller1 = new FruitSeller(1500, 30, 0);
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





public class Test64 {

	public static void main(String[] args) {
		// 과일 판매자1 객체 생성
		// 객체 생성시 판매수익, 보유하고 있는 사과 수, 개당 가격 
		FruitSeller seller1 = new FruitSeller(1500, 30, 0);
		// 판매자1 ) 과일 판매자 잔고(0원), 보유 사과 개수(30), 개당가격(1500원) 확인하기
		
		// 과일 판매자2 객체 생성
		// new 객체 생성시, 판매수익(0), 보유사과개수20, 개당가격 1000
		// 객체 변수에 저장시킬 생성자 호출 
		FruitSeller seller2 = new FruitSeller(1000, 20, 0);
		
		// 과일 구매자 객체 생성과 동시에, 객체 변수의 값을 초기화 할 생성자 호출
		// 생성자 호출시 과일 구매자의 현재잔액 셋팅을 위해 10000원 전달
		FruitBuyer buyer1 = new FruitBuyer(10000, 0);
		
		
		// 과일 구매자 객체는 과일장수1 객체에게 4500원어치 사과 구매하기
		buyer1.buyApple(seller1, 4500);
		
		// 과일 구매자 객체는 과일장수2 객체에게 2000원어치 사과 구매하기
		buyer1.buyApple(seller2, 2000);
		
		System.out.println("==========과일 판매자1의 현재 상황==========");
		seller1.showSaleResult();
		System.out.println("==========과일 판매자2의 현재 상황==========");
		seller2.showSaleResult();
		System.out.println("==========과일 구매자1의 현재 상황==========");
		buyer1.showBuyResult();

	}

}
