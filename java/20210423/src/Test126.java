
// 박싱, 언박싱 연습하기
public class Test126 {

	public static void main(String[] args) {
		/// Integer 클래스 대한 객체를 생성하여 정수 10 박싱하기 (저장하기)
		Integer i = new Integer(10);
		// 참조변수 이름 i
		
		// Double클래스에 대한 객체를 생성하여 실수 3.14 박싱하기(저장하기)
		// 참조변수 이름 d
		Double d = new Double(3.14);
		
		// 출력
		// 10
		// 3.14
		System.out.println(i); // i.toString() 과 같아서 문자열임
		
		// 위의 Integer 객체에 저장되어 있는 정수값 10 언박싱 하기 (얻어오기)
		// 얻어와서 int i2변수에 저장
		int i2 = i.intValue();
		System.out.println(i2);
		
		// 위의 double 객체에 저장되어이 있는 실수값 3.14언박싱 하기 (얻어오기)
		// 얻어온 값에 1.2를 더하여 새로운 Double 객체의 인스턴스 변수에 박싱하기(저장하기)
		double d2 = d.doubleValue();
		d = new Double(d2+1.2);
		//System.out.println(d2);
		
		// d 참조변수에 저장된 Double 객체의 정보를 toString() 메소드를 호출하여 출력
		System.out.println(d.toString());
		
		
		
	}

}
