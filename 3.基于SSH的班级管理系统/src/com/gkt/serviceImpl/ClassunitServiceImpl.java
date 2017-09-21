package com.gkt.serviceImpl;

import java.util.List;

import com.gkt.dao.ClassunitDAO;
import com.gkt.entity.Classunit;
import com.gkt.service.ClassunitService;

public class ClassunitServiceImpl implements ClassunitService{
    private ClassunitDAO classunitDAO;

	public ClassunitDAO getClassunitDAO() {
		return classunitDAO;
	}

	public void setClassunitDAO(ClassunitDAO classunitDAO) {
		this.classunitDAO = classunitDAO;
	}
    
    //查询所有班级信息
	@Override
	public List<Classunit> findAll()
	{
		return classunitDAO.findAll();
	}
    
	//判断班级编号是否存在
	@Override
	public boolean checkClassnumber(String classunitnumber) {
		if(classunitDAO.checkClassnumber(classunitnumber))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//新增班级信息
	@Override
	public void addClassunit(Classunit classnumber) {
		classunitDAO.save(classnumber);
	}
    //查找班级编号
	@Override
	public Classunit findclassunitnumber(String classunitnumber) {
		// TODO Auto-generated method stub
		System.out.println("1");
		return classunitDAO.findclassunitnumber(classunitnumber);
	}
    //修改班级信息
	@Override
	public void editClassunit(Classunit classnumber) {
		// TODO Auto-generated method stub
		classunitDAO.attachDirty(classnumber);
	}
    //删除班级信息
	@Override
	public void delClassunit(Classunit classnumber) {
		// TODO Auto-generated method stub
		classunitDAO.delete(classnumber);
	}

	@Override
	public Classunit findByno(String classStr)
	{
		// TODO Auto-generated method stub
		return classunitDAO.findById(classStr);
	}
	
	
}
