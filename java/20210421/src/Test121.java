import java.sql.Timestamp;

// 주제 : String 과 StringBuffer 속도차이 비교

class Clock {
	// 작업할 클래스 이름(String 또는 StringBuffer)을 저장할 변수
	private String clockName;
	
	// 작업 시작 시간 저장할 변수
	private long startTime;
	
	// 작업 종료 시간 저장할 변수
	private long endTime;
	
	// 작업에 소요되는 시간
	private long leadTime;
	
	// 작업할 클래스 이름을 clockName 변수에 저장할 생성자
	public Clock(String name) {
		clockName = name;
	}
	
	// 작업 시작 시간을 startTIme변수에 초기화할 메소드
	public void clockStart() {
		// 작업시작시간 (컴퓨터의 현재 시간으로 구해서 저장)
		startTime = System.currentTimeMillis();
		new Timestamp(System.currentTimeMillis());
	}
	
	// 작업 소요시간을 leadTime 변수에 초기화할 메소드
	public void clockEnd() {
		// 컴퓨터 시계로부터 현재 작업종료 시간 반환 메소드
		endTime = System.currentTimeMillis();
		// 소요시간 = 작업시작시간 - 작업종료 시간
		leadTime = (endTime - startTime);
		
	}
	
	
	// 작업 후
	// 작업한 클래스명과 작업소요시간 정보를 출력해주는 기능의 메소드
	public void showInfo() {
		System.out.println(clockName + ":"+ leadTime);
	}
}

public class Test121 {

	public static void main(String[] args) {
		// 반복 수행할 횟수 100 지정
		final int maxCount = 100;
		
		// String 클래스를 위한 시계 객체 생성
		Clock clockString =  new Clock("String");
		
		// String 클래스의 작업 시간 초기화 하는 메소드 호출
		clockString.clockStart();
		
		String str = "play";
		for (int i=0; i<maxCount; i++) {
			str = str + "JAVA";
		}
		
		System.out.println(str);
		
		// String 작업소요 시간을 구할 메소드 호출
		clockString.clockEnd();
		
		// String 작업 후 정보 출력
		clockString.showInfo();
		
		
		// ======================================
		// StringBuffer 를 위한 시계 객체 생성
		Clock clocksb = new Clock("StringBuffer");
		
		// StringBuffer 작업시작 시간 구할 메소드 호출
		clocksb.clockStart();
		
		StringBuffer sb  = new StringBuffer("play");
		
		// 100번 반복 작업
		for(int i=0; i<maxCount; i++) {
			sb.append("JAVA");
		}
		
		System.out.println(sb);
		
		// StringBuffer 작업 소요 시간
		clocksb.clockEnd();
		
		clocksb.showInfo();
		
		
		
		
		// 결론
		// 변하지 않는 문자열을 저장할 때는 String 클래스에 대한 문자열 객체를 생성하여 저장
		// 변할 수 있는 문자열을 저장할 때는 StringBuffer 클래스에 대한 문자열 객체를 생성하여 저장
		
	}

}
