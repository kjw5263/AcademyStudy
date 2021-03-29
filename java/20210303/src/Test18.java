/*
	연산자 문제5)
	다음은 대문자를 소문자로 변경하는 코드인데, char ch 변수에 저장된 문자가 대문자인 경우에만 소문자로 변경한다. 
	문자코드는 소문자가 대문자보다 32만큼 더 크다.
	예를 들어 'A'의 아스키코드값은 65이고, 'a'의 코드는 97이다.
	
	(1)과 (2)에 알맞은 코드를 넣으시오.
	
	[실행결과]
	ch : A
	ch to lowerCase : a
*/
public class Test18 {

	public static void main(String[] args) {
		char ch = 'A';
		char lowerCase = ( ch>='A' && ch<='Z' ) ? ( (char)(ch+32) ) : ch;
		/*
			-> 대문자인 경우에만 문자코드의 값을 32만큼 증가시키면 소문자가 된다.
			ch변수에 저장된 문자가 대문자인지를 확인하기 위한 조건식 ch>='A' && ch<='Z'
			ch변수에 저장된 대문자 'A'의 소문자 'a'를 구하기 위해서는
			'A' + 32 증가 시켜야한다. 
			65 + 32 = 97 <- int 값을 char형 'a'로 강제 형변환 해야한다.
		*/
		System.out.println("ch : " + ch);
		System.out.println("ch to lowerCase : " + lowerCase);

	}

}
