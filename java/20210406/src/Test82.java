
/*
	주제 : 상속 관계에서의 접근 제어자 알아보기
		-> 부모 클래스와 자식 클래스가 같은 패키지에 있는 경우의 접근
		
*/

class AA {
	// default 접근 제어자 이용
	// - 부모 클래스의 멤버가 default이면 자식 클래스이든 아니든
	// 같은 패키지에 있는 클래스이면 모두 접근 가능함
	int i;
	
	// protected접근 제어자 이용
	// - 같은 패키지에 속한 다른 클래스에서 접근 허용
	// - 같은 패키지이든 다른 패키지이든 상속받는 자식 클래스에서 접근 허용
	protected int pro;
	
	// public 접근 제어자 이용
	// - 다른 패키지 또는 같은 패키지의 모든 클래스에서 접근 허용
	public static int pub;
	
	// private 접근 제어자 이용
	// 같은 클래스 내부에서만 이 변수에 접근 허용
	// 인스턴스 변수 정의시 사용
	private int pri;
	
	// public 접근 제어자를 이용해 getter, setter 역할을 하는 메소드 만들기
	public int getPri() {
		return pri;
	}
	public void setPri(int pri) {
		this.pri = pri;
	}
}



// AA 클래스의 멤버를 상속받는 BB 클래스 만들기 
class BB extends AA {
	// 우리눈엔 안보이지만 모든 AA의 멤버들은 다 상속이 되어있다!
	
	
	void set() {
		i = 10;
		pro = 20;
		pub = 30;
		// pri = 40;
		setPri(40);
	}
	public String get() {
		return i + ", " + pro + ", " + pub + ", " + getPri();
	}
}


public class Test82 {

	public static void main(String[] args) {
		BB bb = new BB();
		bb.set();
		System.out.println(bb.get());
	}

}
