/*
	* 제어문이란?
	- 자바 프로그램이 원하는 결과를 얻기 위해서는 프로그램의 순차적인 흐름을 제어하는 명령문
	- 제어문의 종류
		1. 조건문
		2. 반복문
	
	* 조건문의 종류
	- 주어진 조건식의 결과값에 따라 별도의 명령을 수행하도록 제어하는 명령문
	- 조건문의 종류
		1-1. if문
		1-2. if else문
		1-3. if else if else문
		1-4. switch문
		
		1-1. if문
			- 조건식 결과값이 참(true)이면 주어진 명령문을 실행하며, 거짓(false)이면 아무것도 실행하지 않는다.
			- 형식
				if(조건식){
					실행문;
				}
				
				
		1-2. if else 문
			- 형식
				if(조건식) {
					실행문; (조건식의 연산결과가 참일 때 수행될 명령어)
				} else {
					실행문; (조건식의 연산결과가 거짓일 때 수행될 명령어)
				}
			- if 조건식의 연산결과가 거짓일 때만 else내의 명령어가 실행된다.
			
		
			
		1-3. if else if else문
			- 형식
				if(조건식1) {
					실행문1;	// 조건식 1의 결과가 참일 때 실행
				} else if(조건식2) {
					실행문2;	// 조건식 2의 결과가 참일 때 실행 
				} else {
					실행문3;	// 조건식 3의 결과가 참일 때 실행 
				}
				

*/
public class Test19 {
	public static void main(String[] args) {
		System.out.println("===============if문=============");
		
		// 예제) if문을 사용하여, 해당 문자가 영문 소문자인지 확인하라.
		char ch = 'j';
		
		// ch변수에 저장된 값이 소문자a에서 소문자z 사이라면
		if(ch>='a' && ch <='z') {
			System.out.println(ch + "는 영문 소문자 입니다.");
		}
		
		
		
		int visitCount = 0;
		
		// visitCount변수에 저장되어 있는 값이 1보다 작으면?
		if ( visitCount < 1 ) {	
			System.out.println("처음 오셨군요. 방문해주셔서 감사합니다.");
		}
		
		
		System.out.println("===============if else문=============");
		
		// visitCount변수에 저장되어 있는 값이 
		visitCount = 5;
		
		if ( visitCount < 1 ) {
			System.out.println("처음 오셨군요. 방문을 환영합니다.");
		} else { // 홈페이지에 한번이라도 방문한 적 있다면?
			System.out.println("다시 방문해주셔서 감사합니다.");
		}
		System.out.println("방문 횟수는 " + ++visitCount + "번 입니다.");
		
		
		
		System.out.println("===============if else if else문=============");
		// 예제) if else if else문을 사용해서 해당 ch변수에 저장되어있는 문자가
		// 영문 소문자인지 대문자인지 아니면 영문자가 아닌지 확인하라
		// char ch = 'j';
		
		if (ch >= 'a' && ch <= 'z') {	
			System.out.println("소문자 입니다.");
		} else if (ch >= 'A' && ch <= 'Z') {
			System.out.println("대문자 입니다. ");
		} else {	
			System.out.println("영문자가 아닙니다.");
		}	
	}
}
