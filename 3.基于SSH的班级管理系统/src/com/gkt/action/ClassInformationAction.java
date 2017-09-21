package com.gkt.action;

import java.util.List;

import com.gkt.entity.Classunit;
import com.gkt.service.ClassunitService;
import com.opensymphony.xwork2.ActionSupport;

public class ClassInformationAction extends ActionSupport {
    //变量
	private ClassunitService classunitService;
	private List<Classunit> classunit;
	
	//函数
	public ClassunitService getClassunitService() {
		return classunitService;
	}
	public void setClassunitService(ClassunitService classunitService) {
		this.classunitService = classunitService;
	}
	public List<Classunit> getClassunit() {
		return classunit;
	}
	public void setClassunit(List<Classunit> classunit) {
		this.classunit = classunit;
	}
	
	@Override
	public String execute() throws Exception
	{
		try
		{
			classunit=classunitService.findAll();
		}
		catch(Exception e)
		{
			System.out.println("chucuole");
		}
		return SUCCESS;
	}
}
