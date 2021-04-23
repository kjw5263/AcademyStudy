/*
	boolean 자료형 데이터를 저장하기 위한 (객체로 감싸기 위한)
	wrapper 역할을 하는 booleanWrapper 클래스 직접 만들어보기 연습
	
	
*/

// BooleanWrapper 클래스 만들기
class BooleanWrapper extends Object {
	 // 변수 선언 -> 데이터 은닉, private, 변수이름 power, 타입 boolean
	  private boolean power;
	 // 생성자 선언 -> public, 매개변수 boolean power, boolean 변수에 매개변수 값 저장
	  public BooleanWrapper(boolean power) {
		  this.power = power;
	  }

  
  
 // Obejct 클래스의 toString() 메소드 오버라이딩
 // -> 구현내용 : power 변수의 값을 문자열로 만들어 리턴
	  @Override
	  public String toString() {
	  	return power+"";
	  }
}
 

public class Test123 {
	
	// ShowData 메소드 만들기 -> public, static, void, 매개변수: Object obj
	//						-> 매개변수 obj로 전달받은 객체의 toString() 메소드 호출 후 반환받아 출력
	public static void ShowData(Object obj) {
		System.out.println(obj.toString());
	}
	
	public static void main(String[] args) {
		// showData 호출 시 true 전달하여 "true" 출력되게 하기
		BooleanWrapper bw1 = new BooleanWrapper(true);
		Test123.ShowData(bw1);
		
		// showData 호출시 false 전달하여 "false" 출력되게 하기
		Test123.ShowData(new BooleanWrapper(false));
		
	}

}
