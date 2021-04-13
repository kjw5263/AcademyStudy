
// 추상 클래스 연습문제 
// 추상클래스 Calculator을 상속받은 GoodCalc 클래스를 구현하라 

abstract class Calculator {
	// 두 정수의 합을 구하여 리턴하는 기능을 나하내는 추상메소드
	public abstract int add(int a, int b);
	// 두 정수의 차를 구하여 리턴하는 기능을 나타내는 추상 메소드
	public abstract int subtract(int a, int b);
	// 배열에 저장된 정수의 평균을 구해 실수로 리턴하는 기능을 나타내는 추상메소드
	public abstract double average(int[] a);
}

/*
	Calculator 추상클래스는 add, subtract, average메소드를 추상메소드로 선언하였을 뿐
	어떻게 구현할지는 상관하지 않는다. 어떤 인자가 전달되고 어떤 타입의 값이 리턴되었는지만 지정할 뿐이다
	구현운 자식 클래스의 몫이다. GoodCalc 클래스를 구현하라	
*/
class GoodCalc extends Calculator {

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public int subtract(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public double average(int[] a) {
		// 매개변수로 전달받는 a배열에 저장된 정수들의 합을 저장할 누적변수 sum선언
		double sum = 0;
		
		// 매개변수로 전달받는 a배열에 저장된 정수들을 차례로 얻어와 sum변수에 누적
		for(int i=0; i<a.length; i++) {
			sum += a[i];
		}
		
		// sum 변수에 저장된 총 점수의 평균을 구해 리턴
		return sum/a.length;
	}
	
}
public class Test105 {

	public static void main(String[] args) {
		// 업캐스팅을 이용하여 자식객체 생성
		Calculator calculator = new GoodCalc();
		
		// 정수 2와 3의 합계를 구하기 위해 add메소드 호출
		System.out.println(calculator.add(2, 3));
		
		
		// new int[](2,3,4} 배열에 저장된 정수의 평균값을 구하기 위해 average 메소드 호출
		System.out.println(calculator.average(new int[] {2,3,4}));

	}



}
