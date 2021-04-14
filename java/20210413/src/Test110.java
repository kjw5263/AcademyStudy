/* 인터페이스를 통한 다중 상속 보기 */
/*
	TV 클래스와 VCR 클래스가 있다. 
	TV 클래스와 VCR 클래스를 다중상속하여
	TVCR 클래스를 만들고 싶을 때...
	자바의 클래스는 다중 상속을 허용하지 않는다.

*/

class TV {
	protected boolean power;
	protected int channel;
	protected int volume;
	
	public void power() {
		power = !power;
	}
	
	public void channelUp() {
		channel++;
	}
	
	public void channelDown() {
		channel--;
	}
	
	public void volumeUp() {
		volume++;
	}
	
	public void volumeDown() {
		volume--;
	}
	
}


class VCR {
	protected int counter;
	
	public void play() {
		System.out.println("Tape를 재생한다.");
	}
	
	public void stop() {
		System.out.println("재생을 멈춘다.");
	}
	
	public void reset() {
		counter = 0;
	}
	
	public int getCounter() {
		return counter;
	}
	
	public void setCounter(int c) {
		counter = c;
	}
	
}


// TVCR 새로운 클래스를 만들 때, TV클래스와 VCR 클래스를 모두 상속받지 못한다.
// 두개의 클래스 중에 하나만 상속 가능하다. (단일 상속만 허용!)
// TV 클래스 한쪽만 부모 클래스로 선택하여 상속받고
class TVCR extends TV implements IVCR{
	// 나머지 한쪽 (VCR 클래스)은 TVCR 클래스 내부에 포함시켜서
	// 내부적으로 객체를 생성해서 사용하도록 한다.
	VCR vcr = new VCR();

	// IVCR 인터페이스 내부의 추상메소드 오버라이딩
	@Override
	public void play() {
		// 내부적으로 객체를 생성해서 메소드 호출
		// 코드를 작성하는 대신 VCR 인스턴스의 인스턴스 메소드를 호출하면된다. 
		vcr.play();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		vcr.stop();
	}

	@Override
	public void reset() {
		vcr.reset();
		
	}

	@Override
	public int getCounter() {
		
		return vcr.getCounter();
	}

	@Override
	public void setCounter(int c) {
		vcr.setCounter(c);
		
	}

}

	
// 다중상속 해결방법
// 두 부모 클래스 중에서 비중이 높은 쪽을 선택하고
// 어느 한쪽을 필요한 부분을 추출해서 인터페이스를 만든 다음 재구현(오버라이딩)시키도록 한다.
// 다른 한쪽은 클래스 내부에 멤버로 포함시키는 방식으로 처리.


// VCR 클래스에 정의된 메소드와 일치하는 추상 메소드를 갖는 인터페이스를 작성한다.
interface IVCR {
	public void play();
	
	public void stop();
	
	public void reset();
	
	public int getCounter();
	
	public void setCounter(int c);
	
}



public class Test110 {

	public static void main(String[] args) {
		TVCR tvcr = new TVCR();
		
		// Tape을 재생한다. < 출력
		tvcr.play();
		tvcr.setCounter(3);
		System.out.println(tvcr.getCounter());
		tvcr.reset();
		System.out.println(tvcr.getCounter());
		tvcr.stop();
		
		
		// 결론 
		// IVCR이라는 인터페이스를 작성하기 위해서는 새로 추상메소드를 작성해야하는 부담이잇지만
		// 이처럼 VCR클래스의 객체를 생성해서 사용하면 손쉽게 다중 상속을 구현할 수 있다.
		// 그러나, 다형적 특성을 이용할 수 있다는 장점을 지닌 인터페이스를 이용하여
		// 클래스와 다중상속을 해결할 수 있다.
		
	}

}
