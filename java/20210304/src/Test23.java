/* 중첩 if문이란?
 * : if문 블럭 내부에 또 다른 if문을 말함
 * - 형식
 * 	if(조건식1) {
 * 		//조건식1의 연산결과가 true일 때 수행될 문장들 작성
 * 		if(조건식2) {
 * 			// 조건식1과 조건식2의 연산결과가 모두 true일 때 수행될 문장들 작성
 * 			
 * 
 * 		} else {
 *			// 조건식1은 true이고, 조건식2는 false일 때 수행될 문장들 작성
 * 
 * 		}
 * 	} else {
 * 	
 * 	}
 * 
 * 
 * 
 * */

	

public class Test23 {
	public static void main(String[] args) {
		int score = 82;
		// A+, A-, B+, B-, C ...
		String grade="";	// 학점을 저장할 변수
		

		System.out.println("당신의 점수는 " + score + "점 입니다.");
		
		
		// score변수에 저장되어 있는 값이 90보다 크거나 같은가?
		if(score >= 90) {
			grade = "A";				// -> grade변수에 "A"문자열 저장
			if(score >= 98 ) {			// 90 점보다 크거나 같은 점수 중에서도, 98점보다 크거나 같나?
				grade += "+";			// -> grade변수에 "+"기호 누적(+=)
			} else if (score < 94) {	// 90점보다 크거나 같은 점수 중에서도, 94점 미만인가?
				grade += "-";			// -> grade 변수에 "-" 기호 누적
			}
		}
		// score변수의 값이 80점보다 크거나 같은가?
		else if(score >= 80) {
			grade = "B";			// -> grade변수에 "B"문자열 저장
			
			if(score >= 88) {		// 80점 이상 중에서라도, 88점 이상이라면	
				grade += "+";		// -> grade변수에 "+" 기호 누적
			} else if(score < 84){	// 80점 이상 중에서라도, 84점 미만이라면
				grade += "-";		// -> grade변수에 "-" 기호 누적
			}
		
		}
		// score변수의 값이 80미만이라면?
		else {
			// -> grade변수에 "C"문자열 저장
			grade = "C";
		}
		

		System.out.println("당신의 학점은 " + grade + " 입니다.");
		
		
	}
}
