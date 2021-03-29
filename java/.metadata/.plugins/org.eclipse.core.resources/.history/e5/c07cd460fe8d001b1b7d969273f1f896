/*
	this와 this()
	
	this참조변수
	- this 참조변수는 인스턴스(객체)기 바로 자기자신의 멤버를 참조하는데 사용하는 변수
	  이러한 this참조 변수는 해당 인스턴스(객체)의 주소를 가지고 있다.
	  

*/

class Car{
	// 변수
	private String modelName;	// 변수를 선언할 때, 변수명 앞에 private를 붙이면
								// Car외부의 클래스에서 Car클래스 내부의 modelName변수에 접근X
	private int modelYear;
	private String color;
	private int maxSpeed;
	private int currentSpeed;
	
	// 생성자 - 역할 : new Car() 객체 생성시.. Car() 생성자를 호출해 변수의 값들을 저장할 역할
	
	Car (String modelName, int modelYear, String color, int max) {
		this.modelName = modelName;
		this.modelYear = modelYear;
		this.color = color;
		// 매개변수 max이름과 위의 객체변수 maxSpeed이름이 다를때는
		// this.maxSpeed = max; 구문에서 this.은 생략 가넝
		maxSpeed = max;
	}
	// 위 예제처럼 생성자의 매개변수 이름과 인스턴스 변수 이름이 같을 경우에는
	// 인스턴스 변수명 앞에 this참조변수(키워드)를 붙여 구분해야만 한다
	
	// 이렇게 자바에서는 this참조변수를 사용하여 인스턴스 변수에 접근할 수 있다.
	// 이러한 this참조변수를 사용할 수 있는 영역은 인스턴스 메소드 뿐이며
	// 클래스 메소드에서는 사용할 수 없다
	// 인스턴스 메소드에는 this참조변수가 숨겨진 지역변수로 존재하고 있다
	
}



////////////////////////////////////////////////////////////////////////////////////////////////
/* 
	this() 메소드
	- this() 메소드는 생성자 내부에서만 호출해서 사용할 수 있으며,
	  같은 클래스의 다른 생성자를 호출할 때 사용
	  
	- this() 메소드에 인수를 전달하면, 생성자 중에서 매개변수의 개수와 타입이 일치하는
	  다른 생성자를 찾아서 호출해줍니다.


*/
class Car1{
	// 변수
	private String modelName;	// 변수를 선언할 때, 변수명 앞에 private를 붙이면
								// Car외부의 클래스에서 Car클래스 내부의 modelName변수에 접근X
	private int modelYear;
	private String color;
	private int maxSpeed;
	private int currentSpeed;
	
	// 생성자 - 역할 : new Car() 객체 생성시.. Car() 생성자를 호출해 변수의 값들을 저장할 역할
	
	// 기본 생성자 - new Car(); 을 했을 때 Car객체 생성되고, 그 안에서 또 다른 생성자 호출함
	Car1 () { // 두번째 생성자
		// 다른 생성자를 호출하는 this() 메소드 작성
		this("소나타", 2020, "Black", 250);	// (주석제외)첫번째 줄에서만 다른 생성자 호출 가능
	}
	
	
	// 첫번째 생성자
	Car1 (String modelName, int modelYear, String color, int max) {
		this.modelName = modelName;
		this.modelYear = modelYear;
		this.color = color;
		// 매개변수 max이름과 위의 객체변수 maxSpeed이름이 다를때는
		// this.maxSpeed = max; 구문에서 this.은 생략 가넝
		maxSpeed = max;
	}
	
	
	// 자동차(new Car1() 객체)에 대한 정보를 하나의 문자열로 만들어 반환
	public String getModel() {	
		return this.modelYear + " 년식" + this.modelName + " " + this.color;
	}
	
}


public class Test65 {
	public static void main(String[] args) {
		// Car car = new Car("K5", 2021, "블랙", 600);
		String car1Info = new Car1().getModel();
		System.out.println(car1Info);
		
		/*
		 	위 예제에서, 매개변수를 가지는 첫번 째 생성자는 this참조변수를 사용하여
		 	인스턴스 변수 (객체 변수)에 접근하고 있습니다.
		 	또한 매개변수를 가지지 않는 두번째 생성자는 내부에서 this() 메소드를 이용하여
		 	첫번째 생성자를 호출한다. 
		 	이렇게 내부적으로 다른 생성자를 호출하여 인스턴스 변수를 초기화 할 수 있다.
		 	단, 한 생성자는 다른 생성자를 호출할 때는 해당 생성자의 첫줄에서만 호출할 수 있다.
		*/
		
	}
}
