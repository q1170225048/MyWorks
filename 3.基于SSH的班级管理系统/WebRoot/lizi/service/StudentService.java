package com.swz.service;

import java.util.List;

import com.swz.entity.Student;

public interface StudentService {

	List<Student> FindAllStudent();
	Student FindById(Integer id);
	boolean DelStudent(Student student);
	public  List<Student> findByIDS(String ids);
}
