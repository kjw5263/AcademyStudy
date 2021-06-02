import javax.swing.JOptionPane;

// 전 MultiThreadEx02.java 파일의 예제 업그레이드 시키기
// 업그레이드 내용 : 10초간 다이얼로그 창에 아무것도 입력하지 않으면 강제로 다이얼로그창 종료 되게 하기

public class MultiThreadEx03 { // 메인 스레드가 존재하는 클래스

	// 사용자가 10초 안에 데이터를 다이얼로그 창에 입력했는지 판단(검사)하는 플래스 변수
	// 플래그 변수 값이 true로 저장되면 ? (입력했음)
	// 플래그 변수의 값이 false로 저장되면? (입력 안함)
	static boolean inputCheck = false;
	
	// 메인스레드 : 두개의 작업 스레드 객체를 생성하고 실행시키는 역할만 함
	public static void main(String[] args) {
		// 작업 1을 하는 inputThreadDemo 클래스로부터 쓰레드 객체 생성 후 작업 시작 시키기
		new InputThreadDemo().start();
		// 작업 2를 하는 MultiThreadDemo3 클래스로부터 작업 스레드 객체 생성 후 작업 시작 시키기
		new MultiThreadDemo3().start();

	}

}


// 작업1  스레드 객체를 생성하기 위한 클래스 설계도
class InputThreadDemo extends Thread {

	@Override
	public void run() {		// 쓰레드가 해야할 일 작성하는 곳 (작업1. 다이얼로그 창에 입력받는 내용 출력)
		System.out.println("10초 안에 값을 입력해야 합니다");
		String input = JOptionPane.showInputDialog("아무것이나 입력하세요");
		System.out.println("입력하신 값은 " + input + "입니다.");
		// 다이얼로그창에 뎅;ㅣ터를 입력했으면 플래스 값을 true로 변경해주기
		MultiThreadEx03.inputCheck = true;
	}
	
	
}


// 작업2 스레드 객체를 생성하기 위한 클래스 설계도
class MultiThreadDemo3 extends Thread {
	@Override
	public void run() {	// 쓰레드가 해야할일 작성하는 ㅗㅅ (카운트 다운 작업 )
		for(int i=10; i>0 ; i--) {
			
			// 사용자가 10초 안에  다이얼로그 창에 입력한다면?? (inputCheck변수에 저장된 값이 true면)
			if(MultiThreadEx03.inputCheck == true) {
				return; // 카운트 다운 작업 끝내기 위해 for 반복문을 빠져나가자
			}
			
			System.out.println(i); // 작업
			
			try {
				Thread.sleep(1000); // 1초 휴식
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // for
		
		System.out.println("10초 동안 값이 입력되지 않아서 프로그램을 강제로 종료합니다. ");
		// 프로그램 강제 종료
		System.exit(0);
	}
}