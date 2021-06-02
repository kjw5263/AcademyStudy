import javax.swing.JOptionPane;

// Swing을 위한 import
// JOptionPane: ㅈ바 스크립트에서 입력받을 수 있는 메세지 박스 역할을 하는 클래스

public class SingleThreadEx02 {

	// 메인스ㄹㅔ드 (주스레드,싱글, 단일)에게 작업1, 작업2를 시키자
	public static void main(String[] args) {
		// 작업1 : 다이얼로그 창에 입력받은 내용을 화면에 출력하는 작업
		// showInputDialog 메소드의 반환 객체는 다이얼로그 창!!
		// 다이얼로그 창에서 입력받은 값은 String 문자열로 반환
		String input = JOptionPane.showInputDialog("아무것이나 입력하세요.");
		System.out.println("입력하신 값은 : " + input + " 입니다." );
		
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


// 결론 : 메인(main) 쓰레드에서 2개의 작업을 하는데..
// 		첫번째 작업1 (다이얼로그창 작업)이 끝난 후에 작업2(카운트다운작업)을 하는 것을 알 수 있다.