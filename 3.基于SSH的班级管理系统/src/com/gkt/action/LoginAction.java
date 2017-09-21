package com.gkt.action;

import com.gkt.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
    
	//变量
	private String usernumber = "";
	private String password = "";
	private String result="";
	private LoginService loginService;
	
	//函数
	public String getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	//执行
	@Override
	public String execute() throws Exception
	{
		if(loginService.LoginCheck(getUsernumber(),getPassword()))
		{
			result="成功";
			return SUCCESS;
		}
		else
		{
			result="失败";
			return ERROR;
		}
		
	}
	
}
