package com.gkt.entity;

import java.util.List;

public class Count_grade {
    //变量
	private String studentNumber;
	private String studentName;
	private Classunit classunit;
	
	private List<Count_course> count_course;
	
	private String count;
    //函数
	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Classunit getClassunit() {
		return classunit;
	}

	public void setClassunit(Classunit classunit) {
		this.classunit = classunit;
	}

	public List<Count_course> getCount_course() {
		return count_course;
	}

	public void setCount_course(List<Count_course> count_course) {
		this.count_course = count_course;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
	
	
}
