package com.gkt.action;

import java.util.List;

import com.gkt.dao.ClassunitDAO;
import com.gkt.entity.Classunit;
import com.gkt.entity.Student;
import com.gkt.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

public class StudentEditAction extends ActionSupport{
    //变量
	private String studentnumber = "";
	private String studentname = "";
	private String studentgender = "";
	private String studentbirth = "";
	private String studentpassword = "";
	private String studentphone = "";
	private String studentaddress = "";
	private String studentclass = "";
	private StudentService studentService;
	private Student studentex;
	private List<Student> student;
	private Classunit classunit;
	private ClassunitDAO classunitDAO;
    
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
	public void setStudentclass(String studentclass) {
		this.studentclass = studentclass;
	}
	public String getStudentclass() {
		return studentclass;
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
	public void setClassunitDAO(ClassunitDAO classunitDAO) {
		this.classunitDAO = classunitDAO;
	}
	
	public String execute() throws Exception
	{
		System.out.println("执行edit的action");
		
		try
		{
			studentex = studentService.findstudentnumber(getStudentnumber());
			
			studentex.setStudentName(getStudentname());
			studentex.setStudentGender(getStudentgender());
			studentex.setStudentBirth(getStudentbirth());
			studentex.setStudentPassword(getStudentpassword());
			studentex.setStudentPhone(getStudentphone());
			studentex.setStudentAddress(getStudentaddress());
			classunit = classunitDAO.findclassunitnumber(studentclass);
			studentex.setClassunit(classunit);
			studentService.editStudent(studentex);
			student = studentService.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
}
