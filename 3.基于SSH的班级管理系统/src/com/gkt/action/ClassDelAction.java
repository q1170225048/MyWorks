package com.gkt.action;

import java.util.List;

import com.gkt.entity.Classunit;
import com.gkt.service.ClassunitService;
import com.opensymphony.xwork2.ActionSupport;

public class ClassDelAction extends ActionSupport{
	//变量
	private String classunitname = "";
    private String classunitnumber = "";
    private ClassunitService classunitService;
    private Classunit classnumber;
    private List<Classunit> classunit;
    
    //函数
	public String getClassunitname() {
		return classunitname;
	}
	public void setClassunitname(String classunitname) {
		this.classunitname = classunitname;
	}
	public String getClassunitnumber() {
		return classunitnumber;
	}
	public void setClassunitnumber(String classunitnumber) {
		this.classunitnumber = classunitnumber;
	}
	public ClassunitService getClassunitService() {
		return classunitService;
	}
	public void setClassunitService(ClassunitService classunitService) {
		this.classunitService = classunitService;
	}
	public Classunit getClassnumber() {
		return classnumber;
	}
	public void setClassnumber(Classunit classnumber) {
		this.classnumber = classnumber;
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
			classnumber=classunitService.findclassunitnumber(getClassunitnumber());
			classunitService.delClassunit(classnumber);
			classunit=classunitService.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return SUCCESS;
    }
}
