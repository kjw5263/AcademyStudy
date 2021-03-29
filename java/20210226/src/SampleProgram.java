// 문제 10. 다음과 같은 간단한 자바 프로그램을 작성하였다.
// (1) 클래스를 저장하는 소스파일 이름은 무엇? SampleProgram.java

// (2) 명령창에서 이 자바 소스를 컴파일 하기 위한 명령은? javac SampleProgram.java
// (3) 이 프로그램은 오류를 가지고 있다. 오류를 찾아내서 수정하시오.넹
// (4) 오류를 수정하여 컴파일 한 후 명령창에서 실행하기 위한 명령은? java SampleProgram

public class SampleProgram {
	public static void main(String[] args) {
		int i;
		int j;
		i = 10;
		j = 20;
		System.out.println(i + j);
	}
}
