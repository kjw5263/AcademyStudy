/*
	자바에서 발생하는 예외 종류들
	
*/
public class Test129 {

	public static void main(String[] args) {
		System.out.println("시작");
		
		
		try {
			int su1 = 10;
			int su2 = 0;
			
			System.out.println(su1 / su2);
			System.out.println("예외 발생 안함");
		} catch (ArithmeticException e) {
			System.out.println("끝");
			System.out.println(e.getMessage());
		}
		System.out.println("끝");
	}

}
