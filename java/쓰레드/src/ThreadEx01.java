/* 
 	스레드란?
 	- 하나의 실행 프로세스 내부의 하나의 작업 단위
 	
 	스레드를 사용하는 이유는?
 	- 동시에 여러가지 작업을 처리하고자 할 때 사용
 	
 	스레드 프로그램 (클래스)을 만드는 방법
 	1. Thread 클래스를 상속받아 쓰레드 프로그램(클래스)를 만드는 방법
 	2. Runnable 인터페이스의 추상 메소드를 오버라이딩 받아 쓰레드 프로그램(클래스) 만드는 방법
 	
 	
 	주제1. Thread 클래스를 상속받아 쓰레드 프로그램 (클래스)를 만드는 방법
 
*/


// Thread 클래스를 상속받아 하나의 작업을 처리하는 쓰레드 클래스 만들기
public class ThreadEx01 extends Thread {

	// 쓰레드 이름을 저장할 변수
	//String name;
	
	// 스레드 이름을 매개변수로 전달받아 저장하는 생성자
	public ThreadEx01(String name) {
		super(name);	// extends 해준 Thread 부모 객체의 생성자를 통해 스레드 이름 저장
		//this.name = name;
	}
	
	// 콜백 메소드란? 개발자가 호출하는 메소드가 아니라 거꾸로 시스템이 어느 시점에 자동으로 호출해주는 메소드
	// 작업 스레드 객체들이 해야할 일을 구현해야하는 콜백 메소드
	@Override
	public void run() {	//run 메소드는 무조건 하나만 만든다, 아래의 main쓰레드 내부의 t1,t2객체는 똑같은 일을 하게 된다
		int sum = 0;
		for(int i=0; i<10; i++) {
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			sum += i;
			System.out.println(this.getName() + ":" + sum);
			//System.out.println(name + ":" + sum);
		}
		
	}




	// 주 Main 쓰레드 <--- 무조건 하나만 존재
	public static void main(String[] args) {
		// 스레드 객체 2개 생성해서 저장할 변수 선언
		ThreadEx01 t1, t2;
		
		// 자식 작업스레드1 객체 생성
		t1 = new ThreadEx01("첫번째 쓰레드");	// 작업 스레드의 구별 위해 스레드 이름 지어주기
		
		// 자식 작업스레드2 객체 생성
		t2 = new ThreadEx01("두번째 쓰레드");
	
		// 총 3개의 스레드 있음, main/t1/t2
		
		// start() 메소드는 직접적으로 run() 메소드를 호출하진 않으나,JVM에 의해 자식 스레드가 각각 일할준비가 
		// 되었으니 JVM에게 run() 메소드를 호출하라고 부탁하는 메소드
		t1.start();
		t2.start();
		
		// Thread 클래스 상속받고 있기 때문에
		// run() 메소드 오버라이딩 해야함 
	}
	

}
