package com.gkt.action;

import com.gkt.entity.Course;
import com.gkt.service.CourseService;
import com.opensymphony.xwork2.ActionSupport;

public class CourseAddAction extends ActionSupport{
    //变量
	private String coursenumber = "";
	private String coursename = "";
	private String coursetype = "";
	private String coursegrade = "";
	private CourseService courseService;
	private Course courseex;
	
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
	public String getCoursegrade() {
		return coursegrade;
	}
	public void setCoursegrade(String coursegrade) {
		this.coursegrade = coursegrade;
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
	
	public String execute() throws Exception
	{
		if(courseService.checkCoursenumber(getCoursenumber()))
		{
			return ERROR;
		}
		else
		{
			courseex = new Course();
			courseex.setCourseNumber(coursenumber);
			courseex.setCourseName(coursename);
			courseex.setCourseType(coursetype);
			courseex.setCourseGrade(coursegrade);
			courseService.addCourse(courseex);
		}
		return SUCCESS;
	}
	
}
