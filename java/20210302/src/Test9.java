/*
 	3. 증감 연산자 : 피연산자를 1씩 증가 혹은 감소 시킬 때 사용하는 연산자
 		- 이 연산자는 피연산자가 단 하나뿐인 단항 연산자
 		- 증감연산자의 종류 
 			x++
 			++x
 			x--
 			--x
 		
 */
public class Test9 {
	public static void main(String[] args) {
		/*
		 * int x = 3;
		 * 
		 * // x변수에 저장된 3을 1 증가시킨 후에, x변수의 값을 사용하게 된다. ++x; System.out.println(x);
		 * 
		 * 
		 * System.out.println(x--); // 변수x에 저장된 4를 먼저 출력 후, 1이 감소됨
		 * System.out.println(x); // 1 감소된 x 값을 출력
		 * 
		 * int y = 5; int z = ++y; // ++ 증가 연산자를 변수 y에 앞에 붙이면, y값은 6을 z변수에 대입하여 저장
		 * System.out.println(y + "," + z);
		 * 
		 * int x2 = 5; int y2 = x2++; // ++ 증가 연산자를 변수x2 뒤에 붙이면, x2에 저장된 5값을 y2변수에 먼저
		 * 대입하여 저장 후, x2 변수의 값을 1증가시켜 6이 된다 System.out.println(y2);
		 * System.out.println(x2);
		 */
		
		
		int x = 10;
		int y = x-- + 5 + --x;
		System.out.println(x);
		System.out.println(y);
		
		// 1. 첫번째 감소연산자 - 피연산자의 뒤쪽에 위치하므로, 덧셈 연산이 먼저 수행됨
		// 2. 덧셈 연산이 수행된 후에 감소연산이 수행됨 ( x값 : 9 )
		// 3. 두번째 감소연산자 - 피연산자의 앞쪽에 위치하므로 덧셈 연산보다 먼저 수행됨 (x값 : 8)
		// 4. 감소연산이 수행된 후에 덧셈 연산이 수행됨
		// 5. y변수에 결과값의 대입 연산이 수행됩니다.
		
	}
}
