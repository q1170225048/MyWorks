package com.gkt.action;

import com.gkt.entity.Classunit;
import com.gkt.service.ClassunitService;
import com.opensymphony.xwork2.ActionSupport;

public class ClassAddAction extends ActionSupport{
	//变量
    private String classunitname = "";
    private String classunitnumber = "";
    private String result = "";
    private ClassunitService classunitService;
    private Classunit classnumber;
    
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public ClassunitService getClassunitService() {
		return classunitService;
	}
	public void setClassunitService(ClassunitService classunitService) {
		this.classunitService = classunitService;
	}
	
	@Override
	public String execute() throws Exception
	{
		if(classunitService.checkClassnumber(getClassunitnumber()))
		{
			//result = "班级编号重复!";
			return ERROR;
		}
		else
		{
			classnumber = new Classunit();
			classnumber.setClassNumber(classunitnumber);
			classnumber.setClassName(classunitname);
			classunitService.addClassunit(classnumber);
		}
		return SUCCESS;
	}
    
}
