package com.gkt.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gkt.entity.Course;
import com.gkt.entity.Grade;
import com.gkt.entity.Student;
import com.gkt.service.ClassunitService;
import com.gkt.service.CourseService;
import com.gkt.service.GradeService;
import com.gkt.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

public class FindgradeAction extends ActionSupport{
    //变量
	private HttpServletRequest request;
	private javax.servlet.http.HttpServletResponse response;
	
	private String classnum;
	private String coursenum;
	private String classstr;
	private String coursestr;
	
	private StudentService studentService;
	private GradeService gradeService;
	private List<Grade> grade;
	
	private ClassunitService classunitService;
	private List<com.gkt.entity.Classunit> classnumber;
	private com.gkt.entity.Classunit classex;
	
	private CourseService courseService;
	private List<Course> course;
	private List<Student> student;
	private Course courseex;
	//函数
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public javax.servlet.http.HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(javax.servlet.http.HttpServletResponse response) {
		this.response = response;
	}
	public String getClassnum() {
		return classnum;
	}
	public void setClassnum(String classnum) {
		this.classnum = classnum;
	}
	public String getCoursenum() {
		return coursenum;
	}
	public void setCoursenum(String coursenum) {
		this.coursenum = coursenum;
	}
	public String getClassstr() {
		return classstr;
	}
	public void setClassstr(String classstr) {
		this.classstr = classstr;
	}
	public String getCoursestr() {
		return coursestr;
	}
	public void setCoursestr(String coursestr) {
		this.coursestr = coursestr;
	}
	public GradeService getGradeService() {
		return gradeService;
	}
	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}
	public List<Grade> getGrade() {
		return grade;
	}
	public void setGrade(List<Grade> grade) {
		this.grade = grade;
	}
	public ClassunitService getClassunitService() {
		return classunitService;
	}
	public void setClassunitService(ClassunitService classunitService) {
		this.classunitService = classunitService;
	}
	public List<com.gkt.entity.Classunit> getClassnumber() {
		return classnumber;
	}
	public void setClassnumber(List<com.gkt.entity.Classunit> classnumber) {
		this.classnumber = classnumber;
	}
	public com.gkt.entity.Classunit getClassex() {
		return classex;
	}
	public void setClassex(com.gkt.entity.Classunit classex) {
		this.classex = classex;
	}
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	public Course getCourseex() {
		return courseex;
	}
	public void setCourseex(Course courseex) {
		this.courseex = courseex;
	}
	
	public String execute() throws Exception
	{
		try
		{
			System.out.println(coursestr);
			classnumber = classunitService.findAll();
			course = courseService.findAll();
			student = studentService.findAll();
			if(classstr==null && coursestr==null)
			{
				System.out.println(coursestr);
				grade = gradeService.findAll();
			}
			
			else
			{
				courseex = courseService.findcoursenumber(coursestr);
				grade = gradeService.findByCourse(courseex);
				
				classnum = classex.getClassNumber();
				classstr = classex.getClassName();
				coursenum = courseex.getCourseNumber();
				coursestr = courseex.getCourseName();
			}
		}
		catch(Exception e)
		{
			System.out.println("出错了");
		}
		
		return SUCCESS;
	}
	public List<Student> getStudent()
	{
		return student;
	}
	public void setStudent(List<Student> student)
	{
		this.student = student;
	}
	public StudentService getStudentService()
	{
		return studentService;
	}
	public void setStudentService(StudentService studentService)
	{
		this.studentService = studentService;
	}
	
}
