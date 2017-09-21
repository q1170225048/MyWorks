package com.swz.service;

import java.util.List;

import com.swz.entity.Kc;

public interface CourseService {
	
	public   void  AddCourse(Kc kc);
	public   void  DelCourse(Kc kc);
	public   void  UpdateCourse(Integer id);
	public   List<Kc> FindAllCourse();
	public   Kc  FindCourseById(Integer id);
}
