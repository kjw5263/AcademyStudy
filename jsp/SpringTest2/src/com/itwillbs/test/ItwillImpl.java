package com.itwillbs.test;

public class ItwillImpl implements Itwill{

	private int classNum;
	private Person student;
	
	
	
	
	@Override
	public void study() {
		System.out.println(classNum + "강의장 학생");
		student.sayHello();
	}




	public int getClassNum() {
		return classNum;
	}




	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}




	public Person getStudent() {
		return student;
	}




	public void setStudent(Person student) {
		this.student = student;
	}
}
