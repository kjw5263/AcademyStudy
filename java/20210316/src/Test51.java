
public class Test51 {
	// 메소드 이름 : hiEveryone
	// 매개변수 X, 리턴값X
	// 기능 : "출근 Start!" 출력
	public static void hiEveryone() {
		System.out.println("출근 Start!");
	}
	
	// 메소드 이름 : hiEveryoneEnd
	// 매개변수 X, 리턴값X
	// 기능 : "동료와 마주쳤습니다." 출력
	public static void hiEveryoneEnd() {
		System.out.println("동료와 마주쳤습니다.");
	}
	
	// 메소드 이름 : hiEveryone
	// 매개변수 o -> 정수형(4) age
	// 리턴값 X
	// 기능 : "좋은 아침입니다" "제 나이는 13세 입니다" "잘부탁드립니다" 출력
	public static void hiEveryone(int a) {
		System.out.println("좋은 아침입니다.");
		System.out.println("제 나이는 "+ a + "세 입니다.");
		System.out.println("잘부탁드립니다.");
	}
	
	
	// 메소드 이름 : byEveryone
	// 매개변수 X
	// "오늘 수고 많으셨습니다."
	// 리턴할 값 O -> "다음에 뵙겠습니다"
	public static String byEveryone() {
		System.out.println("오늘 수고 많으셨습니다.");
		
		return "다음에 뵙겠습니다.";
	}
	
	public static void main(String[] args) {
		hiEveryone();
		hiEveryoneEnd();
		hiEveryone(24);
		System.out.println(byEveryone());
		
		/*
		 	출력 결과
		 	출근 Start!
		 	동료와 마주쳤습니다.
		 	좋은 아침입니다.
		 	제 나이는 13세 입니다.
		 	잘 부탁드립니다.
		 	오늘 수고 많으셨습니다.
		 	다음에 뵙겠습니다.
		*/
		
		
	}

}
