
// 작업 쓰레드 클래스
public class ThreadDemo2 extends Thread {
	String name;  // 스레드 이름
	int interval; // 스레드 휴식 시간 저장
	
	// 생성자 : 쓰레드 이름 및 휴식시간을 매개변수로 전달받아 초기화하는 생성자
	public ThreadDemo2(String name, int interval) {
		this.name = name;
		this.interval = interval;
	}

	
	// 작업 스레드가 할일을 구현 : 현재 작업을 수행중인 스레드 이름을 반복해서 출력하는 일
	@Override
	public void run() {
		for(;;) { // 무한반복
			// 작업 스레드 휴식 주기
			try {
				Thread.sleep(interval*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("ThreadDemo(" + name + ") Printed...");
		}
	
	} // run
	
	// method() 메소드는 작업 클래스 내부에 만들어져 있지만? main쓰레드에서 동작한다.
	public void method() {
		System.out.println("called from main()");
	}
	
	
}
