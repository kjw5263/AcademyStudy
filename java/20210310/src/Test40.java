
public class Test40 {

	public static void main(String[] args) {
		/* 배열 연습2 */
		// 5명의 학생의 점수를 저장시킬 배열 생성 한 후 총 합, 평균 구하기
		// 4바이트 크기의 정수 데이터들을 저장시킬 배열 생성한 후
		// 배열 메모리의 주소를 담을 score 변수 만들기\
		// 단 배열에 저장할 값 95, 70, 80, 75, 100
		int[] score = {95, 70, 80, 75, 100}; 
		
		
		// 점수의 총합을 저장시킬 total이름의 변수 만들기, 0 저장
		int total = 0;
		
		// 평균을 구해 8바이트 크기의 실수값 저장시킬 ave변수 선언
		double ave = 0;
		
		// for 반복문을 이용하여 5명의 학생의 총합을 반복해서 total 변수에 누적
		for(int i=0; i<score.length; i++) {
			total += score[i];
		}
		
		// 평균을 구하여 ave 변수에 저장
		ave = total / score.length ;
		
		// 총합 출력 Total = 420
		System.out.println("Total = " + total);
		// 평균 출력 ave = 84.0
		System.out.println("ave = " + ave);
		
		
		
		System.out.println("===============================");
		
		// 예제. 5개의 실수값 중에서 최대값 구하기
		// 8바이트 크기의 실수값들 9.5 7.0 13.6 7.5 1.0을 저장할 배열 메모리 생성 후
		// 생성한 배열 메모리의 주소값을 주소값을 data변수에 저장 
		double[] data = {9.5, 7.0, 13.6, 7.5, 1.0};
		// 5개의 숫자 중 최대값을 저장시킬 max변수 선언(8바이트 크기의 실수값을 저장할 변수 선언)
		double max;
		
		// max변수에 data배열의 0번째 인덱스 위치에 있는 데이터를 꺼내어 최대값으로 저장
		max = data[0];
		
		// for문을 이용하여
		// data 배열의 1인덱스 위치의 값부터 ~4인덱스 위치의 값까지 꺼내어 
		// max변수에 저장된 값과 비교한다.
			// if문을 이용하여
				// data배열의 인덱스 위치에 저장된 값이 max변수에 저장된 값보다 크다면
					// 그 값을 최대한으로 정하기 위해 max변수에 저장
		
		for(int i=1; i<data.length; i++) {
			if(data[i] > max) {
				max = data[i];
			}
		}
		
		
		// max 변수에 저장된 5개의 숫자중 최대값 출력 
		System.out.println("max = " + max);
		
		
	}

}
