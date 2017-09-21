package com.gkt.serviceImpl;

import org.springframework.stereotype.Component;

import com.gkt.dao.StudentDAO;
import com.gkt.service.LoginService;

@Component
public class LoginServiceImpl implements LoginService{
	private  StudentDAO  studentDAO;
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public boolean LoginCheck(String usernumber, String password) {
		if(studentDAO.CheckLogin(usernumber, password))
		{
			return true;
		}
		return false;
	}
}
