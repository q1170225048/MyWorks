package com.gkt.action;

import java.util.List;

import com.gkt.entity.Course;
import com.gkt.service.CourseService;
import com.opensymphony.xwork2.ActionSupport;

public class CourseDelAction extends ActionSupport{
    //变量
	private String coursenumber = "";
	private String coursename = "";
	private String coursetype = "";
	private String coursegarde = "";
	private CourseService courseService;
	private Course courseex;
	private List<Course> course;
	
	//函数
	public String getCoursenumber() {
		return coursenumber;
	}
	public void setCoursenumber(String coursenumber) {
		this.coursenumber = coursenumber;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCoursetype() {
		return coursetype;
	}
	public void setCoursetype(String coursetype) {
		this.coursetype = coursetype;
	}
	public String getCoursegarde() {
		return coursegarde;
	}
	public void setCoursegarde(String coursegarde) {
		this.coursegarde = coursegarde;
	}
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public Course getCourseex() {
		return courseex;
	}
	public void setCourseex(Course courseex) {
		this.courseex = courseex;
	}
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	
	public String execute() throws Exception
	{
		try
		{
			courseex = courseService.findcoursenumber(getCoursenumber());
			courseService.delCourse(courseex);
			course = courseService.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
}
