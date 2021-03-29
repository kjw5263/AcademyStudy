/* 2차원 배열 사용하기 */
public class Test46 {

	public static void main(String[] args) {
		// 3행 동적열을 생성할 2차원 배열 생성 (int 데이터 저장 위해)
		int[][] num = new int[3][];
		
		// 각 행 배열 위치에 해당하는 열 배열 메모리 생성하여 저장
		num[0] = new int[3];	// 0인덱스 위치의 행자리에 3개의 열 생성하여 추가
		num[1] = new int[2];	// 1인덱스 위치의 행자리에 2개의 열 생성하여 추가
		num[2] = new int[1];	// 2인덱스 위치의 행자리에 1개의 열 생성하여 추가
		
		
		
		// 2차원 배열에 값 저장(넣기)
		num[0][0] = 1;		// ㅁㅁㅁ
		num[0][1] = 2;		// ㅁㅁ
		num[0][2] = 3;		// ㅁ
		num[1][0] = 4;		//이와 같은 형태
		num[1][1] = 5;
		num[2][0] = 6;
		
		
		// 중첩 for문을 이용하여 2차원 배열 메모리에 저장된 데이터를 반복해서 얻어 출력
		// 바깥쪽 for문 - 행 크기만큼 반복
		for(int i =0; i<num.length; i++) {
			// 안쪽 for문 - 특정 인덱스 위치에 있는 행에 대한 열의 개수만큼 반복
			for(int j=0; j<num[i].length; j++) {
				System.out.println("num["+i+"]["+j+"] = "+ num[i][j]);
			}
		}
			
	}

}
