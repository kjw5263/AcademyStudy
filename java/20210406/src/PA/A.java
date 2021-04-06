package PA;

// PA 패키지에 속한 A 클래스
public class A {

	int i;	// default
	protected int pro;
	private int pri;
	public int pub;
	
	public void print() {
		System.out.print("i = " + i + ", ");
		System.out.print("pro= " + pro + ", ");
		System.out.print("pri = " + pri + ", ");
		System.out.println("pub = " + pub + "입니다.");
		System.out.println(" 결론 = 서로 다른 패키지에 있는 경우 접근 값 출력");
	}
}
