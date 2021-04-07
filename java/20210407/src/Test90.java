
// 연습 : super 키워드를 이용하여 부모클래스의 멤버 및 생성자를 호출하는 연습

class Employee {
	String name;	// 이름
	int salary;		// 급여
	
	// 기본 생성자 -> 아무런 일도 하지 않음, 비워두자!
	public Employee() {
		
	}
	
	// 사원의 이름과 급여를 매개변수로 전달 받아 초기화 하는 생성자
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	// 사원의 이름과 급여를 하나의 문자열로 만들어 반환할 getEmployee 메소드
	public String getEmployee() {
		return name + ", " + salary;
	}
 
	
	
}

// Employee 클래스를 상속받는 새로운 자식 클래스 Manager 생성 
class Manager extends Employee {
	//부서명을 문자열로 저장시킬 depart변수 선언 
	String depart;
	
	// name, salary, depart변수의 데이터들을 초기화 하는 생성자
	// -> Manager객체 내부에 있는 name 인스턴스 변수와 salary인스턴스는 상속받아 사용하므로
	// Employee객체의 생성자를 다시 호출해 (super(name, salary) ) 넘겨주어
	// Employee 객체 생성자에서 직접 변수의 값을 초기화 시켜줘야 함
	public Manager(String name, int salary, String depart) {
		//this(name, salary); --> this()는 같은 클래스 내부의 다른 생성자를 호출할 때 사용한다!!!
		super(name, salary);
		this.depart = depart;
		//super.name = name;
		//super.salary = salary;
		
	}
	// name, salary, depart변수의 데이터들을 하나의 문자열로 만들어서 반환할 getManager 메소드
	public String getManager() {
		return name + ", " + salary + ", " + depart;
	}
	
	
}
public class Test90 {

	public static void main(String[] args) {
		// Employee 객체 생성 시 생성자를 호출해 "홍길동", 2000값 전달
		// 참조변수이름 emp
		Employee emp = new Employee();
		emp.name = "홍길동";
		emp.salary = 2000;
		System.out.println(emp.getEmployee());
		
		// Manager객체 생성시 생성자 호출! "이순신", 4000, "개발"을 전달하여 변수 초기화
		// 참조변수이름 man
		Manager man = new Manager("이순신", 4000, "개발");
		System.out.println(man.getManager());
		System.out.println(man.getEmployee());
		/* 결과
		 	홍길동, 2000
		 	이순신, 4000, 개발
		 */

	}

}
