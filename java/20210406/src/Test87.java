// 조합 4가지 중에서..
// 조합 3번. 자식 클래스 내부에 매개변수가 존재하는 생성자는,
// 			부모 클래스 내부의 기본 생성자와 짝을 이룸

class F {	// 부모 클래스 역할
	// 기본 생성자
	public F() {
		System.out.println("기본생성자 F");
	}
	
	// 매개변수 x값을 전달받아 사용하는 생성자
	public F(int x) {
		System.out.println("매개변수 x가 존재하는 생성자 F");
	}
	
	
}


// 자식 클래스
class G extends F{
	// 기본 생성자
	public G() {
		System.out.println("기본생성자 G");
	}
	
	// 매개변수 x값을 전달받아 사용하는 생성자
	public G(int x) {
		System.out.println("매개변수 x가 존재하는 생성자 G");
	}
}



public class Test87 {
	public static void main(String[] args) {
		G g = new G(5);
	}
}
