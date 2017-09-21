package com.gkt.action;

import java.util.List;

import com.gkt.entity.Classunit;
import com.gkt.entity.Student;
import com.gkt.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

public class StudentDelAction extends ActionSupport{
    //变量
	private String studentnumber = "";
	private String studentname = "";
	private String studentgender = "";
	private String studentbirth = "";
	private String studentpassword = "";
	private String studentphone = "";
	private String studentaddress = "";
	private Classunit classunit;
	private StudentService studentService;
	private Student studentex;
	private List<Student> student;
	//函数
	public String getStudentnumber() {
		return studentnumber;
	}
	public void setStudentnumber(String studentnumber) {
		this.studentnumber = studentnumber;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentgender() {
		return studentgender;
	}
	public void setStudentgender(String studentgender) {
		this.studentgender = studentgender;
	}
	public String getStudentbirth() {
		return studentbirth;
	}
	public void setStudentbirth(String studentbirth) {
		this.studentbirth = studentbirth;
	}
	public String getStudentpassword() {
		return studentpassword;
	}
	public void setStudentpassword(String studentpassword) {
		this.studentpassword = studentpassword;
	}
	public String getStudentphone() {
		return studentphone;
	}
	public void setStudentphone(String studentphone) {
		this.studentphone = studentphone;
	}
	public String getStudentaddress() {
		return studentaddress;
	}
	public void setStudentaddress(String studentaddress) {
		this.studentaddress = studentaddress;
	}
	public Classunit getClassunit() {
		return classunit;
	}
	public void setClassunit(Classunit classunit) {
		this.classunit = classunit;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public Student getStudentex() {
		return studentex;
	}
	public void setStudentex(Student studentex) {
		this.studentex = studentex;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	public String execute() throws Exception
	{
		try
		{
			studentex = studentService.findstudentnumber(getStudentnumber());
			studentService.delstudent(studentex);
			student = studentService.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
}
