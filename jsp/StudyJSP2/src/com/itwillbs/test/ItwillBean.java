package com.itwillbs.test;

public class ItwillBean {
	private String name;
	private String tel;
	private int kor;
	private int eng;
	private int math;
	
	// 오버로딩 된 생성자가 없을 경우에만
	// 컴파일러가 자동으로 기본생성자 생성
//	public itwillBean() {
//		
//	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}

	
	@Override
	public String toString() {
		return "ItwillBean [name=" + name + ", tel=" + tel + ", kor=" + kor + ", eng=" + eng + ", math=" + math
				+ ", getName()=" + getName() + ", getTel()=" + getTel() + ", getKor()=" + getKor() + ", getEng()="
				+ getEng() + ", getMath()=" + getMath() + "]";
	}
	
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString();
//		// super 부모의 레퍼런스를 저장한다!
//		// 일반 레퍼런드와의 차이점 : 내가 안만들어도 돼~
//	}
	
	
	
	
	
	
	
}
