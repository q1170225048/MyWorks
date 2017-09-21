package com.swz.service;

import com.swz.entity.Classes;
import com.swz.entity.Student;

public interface LoginService {
	
	public  Boolean  CheckLogin( String username, String  password);
	public void SaveS(Student student);
	public Classes Findc(Integer ids);
	public Student Finds(String username);
}
