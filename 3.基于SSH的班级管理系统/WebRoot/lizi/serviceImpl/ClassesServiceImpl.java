package com.swz.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swz.dao.ClassesDAO;
import com.swz.entity.Classes;
import com.swz.service.ClassesService;
@Component
public class ClassesServiceImpl implements ClassesService {

	private ClassesDAO classesDAO;
	public ClassesDAO getClassesDAO() {
		return classesDAO;
	}
	@Autowired
	public void setClassesDAO(ClassesDAO classesDAO) {
		this.classesDAO = classesDAO;
	}
	@Override
	public boolean AddCla(Classes classes) 
	{
		classesDAO.save(classes);
		return false;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Classes> FindAllC() 
	{
		return  classesDAO.findAll();
	}
	@Override
	public boolean DelClass(Classes classes) 
	{
		boolean flage=true;
		try
		{
			classesDAO.delete(classes);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			flage=false;
		}
	  
	 	return flage;
	}
	@Override
	public Classes FindById(Integer id) {
		return classesDAO.findById(id);
	}

}
