
// 조합 4가지중에
// 4번 조합. 자식 클래스의 생성자에서 super() 키워드를 이용해서 부모클래스의 생성자를
//			명시적으로 선택하여 호출하여 조합함

class H {	// 부모 클래스
	// 기본 클래스
	public H() {
		System.out.println("기본 생성자 H");
	}
	
	// 매개변수 x로 값을 전달 받을 생성자
	public H(int x) {
		System.out.println("매개변수 x가 존재하는 생성자 H");
	}
	
}
class I extends H{
	public I() {
		System.out.println("기본 생성자 I");
	}
	
	public I(int x) {
		super(x);
		System.out.println("매개변수 x가 존재하는 생성자 I");
	}
}
public class Test88 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		I i = new I(10);
		
		//1. I(int x) 생성자가 호출됨
		//2. I(int x) 생성자 내부에서 super(x); 부모 생성자를 호출하는 구문을 작성해놓는다.
		//3. 부모 클래서 H내부의 두번째 생성자인 H(int x)를 강제로 호출함
		//4. 이 때 부모 클래스 H의 생성자의 매개변수 X에는 5가 전달됨
		
		/*
			super() 메소드
			- this() 메소드가 같은 클래스의 다른 생성자를 호출할 때 사용된다면
			super() 메소드는 부모 클래스의 생성자를 강제로 호출할 때 사용된다.
			
			- 자식 클래스의 인스턴스를 생성하면, 해당 인스턴스에는 자식클래스의 고유 멤버뿐만아니라
				부모 클래스의 모든 멤버까지도 포함되어 있다.
				따라서 부모 클래스의 멤버를 초기화하기 위해서는, 자식 클래스의 생성자에서 부모 클래스의
				생성자까지 호출해야 한다.
				이러한 부모 클래스의 생성자 호출은, 모든 클래스의 부모 클래스인 Object 클래스의
				생성자까지 계속 거슬러 올라가서 수행이 된다.
			- 따라서 컴파일러는 부모 클래스의 생성자를 명시적으로 호출하지 않는 
				모든 자식 클래스의 생성자 첫 줄에 자동으로 다음과 같은 명령문을 추가하여
				부모 클래스의 멤버를 초기화할 수 있도록 해준다.
				super();
				
			
		 */
	}

}
