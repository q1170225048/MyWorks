package com.gkt.service;

import java.util.List;

import com.gkt.entity.Classunit;
import com.gkt.entity.Course;
import com.gkt.entity.Grade;
import com.gkt.entity.GradeId;

public interface GradeService {
    //将学生信息，课程信息保存到成绩表
	
	//查询成绩表的所有信息
	public List<Grade> findAll();
	//根据课程查询成绩表信息
	public List<Grade> findByCourse(Course course);
	//根据班级查询成绩表信息
	public List<Grade> findByClass(Classunit classunit);
	//根据课程和班级查询成绩表信息
	public List<Grade> findByCourseAndClass(Course course,Classunit classunit);
	//查询课程表中是否存在ID
	public boolean findById(GradeId id);
	//更新课程表信息
	public void Save(Grade grades);
	public void update(Grade gra);
	
}
