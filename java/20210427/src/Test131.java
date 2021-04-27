
// try-catch 구문으로 예외처리 하기

class MyDate {
	int year = 2006;
	int month = 4;
	int day = 1;
	
	
}



public class Test131 {

	public static void main(String[] args) {
		MyDate date = null;
		
		try {
			// NulllPointerException 예외 발생
			// -> null 이 저장된 참조변수 d에 접근해서 사용하려고 할 때 발생하는 예외
			System.out.println( date.year + "/" + date.month +"/" + date.day);
		} catch (Exception e) {
			// 어떤 예외가 발생했는지 예외 메시지 출력
			System.out.println("예외발생 메시지 >>> " + e.getMessage());
			date = new MyDate();
			
			//e.printStackTrace();
		}
		
		System.out.println( date.year + "/" + date.month +"/" + date.day);
		System.out.println("==================================================");
		
		
		// try -catch구문으로 예외 처리 하기
		// ArrayIndexOutOdBoundsException 
		int num[] = {1,2,3};
		
		try {
			num[4] = 4;
		} catch(Exception e) {
			System.out.println("예외 메시지 >>> " + e.toString());
			System.out.println("예외 메시지 >>> " + e.getMessage());
		}
		
	}

}
