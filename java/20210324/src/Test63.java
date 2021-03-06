import java.time.Year;

// 클래스, 객체 생성, 생성자 만들기 연습
class MyDate {
	// My Date라는 이름의 클래스 정의 

		// 정수값을 저장할 year, month, day변수 정의
		int year;
		int month;
		int day;
		
		// 기본 생성자 정의
			// year 2014 저장
			// month 1 저장
			// day 1 저장
		MyDate() {
			year = 2014;
			month = 1;
			day = 1;
		}
		
		// 년도 값을 n_year 매개변수로 전달받아 year=n_year, month=1, day=1
		MyDate(int n_year){
			year = n_year;
			month = 1;
			day = 1;
		}
		
		// 년도, 월 값을 n_year, n_month 매개변수로 전달 받기
		MyDate(int n_year, int n_month){
			year = n_year;
			month = n_month;
			day = 1;
		}
		
		// 년도, 월, 일 값을 매개변수로 전달 받기
		MyDate(int n_year, int n_month, int n_day){
			year = n_year;
			month = n_month;
			day = n_day;
		}
		
		
		// 매개변수 n_year 로 전달받은 값을 year 변수에 저장시킬 메소드 정의
		void setYear(int n_year) {
			year = n_year;
		}
		// 매개변수 n_month로 전달받은 값을 month 변수에 저장시킬 메소드 정의 
		void setMonth(int n_month) {
			month = n_month;
		}
		// 매개변수 n_day로 전달받은 값을 day변수에 저장시킬 메소드 정의 
		void setDay(int n_day) {
			day = n_day;			
		}
		
		
		
		// year변수에 저장되어 있는 값을 반환할 목적의 getYear메소드 정의
		int getYear() {
			return year;
		}
		// year변수에 저장되어 있는 값을 반환할 목적의 getYear메소드 정의
		int getMonth() {
			return month;
		}
		// year변수에 저장되어 있는 값을 반환할 목적의 getYear메소드 정의
		int getDay() {
			return day;
		}
		
		
		// prn 메소드 정의 : year-month-day 출력
		void prn() {
			System.out.println(year+"-"+month+"-"+day);
		}
		
		
}


public class Test63 {
	public static void main(String[] args) {
		
		MyDate m1 = new MyDate();
		/*
		 * m1.setYear(2014); m1.setMonth(1); m1.setDay(1);
		 */
		
		System.out.println(m1.getYear()+"-" + m1.getMonth() + "-"+ m1.getDay());
		
		
		
		//set으로시작하는 메소드들 호출 해서 값 저장
		m1.setYear(2014);
		m1.setMonth(8);
		m1.setDay(6);
			
		//get으로 시작하는 메소드들 호출 해서 출력
		System.out.println(m1.getYear() + "-" + m1.getMonth() +"-" + m1.getDay());
		
		// MyDate클래스를 이용해 객체 생성시 년도 값을 전달받는 생성자 호출
		// 호출시 전달할 값 2015
		// 참조변수 m2
		MyDate m2 = new MyDate(2015);
		m2.prn();
		// 출력 2015-1-1
		
		
		// MyDate클래스를 이용해 객체 생성시 년도,월 값을 전달받는 생성자 호출
		// 호출시 전달할 값 2016, 5
		MyDate m3 = new MyDate(2016, 5);
		m3.prn();
		//출력 2016-5-1
		
		
		//MyDate클래스를 이용해 객체 생성 시 년도,월, 일 값을 전달받는 생성자 호출
		// 전달할 값 2017, 7,7
		MyDate m4 = new MyDate(2017, 7, 7);
		m4.prn();
		// 출력 2017-7-7
		
		
		
	}
}
