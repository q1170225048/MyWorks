package com.gkt.serviceImpl;

import java.util.List;

import com.gkt.dao.StudentDAO;
import com.gkt.entity.Student;
import com.gkt.service.StudentService;



public class StudentServiceImpl implements StudentService{
	private StudentDAO studentDAO;

	public StudentDAO getStudentdao() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
    //查询所有学生信息
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentDAO.findAll();
	}

	@Override
	public Student findstudentnumber(String studentnumber) {
		// TODO Auto-generated method stub
		return studentDAO.findById(studentnumber);
	}

	@Override
	public void editStudent(Student studentex) {
		// TODO Auto-generated method stub
		studentDAO.attachDirty(studentex);
	}

	@Override
	public boolean checkStudentnumber(String studentnumber) {
		// TODO Auto-generated method stub
		if(studentDAO.checkStudentnumber(studentnumber))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void delstudent(Student studentex) {
		// TODO Auto-generated method stub
		studentDAO.delete(studentex);
	}

	@Override
	public void addStudent(Student studentex) {
		// TODO Auto-generated method stub
		studentDAO.save(studentex);
	}
   

}
