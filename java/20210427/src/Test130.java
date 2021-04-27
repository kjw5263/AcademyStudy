
public class Test130 {

	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		
		String name = null;
		
		try {
			int num = 3/0;
			System.out.println("문자열의 길이 : " + name.length());
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("모든 예외처리 가능");
		} finally {
			System.out.println("프로그램 정상 종료");
		}

		
		
		/*
			[예외 처리 순서 과정]
			1. try 구문으로 진입
			2. try 구문 내부에서 예외가 발생하면
			3. catch 블럭을 순차적으로 살펴보면서 일치하는 예외가 있는지 조사하여
				해당 catch블럭으로 진입한다.
			4. 해당 catch블럭 내부의 구문을 실행하여 예외 메시지를 출력하고 예외처리를 한다.
			5. finally 블럭은 예외 발생 유무에 상관없이 무조건 한번은 실행된다.
			
			
		*/
	}

}
