
import java.util.Scanner;
public class Test50 {
	/* 두 개의 데이터를 매개변수로 전달 받아서 사칙연산을 수행하는 메소드들 만들기 */
	// 1. 메소드 이름 : addPrint
	//    매개변수 : long a, long b;
	//	  기능 : 매개변수로 전달 받은 두 데이터의 합(연산결과)을 바로 출력
	public static void addPrint(long a, long b) {
		System.out.println( a + b );
	}
	
	// 2. 메소드 이름 : add
	//	  매개변수 : long a, long b
	//    기능 : 매개변수로 전달받은 두 데이터의 합의 연산결과를 메소드를 호출한 장소로 리턴
	public static long add(long a, long b) {
		return a+b;
	}
	
	// 3. 메소드 이름 : subPrint
	//	  매개변수 : long a, long b
	// 	  기능 : 매개변수로 전달받은 두 데이터의 차의 연산결과(long)를 바로 출력
	public static void subPrint(long a, long b) {
		System.out.println(a-b);
	}
	
	// 4. 메소드 이름 :sub
	//	  매개변수 : long a, long b
	//	  매개변수로 전달 받은 두 데이터의 차의 연산결과(long)를 메소드를 호출한 장소로 리턴
	public static long sub(long a, long b) {
		return a - b;
	}
	
	// 5. 메소드 이름 : subPrint
	//	  매개변수 : long a, long b
	// 	  기능 : 매개변수로 전달받은 두 데이터의 차의 연산결과(long)를 바로 출력
	public static void mulPrint(long a, long b) {
		System.out.println(a*b);
	}
	
	// 6. 메소드 이름 :sub
	//	  매개변수 : long a, long b
	//	  매개변수로 전달 받은 두 데이터의 차의 연산결과(long)를 메소드를 호출한 장소로 리턴
	public static long mul(long a, long b) {
		return a * b;
	}
	
	
	// 7. 메소드 이름 : divPrint
	//	  매개변수 : long a, long b
	// 	  기능 : 매개변수로 전달받은 두 데이터의 차의 연산결과(long)를 바로 출력
	public static void divPrint(long a, long b) {
		System.out.println(a/b);
	}
	
	// 8. 메소드 이름 : div
	//	  매개변수 : long a, long b
	//	  매개변수로 전달 받은 두 데이터의 차의 연산결과(long)를 메소드를 호출한 장소로 리턴
	public static long div(long a, long b) {
		return a / b;
	}
	
	
	
	// ==================================================
	public static void main(String args[]) {
		// add 메소드 호출 시, long 데이터로 6과 3을 순서대로 전달하여
		// add 메소드 내부의 연산 결과를 반환 받아 출력
		long result = add(6, 3);
		System.out.println(result);
		
		
		 Scanner sc = new Scanner(System.in);
		 int[] arr = new int[5]; 
		 int a = sc.nextInt();
		 for(int i=0; i<5; i++) {
			 int mod = a%10;
			 arr[i] = mod;
			 a /= 10;
		 }
		 
		 for(int i=4; i>=0; i--) {
			 int rst =  (int)(arr[i] * Math.pow(10, i));
			 System.out.println("[" + rst + "]");
		 }
		
		// addPrint메소드 호출 시, long 데이터로 6과 3을 순서대로 전달 하여
		// addPrint메소드 내부의 연산 결과를 addPrint메소드 내부에서 바로 출력 =
		//addPrint(6, 3);
	}

}
