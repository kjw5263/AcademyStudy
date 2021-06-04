import java.util.Scanner;

/*
	어떤 값을 입력하여 엔터키를 누르면,
	결과가 오랜시간 뒤에 나온다고 가정할 때
	결과가 나오기 전에 약간의 효과를 줘서 '잠시만 기다려주세요..' 라는 메시지를 쓰레드 이용하여 처리하기
	예)
	숫자 입력 : __
	잠시만 기다려 주세요...  (<-쓰레드 이용하여 처리)
	결과 : ~~
*/

// 스레드가 할일을 구현해놓는 run 메소드가 선언되는, 클래스 만들기
class TestThread implements Runnable {	// 쓰레드 클래스(X) 쓰레드상속받아야만 쓰레드 클래스이고, 이건 run 메소드만 갖고있는 일반 클래스!!

	// 스레드가 할일을 구현해놓은 run 메소드 오버라이딩
	@Override
	public void run() {
		System.out.println("\n\n잠시만 기다려 주세요...");
		
	}
	
}
// 메인 스레드가 존재하는 클래스
public class ThreadEx05 {
	// 메인 스레드
	public static void main(String[] args) {
		System.out.print("숫자를 입력해주세요 : ");
		// 키보드로부터 입력받은 데이터를 바이트 단위로 읽어들일 스트림 통로 객체 생성
		Scanner sc = new Scanner(System.in);
		
		// 키보드로부터 입력받은 데이터들을 long 데이터로 스캔한 후 반환하는 메소드 호출
		long num = sc.nextLong();
		// ------------------------------------------------------------------------------
		
		//run() 메소드를 가지고 있는 객체 생성
		TestThread te = new TestThread();
		
		// 실제 작업 스레드 객체 생성시
		// run() 메소드를 가지고있는 new TestThread() 객체를 생성자로 전달해 스레드를 만들어준다
		Thread t = new Thread(te);
		
		//실제 작업 스레드 시작시키기
		t.start();
		
		// --------------------------------------------------
		
		// 숫자 0부터 우리가 입력받는 숫자까지의 총합을 계산하여 저장할 변수
		long total = 0;
		for(long i =0; i<num; i++) {
			total += i;
		}
		
		System.out.println("결과 : " + total);
		

	}

}
