import java.util.jar.Attributes.Name;

/// 스레드 만들기
//2. Runnable 인터페이스의 추상 메소드를 오버라이딩 받아 쓰레드 프로그램(클래스) 만드는 방법

public class Test implements Runnable {// t스레드 클래스가 아닌 단지 스레드가 일을 수행하는 코드가 존재하는 run메소드가 오버라이딩 되어잇는 Test클래스이다
	
	// 작업 작업중인 스레드 이름 저장할 변수
	String name;
	
	// 스레드 이름을 전달 받아 저장하는 생성자
	public Test(String name) {
		// super(name); 인터페이스는 생송ㅈ ㅏ x
		this.name = name;
		
	}
	//작업 스레드들이 해야할일 을 구현해야하는 콜백 run 메소드 오버라이딩
	@Override
		public void run() {
			int sum =0;
			for(int i=0; i<5; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				sum += i;
				// 현재 작업중은 스레드 이름 : sum 변수에 누적된 값 출력
				System.out.println(name + ":" + sum);
			}
		}
	
	
	// 메인 스레드
	public static void main(String[] args) {
		// 각 작업 스래드 객체들이 해야할 일이 코드로 구현되어잇는 run() 메소드를 작성해놓은 TEst 클래스에 대한 객체 생성 후 저장할 변수 선언
		Test t1, t2;
		// 참고 ! 각각의 Test 객체들은 작업 스레드 객체들이 아니다 
		t1 = new Test("첫번째 쓰레드 "); // 작업스레드 1이 일할 run() 메소드가 작성되어잇는 Test 객체 생성 
		t2 = new Test("두번째 쓰레드");
		
		// 실제 작업스레드 1 객체 생성시 작업 스레드1 이 일할 run 메소드가 작성되어잇는 Test객체를 생성자로 전달해 저장
		Thread tt1 = new Thread(t1);
		
		// 실제 작업스레드 2 객체 생성시 작업 스레드1 이 일할 run 메소드가 작성되어잇는 Test객체를 생성자로 전달해 저장
		Thread tt2 = new Thread(t2);
		
		// 위의 작업을 스레드화 작업이라고 한다
		tt1.start();
		tt2.start();
		
	}

}
