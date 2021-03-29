
public class Test41 {

	public static void main(String[] args) {
		// 방법2. 해당 배열의 내용을 직접 초기화 해서 배열 만드는 방법
		
		// 질문 : 방법2를 이용해 배열을 선언 후 배열생성 후 초기화를 따로 작성할 수 있는가? 
		int[] score;
		// score = {50, 100, 80, 90, 30}; // 배열 생성 후 초기화를 따로 할 수 없다.
		score = new int[] {50, 100, 80, 90, 30};
		
		
		// ======================================
		
		// 질문 : 배열을 선언, 생성만 해놓고 값을 초기화(저장) 해놓지 않을 경우? 배열에 접근하여 값을 얻으려고 할때
		int[] score2 = new int[3];
		
		// 0인섹스 위치에 100저장
		score2[0] = 100;
		score2[1] = 50;
		
		for(int i=0; i<score2.length; i++) {
			System.out.println("score2["+i + "] " + score2[i]);
		}
		
		
		
		
		System.out.println("==============================");
		
		/* 배열 메모리를 생성하여, 배열메모리의 주소값을 저장할 참조변수가 하는 역할에 대해 알아보자. */
		int[] aArr = {1, 2, 3}; 	// 이 배열의 시작 주소는 참조변수 aArr에 저장된다.
		int bArr[] = {4, 5, 6};		
		int cArr[] = {6, 7, 8};
		
		
		// [1, 2, 3] 이 저장된 배열 메모리의 주소값을 bArr참조변수에 저장 시키려면?
		bArr = aArr;
		
		for(int i=0; i<aArr.length; i++) {
			System.out.println(aArr[i] + " : " + bArr[i]);
		}
		
		
		/*
		 	bArr = aArr;
			-> bArr참조변수와 aArr참조 변수에 저장된 배열 메모리의 주소값이 같아진다.
				기존에 aArr참조변수가 참조하는 [4,5,6]배열 메모리는 JVM의 가비지컬렉터에 의해 수거됨(제거됨)
				더 이상 [4, 5, 6] 배열 메모리를 참조하는 것은 불가능
		
		*/
		
		
		
		
		
		
	}

}
