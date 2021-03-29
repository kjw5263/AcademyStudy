/*
	4. 비교연산자
		- 피연산자 사이의 상대적인 크기를 판단하는 연산자
		- 왼쪽의 피연산자와 오른쪽의 피연산자를 비교하여 어느 쪽이 큰지, 작은지 또는 같은지를 판단하는 연산자
		- 비교연산자는 모두 두개의 피연산자를 가지는 이항 연산자
		- 피연산자들의 결합 방향은 왼쪽에서 오른쪽
	
	비교 연산자의 종류
		
 */


public class Test10 {

	public static void main(String[] args) {
		System.out.println(10 == 100);
		System.out.println(10 != 100);
		System.out.println(10 < 100);
		System.out.println(10 <= 100);
		System.out.println(10 > 100);
		System.out.println(10 >= 100);
		
		System.out.println("------------------");
		
		// 예제 주제 : 소문자 b와 대문자B 비교하기
		char ch1 = 'b';
		char ch2 = 'B';
		System.out.println("== 연산자에 의한 결과"+ (ch1 == ch2));
		System.out.println("!= 연산자에 의한 결과" + (ch1 != ch2));
		System.out.println(ch1 > ch2);
		System.out.println(ch1 >= ch2);
		System.out.println(ch1 < ch2);
		System.out.println(ch1 <= ch2);
		
		
		
		System.out.println('b' == 'B');
		System.out.println('b' == 'B');
	}

}
