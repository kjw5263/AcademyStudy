package com.itwillbs.test;

public class Main {
	
	static void showInfo(String name, String tel) {
		System.out.println("이름 : " + name + "  전화번호 : "+ tel);
	}

	public void showScore(int kor, int eng, int math) {
		int sum = kor + eng + math;
		int avg = sum/3;
		System.out.println("총합 : " + sum + "  평균 : " + avg);
	}
	
	// 사용자 정보 + 점수정보(총점, 평균)를 출력
	void showTotal(ItwillBean ib){
		
		System.out.println("이름 : " + ib.getName() + "  전화번호 : "+ ib.getTel());
		System.out.println("총합 : " + (ib.getKor() + ib.getEng() + ib.getMath()) + "  평균 : "
						+ (ib.getKor() + ib.getEng() + ib.getMath())/3);
		//System.out.println(ib);
	}
	
	
	public static void main(String[] args){
		ItwillBean ib = new ItwillBean();
		System.out.println(ib.toString());	
		System.out.println(ib);
		System.out.println("==============================");
		
		// 객체 생성 없이 학생 한명의 정보를 생성 후
		// 학생의 정보 출력, 점수의 총합, 평균 계산 후 출력 
		String name="홍길동";
		String tel="010-1234-1234";
		int kor=75;
		int eng=100;
		int math=80;
		

		// 메소드 생성 showInfo() : 이름과 전화번호 출력
		// 			showScore() : 총합, 평균 출력
		showInfo(name, tel);
		Main m = new Main();
		m.showScore(kor, eng, math);
		
		
		System.out.println("==============================");
		
		
		ItwillBean kim = new ItwillBean();
		kim.setName("김지원");
		kim.setTel("010-0000-0000");
		kim.setKor(85);
		kim.setEng(90);
		kim.setMath(30);
		
		m.showTotal(kim);
		
		
		System.out.println("======================");
		// 계산 전용 객체 Calc 생성
		// 총점 (SUM) - 계산 후 리턴, 평균 (AVG) - 계산 후 출력
		// 해당 메소드를 오버로딩해서 점수 3개, 객체정보를 사용하는 메서드 구현
		Calc cal = new Calc();
		System.out.println(cal.SUM(kor, eng, math));
		System.out.println(cal.SUM(kim));
		
		System.out.println(cal.AVG(kor, eng, math));
		System.out.println(cal.AVG(kim));
	}
}




