package com.gkt.action;

import java.util.List;

import com.gkt.entity.Course;
import com.gkt.service.CourseService;
import com.opensymphony.xwork2.ActionSupport;

public class CourseInformationAction extends ActionSupport{
    //变量
	private CourseService courseService;
	private List<Course> course;
	
	//函数
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
	
	public String execute() throws Exception
	{
		try
		{
			course = courseService.findAll();
		}
		catch(Exception e)
		{
			System.out.println("出错了");
		}
		
		return SUCCESS;
	}
	
}
