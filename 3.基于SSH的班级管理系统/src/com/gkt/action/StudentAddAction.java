package com.gkt.action;

import com.gkt.dao.ClassunitDAO;
import com.gkt.entity.Classunit;
import com.gkt.entity.Student;
import com.gkt.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class StudentAddAction extends ActionSupport{
    //变量
	private String studentnumber = "";
	private String studentname = "";
	private String studentgender = "";
	private String studentbirth = "";
	private String studentpassword = "";
	private String studentphone = "";
	private String studentaddress = "";
	private String studentclass = "";
	private Student studentex;
	private StudentService studentService;
	private Classunit classunit;
	private ClassunitDAO classunitDAO;
	
	//函数
	public void setClassunitDAO(ClassunitDAO classunitDAO) {
		this.classunitDAO = classunitDAO;
	}
	public String getStudentnumber() {
		return studentnumber;
	}
	public String getStudentclass() {
		return studentclass;
	}
	public void setStudentclass(String studentclass) {
		this.studentclass = studentclass;
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
	
	public String execute() throws Exception
	{
		System.out.println("执行add的action");
		if(studentService.checkStudentnumber(getStudentnumber()))
		{
			return ERROR;
		}
		else
		{
			studentex = new Student();
			studentex.setStudentNumber(studentnumber);
			studentex.setStudentName(studentname);
			studentex.setStudentGender(studentgender);
			studentex.setStudentBirth(studentbirth);
			studentex.setStudentPassword(studentpassword);
			studentex.setStudentPhone(studentphone);
			studentex.setStudentAddress(studentaddress);
			classunit = classunitDAO.findclassunitnumber(studentclass);
			studentex.setClassunit(classunit);
			studentService.addStudent(studentex);
		}
		return SUCCESS;
	}
	
}
