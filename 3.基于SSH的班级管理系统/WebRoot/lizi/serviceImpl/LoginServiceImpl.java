package com.swz.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swz.dao.ClassesDAO;
import com.swz.dao.StudentDAO;
import com.swz.entity.Classes;
import com.swz.entity.Student;
import com.swz.service.LoginService;

@Component
public class LoginServiceImpl implements LoginService {
	
	private  ClassesDAO classesDAO;
	private  StudentDAO  studentDAO;
	@Override
	public Boolean CheckLogin(String username, String password) 
	{
		if(studentDAO.CheckLogin(username, password))
		{
			return true;
		}
			return false;
	}
	@Override
	public Classes Findc(Integer ids) 
	{
		return  classesDAO.findById(ids);
	}
	public ClassesDAO getClassesDAO() {
		return classesDAO;
	}
	public StudentDAO getStudentDAO()
	{
		return studentDAO;
	}
	
	@Override
	public void SaveS(Student student) {
			studentDAO.save(student);
	}
	@Autowired
	public void setClassesDAO(ClassesDAO classesDAO) {
		this.classesDAO = classesDAO;
	}
	@Autowired
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	@Override
	public Student Finds(String username) {
		return studentDAO.findBySname(username).get(0);
	}


}
