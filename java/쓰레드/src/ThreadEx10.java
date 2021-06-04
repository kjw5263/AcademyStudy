import java.util.Iterator;
import java.util.Map;

// 주제 : 스택 메모리 안에 현재 실행되고 있는 일반 쓰레드 + 데몬 쓰레드 정보 출력하는 예제

// 현재 실행되고 있는 스레드에게 5초 휴식을 제공하는 일을 하는 스레드
class ThreadDemo4 extends Thread {
	// 현재 실행되고 있는 스레드의 이름을 매개변수로 전달받아 저장할 생성자
	public ThreadDemo4(String name) {
		super(name);
	}

	@Override
	public void run() {
		// "현재 실행되고 있는" 쓰레드에게 5초 휴식주기
		try {
			// static 메소드라서 클래스명(상속받고 있는 Thread) 적어주지 않아도 된다.
			sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}


// 현재 실행중인 모든 스레드에 대한 정보를 화면에 출력하는 일을 하는 스레드
class ThreadDemo5 extends Thread {
	public ThreadDemo5(String name) {
		super(name);	// 부모 생성자 호출해서 name 설정 해주기
	}
	
	// 현재 실행중인 스레드에 대한 정보를 화면에 출력하는 일을 run 메소드 내부에 재구현 하자
	@Override
	public void run() {
		/*
			Thread클래스의 static 메소드인? getAllStackTraces() 메소드
			- 프로세스 내부에서 실행하는 모든 스레드에 대한 정보를 얻을 수 있습니다.
			- getAllStackTraces() 메소드는 Map 타입의 객체를 리턴하는데,
				key는 쓰레드 객체이고, value는 스레드의 상태기록들을 갖고있는 StackTraceElements[] 배열 입니다.
			
		*/
		// 스택 안의 현재 실행중인 모든 스레드 객체 (key)들과
		// key에 대한 스레드의 상태 기록들을 Map에 담아 반환
		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
		
		// 현재 Map 안에 있는 모든 스레드 객체(key)를 기준으로 해서 스레드에 대한
		// 스레드의 상태 기록들을 모두 담은 Iterator 반복자 구해온다
		Iterator iterator = map.keySet().iterator();
		
		// 스택 안에 있는 모든 스레드들의 순서를 나타낼 변수
		int x = 0;
		
		// Iterator 반복기에 현재 실행중인 (스레드객체(key), 스레드상태정보(value))에 대한 정보가 저장되어있을 때 까지 반복
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			// 다운 캐스팅
			Thread t= (Thread)obj;
			
			// 스레드 객체 (key)에 대한 스레드의 상태기록 정보를 얻어서 배열에 각각 저장
			StackTraceElement[] ste = (StackTraceElement[])map.get(obj);
			
			System.out.println("[" + (++x) + "] name : " + t.getName() + 
						", group : " + t.getThreadGroup().getName() + 
						", demon : " + t.isDaemon()
					);
			
			// 스레드 객체 (key)에 대한 스레드의 상태기록 정보 출력
			for(int i=0; i<ste.length; i++) {
				System.out.println(ste[i]);
			}	// for
			
			System.out.println();
		}	// while
	} // run
	
} // 클래스

public class ThreadEx10 {
	// 일반 스레드 (메인 스레드)
	public static void main(String[] args) {

		ThreadDemo4 t1 = new ThreadDemo4("첫번째 작업 쓰레드 ");
		ThreadDemo5 t2 = new ThreadDemo5("두번째 작업 쓰레드 ");
		t1.start();
		t2.start();
		
		// Finalizer 스레드
		// -> 가비지 컬렉션(현재 사용되고 있지 않은 객체 메모리를 제거를 위한 데몬 스레드),
		// -> System 쓰레드 그룹에 가입되어 있음
		
		// Reference Handler 스레드
		//-> 객체 메모리를 참조하기 위한 핸들러 역할을 하는 데몬 스레드
		
		// Attach Listener 스레드
		// -> 이벤트를 수행하기 위한 데몬 스레드
		
		
		/*
		
			[1] name : Signal Dispatcher, group : system, demon : true

			[2] name : 첫번째 작업 쓰레드 , group : main, demon : false
			java.base@15.0.1/java.lang.Thread.sleep(Native Method)
			app//ThreadDemo4.run(ThreadEx10.java:18)
			
			[3] name : Reference Handler, group : system, demon : true
			java.base@15.0.1/java.lang.ref.Reference.waitForReferencePendingList(Native Method)
			java.base@15.0.1/java.lang.ref.Reference.processPendingReferences(Reference.java:241)
			java.base@15.0.1/java.lang.ref.Reference$ReferenceHandler.run(Reference.java:213)
			
			[4] name : Notification Thread, group : system, demon : true
			
			[5] name : Attach Listener, group : system, demon : true
			
			[6] name : 두번째 작업 쓰레드 , group : main, demon : false
			java.base@15.0.1/java.lang.Thread.dumpThreads(Native Method)
			java.base@15.0.1/java.lang.Thread.getAllStackTraces(Thread.java:1649)
			app//ThreadDemo5.run(ThreadEx10.java:45)
			
			[7] name : Finalizer, group : system, demon : true	
			java.base@15.0.1/java.lang.Object.wait(Native Method)
			java.base@15.0.1/java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:155)
			java.base@15.0.1/java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:176)
			java.base@15.0.1/java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:170)
			
			[8] name : Common-Cleaner, group : InnocuousThreadGroup, demon : true
			java.base@15.0.1/java.lang.Object.wait(Native Method)
			java.base@15.0.1/java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:155)
			java.base@15.0.1/jdk.internal.ref.CleanerImpl.run(CleanerImpl.java:148)
			java.base@15.0.1/java.lang.Thread.run(Thread.java:832)
			java.base@15.0.1/jdk.internal.misc.InnocuousThread.run(InnocuousThread.java:134)


		*/
	}

}
