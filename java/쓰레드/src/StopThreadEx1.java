// 주제 : 플래스 변수를 이용해서 현재 실행중인 스레드 강제 중지 시키기

// 작업 스레드의 일을 수행하는 run() 메소드가 존재하는 클래스
class StopThreadDemo1 implements Runnable {

	// 플래그 변수 : 스레드 진행 또는 중지에 대한 조건을 판단하는 값을 저장할 변수
	private boolean stopped = false;
	
	
	// 작업 스레드의 일을 수행하는 run() 메소드 오버라이딩
	@Override
	public void run() {
		while(!stopped) {
			// 메시지 출력 하는 일
			System.out.println("Thread는 현재 동작하고 있다....");
			// 메시지를 출력한 후 0.5초 휴식
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}	// while 끝
		System.out.println("Thread는 현재 Dead...");
		
	}
	
	// 스레드를 중지하기 위한 메소드 만들기
	public void stop() {
		// 스레드를 중지시키기 위해서 플래그 변수값을 true로 저장
		stopped = true;
	}
	
}


// 메인 스레드가 존재하는 클래스
public class StopThreadEx1 {
	
	//일반 메소드 : 작업 스레드 객체를 생성하여 직업 스레드 일 시작시키는 기능의 메소드
	public void process() {
		// run 메소드가 저장되어있는 클래스의객체 생성
		StopThreadDemo1 std = new StopThreadDemo1();
		
		// 실제 작업 스레드 객체 생성 
		Thread thread = new Thread(std);
		
		// 작업스레드 일시키기
		thread.start();
		
		// 작업 스레드 일 시킨 후 메인 스레드 1초간 휴식주기
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// stop 메소드를 호출하여 플래그 변수값을 true로 저장
		// 즉, 강제로 작업 스레드 일 중지시키기
		std.stop();
		
		StopThreadEx1 ste = new StopThreadEx1();
		ste.process();
		
	}
	
	// 메인 스레드
	public static void main(String[] args) {
		System.out.println("## 플래스 변수를 이용한 스래드 종료 기능 시작! ##");
		
		
	}

}
