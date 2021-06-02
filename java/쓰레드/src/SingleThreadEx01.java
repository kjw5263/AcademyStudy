/*  싱글 스레드에 대한 예제   */

// 이 프로젝트의 목적 : 싱글 스레드를 2개 돌렸을 떄 실행되는 순서?

public class SingleThreadEx01 {
	
	// 메인(주, 싱글) 스레드
	public static void main(String[] args) {
		// 싱글(주)스레드 작업 시작 시간 저장
		// System.currentTimeMillis() 메소드 : 
		// 1970.01.01부터 현재 날짜까지 경과한 millisec을 long 값으로 리턴
		// 밀리세텬(1/1000초)으로 반환
		long startTime = System.currentTimeMillis();
		/*
			1970년 1월 1일부터 현재까지 경과한 시간을 저장하는 이유는?
			작업할 때 걸린 시간을 측정하기 위함
		*/
		
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
		
		/* 싱글(메인) 스레드 작업2 */
		// 10번 반복하면서 #을 1초 간격으로 10번 씩기
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("#");
		}
		
		// # 찍기 작업2 소요시간(초) 구하기 : (#을 10번 찍은 후의 현재시간 -별 10번찍기전 작업1 시작시간) / 1000;
		System.out.println("작업2 소요시간 " +  (System.currentTimeMillis()-startTime)/1000);
	}

}
