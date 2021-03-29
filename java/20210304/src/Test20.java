
public class Test20 {

	public static void main(String[] args) {
		/* if  else if  else 조건문을 이용한 예제 */
		
		// 학생 점수를 저장할 변수 score 선언 후 45점 저장.
		int score = 45;
		
		// 학생 점수에 따른 학점 저장할 변수 grade 선언.
		char grade = '\u0000';
		
		// 조건식 : 학생 점수가 90이상이면?
		if(score >= 90) {
			grade = 'A';	
		} else if (score >= 80) {	// 80점 이상이면?
			grade = 'B';
		} else {	// 나머지 점수라면
			grade = 'C';
		}
		
		System.out.println("당신의 학점은 " + grade );
		
		
		
		// 위 if  else if  else 조건문을 삼항조건연산자로 변경하기
		grade = score>=90? 'A':(score>=80? 'B':'C'); 

		System.out.println("당신의 학점은 " + grade );

		
	}
}
