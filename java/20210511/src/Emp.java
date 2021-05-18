import java.io.Serializable;

/*
	Serializable 은 객체 직렬화를 위한 인터페이스
	메소드 구현이 필요없는 인터페이스 구현을 내부적으로 자바가 해줌
	
*/

// 사원 객체를 직렬화
// 사원 클래스

public class Emp implements Serializable {
	private int no;			// 사번
	private String name;	// 이름
	private String job;		// 직무
	private int dept;		// 부서번호
	private double point;	// 인사고과 점수
	
	

	public Emp(int no, String name, String job, int dept, double point) {
		this.no = no;
		this.name = name;
		this.job = job;
		this.dept = dept;
		this.point = point;
	}

	// 사원번호, 이름, 직무, 부서번호, 인사고과점수 모두 하나의 문자열로 만들어서 반환할 toString()
	// alt + shift + s + v
	@Override
	public String toString() {
		return "Emp [no=" + no + ", name=" + name + ", job=" + job + ", dept=" + dept + ", point=" + point + "]";
	}

	public static void main(String[] args) {
		// 사번


	}

	

}
