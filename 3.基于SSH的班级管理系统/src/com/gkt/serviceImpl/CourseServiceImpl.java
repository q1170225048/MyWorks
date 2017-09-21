package com.gkt.serviceImpl;

import java.util.List;

import com.gkt.dao.CourseDAO;
import com.gkt.entity.Course;
import com.gkt.service.CourseService;

public class CourseServiceImpl implements CourseService{
    private CourseDAO courseDAO;
    
	public CourseDAO getCourseDAO() {
		return courseDAO;
	}


	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

    //查询所有课程信息
	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return courseDAO.findAll();
	}

	//判断课程编号是否存在
	@Override
	public boolean checkCoursenumber(String coursenumber) {
		// TODO Auto-generated method stub
		if(courseDAO.checkCoursenumber(coursenumber))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//新增课程信息
	@Override
	public void addCourse(Course courseex) {
		// TODO Auto-generated method stub
		courseDAO.save(courseex);
	}

    //查找课程编号
	@Override
	public Course findcoursenumber(String coursenumber) {
		// TODO Auto-generated method stub
		return courseDAO.findcoursenumber(coursenumber);
	}

    //修改课程信息
	@Override
	public void editCourse(Course courseex) {
		// TODO Auto-generated method stub
		courseDAO.attachDirty(courseex);
	}

    //删除课程信息
	@Override
	public void delCourse(Course courseex) {
		// TODO Auto-generated method stub
		courseDAO.delete(courseex);
	}


	@Override
	public Course findByno(String courseStr)
	{
		// TODO Auto-generated method stub
		return courseDAO.findById(courseStr);
	}

}
