
import java.io.*;
// 주제 ㅣ PrintWriter클래스의 printf 메소드 사용
// 간단한 성적표를 만들어 어떤 특정파일에 printf메소듣를 사용하여 원한느 형식의 데이터로 출려
public class PrintWriterEx02 {

	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter("D:\\sungjuk.txt");
		// 파일에 저장할 데이터 (성적표 꾸미기)(
		pw.println("*****************************************");
		pw.println("성적표");
		pw.println("*****************************************");
		
		// 홍길동 3과목 점수 ㅊ출력 및 평군 출력 
		pw.printf("%3s : %5d", "홍길동", 98, 67, 85 );
		
		
		/*
			printf 인자 설명
			% 내가 원하는 형식으로 출력하겟다 
			%3s 문자열 출력3칸 -> "홍길동"
		
		
		
		
		*/
	}

}
