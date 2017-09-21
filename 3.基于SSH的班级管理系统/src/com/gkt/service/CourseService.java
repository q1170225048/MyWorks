package com.gkt.service;

import java.util.List;

import com.gkt.entity.Course;

public interface CourseService {
    //查询所有课程信息
	public List<Course> findAll();
    //判断课程编号是否存在
	public boolean checkCoursenumber(String coursenumber);
    //新增课程信息
	public void addCourse(com.gkt.entity.Course courseex);
	//查找修改对象
	public Course findcoursenumber(String coursenumber);
	//保存修改对象
	public void editCourse(Course courseex);
	//删除课程信息
	public void delCourse(Course courseex);
	public Course findByno(String courseStr);
}
