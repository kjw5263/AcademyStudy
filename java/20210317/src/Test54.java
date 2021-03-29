/* 객체 지향 프로그래밍 3단계	

 		
 1단계  현실에 존재하는 객체 모델링 (데이터, 동작 추출)
	 푸들 객체
	 	데이터 : 황색털, 털길이 10센티, 다리길이100센티, 수컷, 종 푸들
	 	동작 : 걷기, 뛰기, 짖기, 주인을 알아보기, 번식
	 
 2단계  현실에 존재하는 객체의 데이터와 동작을 이용하여 클래스(설계도) 만들기
  
  */

class Puppy {
	// 변수 - 데이터 : 황색털, 털길이 10센티, 다리길이100센티, 수컷, 종 푸들
	String 종;		// 푸들, 시츄, 말티즈, 진돗개 ...
	String 털색깔;	// 10, 100 ...
	int 털길이;		// 파란색, 황색, ...
	int 다리길이;		// 100, 1000
	String 성별;		// 암컷, 수컷
	
	
 	// 메소드 - 동작 : 걷기, 뛰기, 짖기, 주인을 알아보기, 번식
	void 걷거나뛴다() {
		System.out.println(종 + " 걷거나 뛴다");
	}
	
	void 짖는다() {
		System.out.println(종 + " 짖는다");
	}
	
	void 주인을알아보다() {
		System.out.println(종 + " 주인을 알아본다");
	}
}		// Puppy 클래스 닫는 기호

public class Test54 {

	public static void main(String[] args) {
		// 3단계 : 클래스 설계도를 참고하여 현실세계에 존재하는 객체들을 코드로 생성
			// 푸들 객체 생성
			// 1. Puppy클래스 설계도를 바탕으로 한 참조변수 선언
			Puppy poodle;
			
			// 2. new 연산자로 Puppy클래스로 부터 객체 메모리 생성 후, 주소값을 poodle 참조변수에 저장
			poodle = new Puppy();
			// 설명) poodle 참조변수에 생성된 객체 메모리의 주소값이 들어있으므로 
			// poodle 참조변수명으로, 생성된 객체 메모리에 접근이 가능
			
			//3. 생성된 poodle객체 내부의 변수에 데이터 저장
			// 형식) 참조변수명.객체변수명 = 저장할데이터;
			
			poodle.종 = "푸들";
			poodle.털색깔 = "황색";
			poodle.다리길이 = 1;
			poodle.성별 = "male";
			poodle.털길이 = 1;
			
			
			// 4. 푸들 객체에 정의된 객체 메소드를 호출하여 동작시키기
			// 형식) 참조변수명.객체메소드명();
			poodle.걷거나뛴다();
			poodle.짖는다();
			poodle.주인을알아보다();
			
			
			
			
			// 3단계 객체 생성 연습
			// 1. Puppy클래스 설계도를 바탁으로 한 참조변수 pome선언
			Puppy pome;
			// 2. new 연산자로 객체생성 후 pome참조변수에 객체 주소값 저장
			pome = new Puppy();
			
			// 3. 생성한 객체에 각 객체변수에 데이터 저장
			// 저장할 데이터
			// "포메라니안" "흰색" 털길이10 다리길이 2 "수컷"
			pome.종 = "포메라니안";
			pome.털색깔 = "흰색";
			pome.털길이 = 10;
			pome.다리길이 = 2;
			pome.성별 = "수컷";
			
			
			// 4. pome참조변수에 저장된 객체 내부의 객체 메소드를 호출하여 동작시키기
			pome.걷거나뛴다();
			pome.짖는다();
			pome.주인을알아보다();
			
			// 출력결과
			/* 포메라니안 걷거나 뛴다
			 * 포메라니안 짖는다
			 * 포메라니안 주인을 알아본다
			 */
			
			
			
			
			
			

	}

}
