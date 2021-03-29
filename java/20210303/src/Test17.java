/*
	연산자 문제 4)
	아래의 코드의 문제점을 수정해서 [실행 결과]와 같은 결과를 얻으시오
	
	[실행결과]
	c = 30
	ch = c
	f =1.5
	l = 27000000000
	result = true
	
*/
public class Test17 {
	public static void main(String[] args) {
		byte a = 10;
		byte b = 20;
		byte c = (byte)(a + b); // 수정 후 주석 : 두 정수끼리 연산 하면 자동으로 int형으로 형변환 되기 때문에 byte로 강제 형변환 해주어야 한다.
		// -> a변수와 b변수는 byte타입이므로 이항 연산인 덧셈 연산을 하기전에 int 타입으로 자동 형변환 된다. int 10과 int 20을 덧셈연산하므로 결과는 int값이 된다
		// int값을 byte 변수에 담아야 하므로 형변환(캐스팅) 해줘야 한다.
		
	
		char ch = 'A';
		ch = (char)(ch + 2);	// 수정 후 주석 : 문자와 정수를 합치면 자동으로 int형으로 형변환 되기 때문에 char형으로 강제 형변환 해주어야 한다.
		// -> char 타입이 덧셈연산의 과정을 거치면서 int 타입으로 변환되므로 char타입의 변수 ch에 저장하기 위해서는 (char)로 형변환 해줘야 한다
		
		
		float f = 3 / 2f ; // 수정 후 주석 : 두 정수끼리의 연산 후 결과는 int형이다. 3/2하면 결과는 1이고, 그것을 실수형으로 만드는 형태기 때문에 x
							// 실수 끼리의 연산을 해주어야 한다. 
		// -> int와 int의 연산결과는 int이기 때문에 3/2의 결과는 1이 된다. 연산결과를 실수값으로 얻으려면,
		// 적어도 두 피연산자 중 한쪽이 실수타입(float&double)이어야 한다.
		
		
		long l = 3000l *3000l * 3000l; // 수정 후 주석 : 정수를 연산할 때 기본적으로 int형 정수로 판단하고 계산되기 때문에 어떤 자료형의 정수인지 알려주어야 한다. 
		// -> int*int*int의 결과는 int타입의 최대값인 약 2*10의 9제곱을 넘는 결과는 오버플로우가 발생하여 예상한 결과값과 다른값을 얻는다.
		// 피연산자 중 적어도 한 값은 long 타입이어야 최종결과를 long타입의 값으로 얻기 때문에 long타입의 접미사 L을 붙여서 long타입의 리터럴로 만들어야 함
		
		
		float f2 = 0.1f;
		double d = 0.1;	
		boolean result = ((float) d == f2);	// 두 실수형이 자료형이 다르기 때문에, 자료형을 통일시켜준다 
		// -> 비교 연산자도 이항 연산자 이므로 연산시 두 피연산자의 자료형을 맞추기 위해 형변환이 발생한다.
		// 그래서 double과 float의 연산은 double과 double의 연산으로 자동 형변환되는데,
		// 실수는 정수와 달리 근사값으로 표현하기 때문에 float을 double로 형변환 했을 때 오차가 발생할 수 있다.
		// 그래서 f->d로 형변환하기 보다는 d-> 유효자리수가 적은f로 형변환해서 비교하는것이 정확한 결과를 얻는다.
		
		
		System.out.println("c =" + c);
		System.out.println("ch = " + ch);
		System.out.println("f = " + f);
		System.out.println("l = " + l);
		System.out.println("result = " + result);
		
	
	}
}
