package com.gkt.serviceImpl;

import java.util.List;

import com.gkt.dao.GradeDAO;
import com.gkt.dao.StudentDAO;
import com.gkt.entity.Classunit;
import com.gkt.entity.Course;
import com.gkt.entity.Grade;
import com.gkt.entity.GradeId;
import com.gkt.entity.Student;
import com.gkt.service.GradeService;

public class GradeServiceImpl implements GradeService{
    private GradeDAO gradeDAO;
    private StudentDAO studentDAO;
    private List<Student> student;
    
	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public GradeDAO getGradeDAO() {
		return gradeDAO;
	}

	public void setGradeDAO(GradeDAO gradeDAO) {
		this.gradeDAO = gradeDAO;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public List<Grade> findAll() {
		// TODO Auto-generated method stub
		return gradeDAO.findAll();
	}

	@Override
	public List<Grade> findByCourse(Course course) {
		// TODO Auto-generated method stub
		return gradeDAO.findByCourse("course", course);
	}

	@Override
	public List<Grade> findByClass(Classunit classunit) {
		// TODO Auto-generated method stub
		student = studentDAO.findByClass("Classunit",classunit);
		return gradeDAO.findByStudent("Student",student);
	}

	@Override
	public List<Grade> findByCourseAndClass(Course course, Classunit classunit) {
		// TODO Auto-generated method stub
		return gradeDAO.findByCourseClass(course,classunit);
	}

	@Override
	public boolean findById(GradeId id) {
		// TODO Auto-generated method stub
		if(gradeDAO.findByGId(id))
		{
			return true;			
		}
		else
		{
			return false;
		}
	}

	@Override
	public void Save(Grade grades)
	{
		gradeDAO.save(grades);
		
	}

	@Override
	public void update(Grade gra)
	{
		gradeDAO.attachDirty(gra);
		
	}

}
