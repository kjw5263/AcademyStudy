/* 2개의 다중 쓰레드 (메인스레드 + 작업스레드)가 각각 두가지 작업 처리하게 하기 */

// 메인스레드가 있는 클래스
public class MultiThreadEx1 {
	
	static long startTime = 0;
	
	// 메인 스레드
	public static void main(String[] args) {
		MultiThreadDemo1 mtd = new MultiThreadDemo1();
		mtd.start(); // 시작 대기 후 run 메소드 호출됨
		
		startTime = System.currentTimeMillis();
		
		/* 싱글(주) 스레드 작업1 */
		// 10번 반복하면서 *을 1초에 한번씩 10번 찍기
		for(int i=0; i<10; i++) {
			// 싱글 스레드 1초 휴식 주기
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("*");
		}
		
		// 찍기 작업1 소요시간 (초) 구하기 : (별을 10번 찍은 후 현재시간-별10번찍기전 작업1 시작시간) / 1000;
		System.out.println("작업1 소요시간 " +  (System.currentTimeMillis()-startTime)/1000);
	}

}


//  작업(자식) 스레드 역할의 클래스
class MultiThreadDemo1 extends Thread{

	/* 작업 스레드가 두번 째 작업을 처리함 */
	// 1초 간격으로 10번 반복하면서 # 출력하는 두번째 작업
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			// alt + shift + z + y
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("#");
		}
		
		// 작업2 ㅅ요시간 : ( # 10번 출력후의 현재시간 - # 10번출력하기 전의 시작 시간) / 1000
		System.out.println("작업2 소요시간 : " + (System.currentTimeMillis()- MultiThreadEx1.startTime)/1000);
	}
	
	
}

// 결론
/* 
   2개의 쓰레드 (main, 작업스레드)가 각각 하나씩 하ㅏ나씩 작업을 할 때,
   하나의 스레드가 휴식 할 때 다른 쓰레드가 작업을 하는 것을 알 수 있다
    
  쓰레드를 먼저 선언했다고 해서 먼저 실행되는 것은 아니며, cpu가 임의로 실행시킴
  
  */
