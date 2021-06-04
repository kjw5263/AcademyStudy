
// 주제 : Thread와 객체의 구분에 대한 예제

public class ThreadEx03 {

	// main쓰레드
	public static void main(String[] args) {
		// 두개의 자식 쓰레드 생성
		ThreadDemo2 td1 = new ThreadDemo2("td1", 5);	// 쓰레드 이름, 쓰레드 휴식시간(초)
		ThreadDemo2 td2 = new ThreadDemo2("td2", 11);	// 쓰레드 이름, 쓰레드 휴식시간(초)
		
		// 각각 두개의 작업 스레드 실행 준비 상태로 만들기 (각각 두개의 작업 스레드 내부에서 run() 메소드의 실행을 함)
		td1.start(); // ->run()
		td2.start(); // ->run()
		
		
		// 두개의 다른 자식 쓰레드 객체에 있는 메소드를 호출함
		td1.method();  //ThreadDemo() 내의 메소드 이지만, main에서 호출했기 때문에 
		td2.method();  // main쓰레드 내부에서 실행된다.
		
		System.out.println("finished!!!");
	}

}
