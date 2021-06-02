import javax.swing.JOptionPane;

public class MultiThreadEx02 {

	// 메인 스레드 작업1. 다이얼로그 창에 입력받은 내용 화면에 출력
	public static void main(String[] args) {
		
		// 작업 스레드 객체 생성 후 실행! -> 일처리 시킴
		new MultiThreadDemo2().start();
		
		// 작업1 : 다이얼로그 창에 입력받은 내용을 화면에 출력하는 작업
		// showInputDialog 메소드의 반환 객체는 다이얼로그 창!!
		// 다이얼로그 창에서 입력받은 값은 String 문자열로 반환
		String input = JOptionPane.showInputDialog("아무것이나 입력하세요.");
		System.out.println("입력하신 값은 : " + input + " 입니다." );

		
		
	}

}

// 작업 스레드 객체를 생성하기 위한 클래스
// 작업2. 카운트 다운 작업
class MultiThreadDemo2 extends Thread {

	@Override
	public void run() {
		// 작업2 : 카운트 다운 작업
		for(int i=10; i>0; i--){
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // for 끝
	}
	
}