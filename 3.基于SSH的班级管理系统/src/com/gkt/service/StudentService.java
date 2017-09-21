package com.gkt.service;

import java.util.List;

import com.gkt.entity.AbstractStudent;
import com.gkt.entity.Student;

public interface StudentService {
	//查询所有班级信息
	public List<Student> findAll();
	//根据学生编号查询学生信息
	public Student findstudentnumber(String studentnumber);
	//保存修改对象
	public void editStudent(Student studentex);
	//判断学生学号是否存在
	public boolean checkStudentnumber(String studentnumber);
	//删除学生信息
	public void delstudent(Student studentex);
	//新增学生信息
	public void addStudent(Student studentex);
	
}
