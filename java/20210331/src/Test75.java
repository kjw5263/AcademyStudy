/*
	변수의 초기화에 대해서 알아보쟈
	
	변수의 초기화란? 변수를 선언하고 처음으로 값을 저장하는 것

*/

class InitTest{
	
	// 멤버변수(인스턴스변수)선언
	// - 초기화 하지 않아도 자동으로 int 변수에는 기본으로 0으로 초기화
	int x; 
	int y=x; // x변수에 저장된 0을 y변수에 저장(사용)가능
	
	void method1() {
		// 메소드 지역 내부에 선언한 변수? (지역변수)
		// -지역변수를 다른 곳에서 불러다가 사용하기 위해서 반드시 초기화 이루어져야 함
		// - 지역변수는 메소드 { } 지역 내부에서만 사용 가능
		int i=0;	// <- 초기화 필요
//		int j=i;  // i를 초기화하지 않앗다면  컴파일 에러 
		
	}
	
	
	
	
}


// 주제 : static 배열 초기화 연습




public class Test75 {
	
	// 명시적 초기화를 통해 static 배열 arr 10칸 생성
	static int[] arr = new int[10];
	
	// 클래스 초기화 블럭을 이용해서 배열의 각 요소를 Math클래스의 random() 클래스 메소드를 호출해
	// 임의의 값을 얻어 각각 arr배열에 저장시킨다
	static {
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random() * 10) + 1;
		}
	}
	
	
	
	
	public static void main(String[] args) {
//		for(int i=0; i<Test75.arr.length; i++) {
//			System.out.println("arr["+i+"] : " + arr[i]);
//		}

		for(int i : Test75.arr) {
			System.out.println(arr[i]);
		}
	}

}


/*
	결론
	[배열에 값을 초기화 할 경우에는 ]
	명시적 초기화 만으로는 복잡한 초기화 작업을 할 수 없기 때문에
	이런 경우에는 추가적으로 클래스 초기화 블럭을 사용하여 배열에 값을 초기화 해야한다.
	
	[인스턴스 변수의 복잡한 초기화는]
	생성자 또는 인스턴스 초기화 블럭을 사용한다.
	


*/