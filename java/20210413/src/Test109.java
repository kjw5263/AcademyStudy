/*  인터페이스 연습1  */
// MobilePhone 인터페이스 만들기
// 인터페이스 안의 메소드는 전부 abstract으로 본다(생략 가능)
interface MobilePhone {
	// 전화거는 기능을 정의 해놓을 sendCall 추상 메소드 만들기, 리턴 타입 Boolean
	public abstract boolean sendCall();
	
	// 전화받는 시능을 정의 해놓을 receiveCall 추상 메소드 만들기, 리턴 타입 Boolean
	public abstract boolean receiveCall();
	
	// 문자 보내는 기능을 정의해 놓을 sendSMS 추상 메소드 만들기, 리턴타입 boolean
	public abstract boolean sendSMS();
	
	// 문자 받는 기능을 정의해 놓을 receiveSMS 추상 메소드 만들기, 리턴 타입 boolean
	public abstract boolean receiveSMS();
	
}

interface MP3 {
	// 음악 재생기능을 정의해놓을 play 추상 메소드 만들기, 리턴타입 void
	public abstract void play();
		
	// 음악 정지기능을 정의해놓을 stop추상 메소드 만들기, 리턴타입 void
	public abstract void stop();
}



interface MusicPhone extends MobilePhone, MP3 {
	// playMP3RingTone() 추상 메소드 만들기 , 리턴타입 void
	public abstract void playMP3RingTone();
}

//
class PDA {
	// 두개의 정수값을 매개변수로 받아 그 합을 int로 리턴하는 calculate 메소드 만들기
	public int calculate(int a, int b) {
		return a+b;
	}
}

// SmartPhone 클래스 만들기 (PDA 클래스 상속받고, MusicPhone 인터페이스 구현)
class SmartPhone extends PDA implements MusicPhone{
	// MP3인터페이스가 상속한 MusicPhone 인터페이스의 모든 추상 메소드 재구현 (오버라이딩)
	@Override
	public void play() {
		// play메소드에 재구현할 내용 -> "음악재생" 출력
		System.out.println(" 음악재생 ");
	}

	@Override
	public void stop() {
		// stop 메소드에 재구현할 내용 -> "재생중지" 출력
		System.out.println(" 재생중지 ");
	}
	
	
	
	// MobilePhone 클래스가 상속한 MusicPhone의 모든 추상 메소드를 재구현 (오버라이딩)
	@Override
	public boolean sendCall() {
		// sendCall 메소드에 재구현할 내용 -> "전화걸기"출력, true리턴
		System.out.println(" 전화걸기 ");
		return true;
	}

	@Override
	public boolean receiveCall() {
		// receiveCall 메소드에 재구현할 내용 -> "전화받기" 출력, true 리턴
		System.out.println(" 전화받기 ");
		return true;
	}

	@Override
	public boolean sendSMS() {
		// sendSMS 메소드에 재구현할 내용 -> "SMS보내기" 출력, true 리턴
		System.out.println(" SMS보내기 ");
		return true;
	}

	@Override
	public boolean receiveSMS() {
		// receiveSMS 메소드에 재구현할 내용 -> "SMS 받았다" 출력, true 리턴
		System.out.println(" SMS받았다 ");
		return true;
	}

	
	// MusicPhone의 모든 추상 메소드를 재구현 (오버라이딩)
	@Override
	public void playMP3RingTone() {
		// PlayMP3RingTone메소드에 재구현할 내용 -> 비워두자
		
	}
	

}
public class Test109 {

	public static void main(String[] args) {
		// SmartPhone 객체 생성, 참조변수 이름 p
		SmartPhone p = new SmartPhone();
		System.out.println("철수가 SmartPhone을 구입하였다.");
		System.out.print("영희에게 ");
		p.sendCall();
		System.out.print("철수는 영희가 지금 부재중... 이라는 ");
		p.receiveSMS();
		System.out.print("화가 난 철수는 최신음악을 들으려고");
		p.play();
		/*
		 	출력 결과
		 	철수가 SmartPhone을 구입하였다.
		 	영희에게 전화걸기
		 	철수는 영희가 지금 부재중... 이라는 SMS 받았다
		 	화가난 철수는 최신음악을 들으려고 음악재생!
		
		 */

	}

}
