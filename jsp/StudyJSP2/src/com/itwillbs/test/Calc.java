package com.itwillbs.test;

public class Calc {
		
	public int SUM(int kor, int eng, int math){
		return kor+eng+math;
	}
	public int SUM(ItwillBean ib){
		return ib.getKor() + ib.getEng() + ib.getMath();
	}
	
	public double AVG(int kor, int eng, int math){
		return (kor+eng+math)/3.0 ;
	}
	
	public double AVG(ItwillBean ib){
		return ((ib.getKor() + ib.getEng() + ib.getMath()) / 3.0);
	}
}
