
public class Test38 {

	public static void main(String[] args) {
		/* 배열 연습1 */
		
		// 4바이트 크기의 정수값들(5개)을 저장할 배열 메모리 생성 후
		// 생성된 배열 메모리의 주소값을 저장할 score라는 이름의 변수 만들기
		int[] score = new int[5];
		
		
		// score변수에 저장된 배열의 각 인덱스 위치에 접근하여 점수를 각각 저장
		// 0 인덱스 위치 -> 95저장
		// 1 인덱스 위치 -> 70
		// 2 인덱스 위치 -> 80
		// 3 인덱스 위치 -> 75
		// 4 인덱스 위치 -> 100
		
		score[0] = 95;
		score[1] = 70;
		score[2] = 80;
		score[3] = 75;
		score[4] = 100;
		
		// for반복문을 이용하여 score 변수에 저장된 배열 메모리의 크기만큼 반복해서
		// 각각의 인덱스 위치에 저장된 데이터들을 얻어 출력하기
		for(int i=0; i<score.length; i++) {
			System.out.println((i+1)+"번 학생 score[" + i + "] = " + score[i]);
		}

	}

}
