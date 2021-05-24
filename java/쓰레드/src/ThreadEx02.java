
public class ThreadEx02 {

	// 메인(주) 쓰레드 : 작업 스레드 1 객체 생성 + 0.5초 간격으로 점찍기 하는 메인 스레드
	public static void main(String[] args) throws InterruptedException{
		System.out.println("메인 스레드 시작");
		
		//  작업 쓰레드 객체 생성  : 1초 간격으로  숫자세기 하는 작업 스레드
		ThreadDemo1 td1 = new ThreadDemo1("작업 쓰레드");
		
		int count = 0;
		do {
			// 메인 스레드 (현재 CPU를 점유해서 일을 할수도 있는 쓰레드에게 0.5초간 휴식 후 .을 찍게 한다.
			Thread.sleep(1000);		// 0.5초 휴식
			System.out.println(".");
			count++;
			
		}while(count < 10); // 점 10번 찍게 하기
		System.out.println("메인 쓰래드 끝");

	}

}

// 숫자 세기 작업 스레드 객체 생성을 위한 작업스레드 클래스 따로 만들기
class ThreadDemo1 extends Thread {
	// 숫자를 세는 작업
	int count;
	
	// ThreadDemo1 쓰레드 객체 생성시 현재 작업하고 있는 스레드 이름을 매개변수로 전달받아 저장할 생성자
	public ThreadDemo1 (String name) {
		// 부모 쓰레드 객체의 생성자를 호출해 현재 작업중인 스레드 이름 저장
		super(name);
		// 초기화
		count = 0;
		
		// 작업 쓰레드 객체 일 시작! JVM 에게 요청
		this.start();
		
	}
	
	// 실제 작업 스레드가 하는 일을 기술하는 run 메소드 오버라이딩
	@Override
	public void run() {
		// 현재 작업을 시작한 쓰레드 객체의 이름 + "시작" 출력
		System.out.println(this.getName() + "시작");  // Thread 클래스 내부 쓰레드의 이름을 가져오는 메소드
		
		// 현재 작업을 하는 작업 쓰레드에게 1초 휴식 주기
		do {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		
			// 현재 작업을 하는 작업 스레드의 이름, 카운터 출력
			System.out.println(this.getName() + ", 카운터 = " + count);
			// 카운터 1 증가
			count++;
		} while(count < 10);
		// 현재 작업이 끝나는 스레드 객체의 이름 + "끝" 출력
		System.out.println(this.getName() + " 끝 ");
	}
}

// 실행 결과 : 시간의 텀을 줘서 주메인스레드와 자식 스레드가 일을 한다
