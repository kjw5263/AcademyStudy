package com.itwillbs.beantest;
// 자바빈이라는 필통
public class Javabean1 {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Javabean1 [id=" + id + "]";
	}
	
	
}
