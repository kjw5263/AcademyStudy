/*
 	가변 배열
 	- 자바에서는 2차원 배열을 생성할 때 열의 길이를 명시하지 않음으로써,
 		행마다 다른 길이의 배열을 요소로 저장할 수 있다.
 		이렇게 행마다 다른 길이의 배열을 저장할 수 있는 배열을 가변 배열   	
   
 */
public class Test45 {

	public static void main(String[] args) {
		int[][] arr = new int[3][];
		
		
		arr[0] = new int[2];	// ㅁㅁ
		arr[1] = new int[4];	// ㅁㅁㅁㅁ
		arr[2] = new int[1];	// ㅁ
		
		// 위 예제처럼, 배열을 생성할 때 두번 째 첨자를 생략하면 가변 배열을 만들 수 있따.
		
		
		/*
		 	가변 배열도 { }블록을 사용하여 배열 선언과 동시에 값을 저장할 수 있다. */
		int[][] arr2 = { {10, 20},
	 				 {10,20,30, 40},
	 				 {10}
					};
		
		
		for(int i=0; i<arr2.length; i++) {	// 행 크기만큼 반복
			for(int j=0; j<arr2[i].length; j++) {		// 행 위치에 대한 열 크기만큼 반복
				System.out.print(arr2[i][j]+ " ");
			}
			System.out.println();
		}
		
		
		
	}

}
