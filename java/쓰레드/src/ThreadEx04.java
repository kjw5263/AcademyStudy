
public class ThreadEx04 {
	// 메인 스레드
	public static void main(String[] args) {
		ThreadDemo3 td = new ThreadDemo3();
		
		td.start();	// 새로운 작업 스레드가 생성되어 작업스레드에서 작업을 실행시키고 다시 main쓰레드로 돌아온다
		/*  >>실행결과<<
			java.lang.Exception
			at ThreadDemo3.throwException(ThreadDemo3.java:17)
			at ThreadDemo3.run(ThreadDemo3.java:9)
		*/
		
		
		
		td.run(); // 새로운 작업 스레드 객체가 만들어지는 것이 아니라 main() 스레드 내부에서 run메소드가 실행됨(메소드 강제로 호출)
		/*  >>실행결과<<
			java.lang.Exception
			at ThreadDemo3.throwException(ThreadDemo3.java:17)
			at ThreadDemo3.run(ThreadDemo3.java:9)
			at ThreadEx04.main(ThreadEx04.java:14)
		*/
		
		
		
		/*  >결론<
			1. start() 메소드 호출 시 작업 스래드가 생성되고, run() 메소드가 새로운 스택 공간에 놀려놓아 호출하게 됨
			2. run() 메소드 호출 시 작업 스레드가 생성되는 것이 아니라, main()메소드에서 run()메소드만 호출하는 것이다.
		 */
	}

}
