/*
	1-4. switch문
		- switch문은 if else문과 마찬가지로 주어진 조건값의 결과에 따라 프로그램이 다른 명령을 수행하도록 하는 조건문
		-형식
			switch(조건값) {
				
				case 값1 :
					조건값이 1일 때 실행하고자 하는 명령문;
					break;
				
				case 값2 :
					조건값이 2일 때 실행하고자 하는 명령문;
					break;
					
				default:
					조건값이 어떠한 case절에도 해당하지 않을 때 실행하고자 하는 명령문;
			}
	
	
*/


public class Test24 {

	public static void main(String[] args) {
		String myDream = "DBA";
		
		switch (myDream) {	//myDream변수에 저장되어 있는 값이 
			case "Programmer" :	// programmer와 같냐
				System.out.println("나의 꿈이 아닙니다.");
				break;		// break문을 만나면 그다음 case 유형의 값과 비교하지 않고 switch문 완전히 빠져나감
	
			case "Doctor" : 
				System.out.println("나의 꿈이 아닙니다.");
				break;
				
			case "DBA" :	// "DBA"와 같은가
				System.out.println("저는 데이터베이스 관리자가 되고싶어요.");
				break;
				
			default:		// 조건 값이 위에 나열된 어떠한 case절의 값에도 해당하지 않을때만 실행
				System.out.println("저는 꿈이 없습니다.");
				break;
		}
		
	}

}
