package com.swz.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swz.dao.StudentDAO;
import com.swz.entity.Student;
import com.swz.service.StudentService;
@Component
public class StudentServiceImpl implements StudentService
{

	private StudentDAO studentDAO;
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> FindAllStudent()
	{
		 return studentDAO.findAll();
	}
	public StudentDAO getStudentDAO() 
	{
		 return studentDAO;
	}
	@Autowired
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	@Override
	public Student FindById(Integer id)
	{
		return  studentDAO.findById(id);
	}
	@Override
	public boolean DelStudent(Student student) 
	{
		boolean flage=true;
		try
		{
			studentDAO.delete(student);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			flage=false;
		}
		return flage;
	}
	@Override
	public List<Student> findByIDS(String ids) 
	{
		return studentDAO.findBySids(ids);
	}

}
