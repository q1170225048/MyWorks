package com.swz.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swz.dao.KcDAO;
import com.swz.entity.Kc;
import com.swz.service.CourseService;

@Component
public class CourseServiceImpl implements CourseService 
{
	
	private KcDAO kcDAO;

	@Override
	public void AddCourse(Kc kc) 
	{
		
		try
		{
			kcDAO.save(kc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void DelCourse(Kc kc) 
	{
		try 
		{
			kcDAO.delete(kc);
		} catch (Exception e)
		{
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Kc> FindAllCourse() {
		return kcDAO.findAll();
	}

	@Override
	public Kc FindCourseById(Integer id) {
		return kcDAO.findById(id);
	}

	public KcDAO getKcDAO() {
		return kcDAO;
	}
	@Autowired
	public void setKcDAO(KcDAO kcDAO) {
		this.kcDAO = kcDAO;
	}

	@Override
	public void UpdateCourse(Integer id)
	{
		
	}
	
}
