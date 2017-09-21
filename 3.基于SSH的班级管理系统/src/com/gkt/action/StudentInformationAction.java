package com.gkt.action;

import java.util.List;

import com.gkt.entity.Student;
import com.gkt.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

public class StudentInformationAction extends ActionSupport{
	//变量
	private StudentService studentService;
	private List<Student> student;
	
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
		
	@Override
	public String execute() throws Exception
	{
		try
		{
			student=studentService.findAll();
		}
		catch(Exception e)
		{
			System.out.println("error");
		}
		return SUCCESS;
	}
		
}
