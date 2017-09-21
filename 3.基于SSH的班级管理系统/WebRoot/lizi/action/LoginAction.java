package com.swz.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;
import com.swz.entity.Classes;
import com.swz.entity.Student;
import com.swz.service.LoginService;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction  extends  ActionSupport
{
		private static final long serialVersionUID = 1L;
		private Classes classes= new Classes();
	    private 	LoginService loginService;
	    private String    password;
	    private    HttpServletRequest request=ServletActionContext.getRequest();
	    private	  HttpSession session=request.getSession();
	    private Student  student;
	    private Student student2;
		private String    userName;
		public String Check()
		
		{
				session.setAttribute("username", userName);
				if(loginService.CheckLogin(userName,password))
				{
					session.setAttribute("loginreslut", "2");
					return SUCCESS;
				}
				else
				{
					session.setAttribute("loginreslut", "1");
					return ERROR;
				}
		}
	    public LoginService getLoginService() {
			return loginService;
		}
		public String getPassword() {
			return password;
		}
		public Student getStudent() {
			return student;
		}
		
		public Student getStudent2() {
			return student2;
		}
		
		public String getUserName() {
			return userName;
		}
		public  String InputStudent()
		{
			
			 String Flage=SUCCESS;
			 Integer cid=Integer.parseInt(request.getParameter("cid"));
			 try
			 {
				    classes=loginService.Findc(cid);
				 	student.setClasses(classes);
				 	loginService.SaveS(student);
			 } 
			 catch ( Exception e)
			 {
				 session.setAttribute("reslut", "1");
				 e.printStackTrace();
				 return  Flage;
			 }
			   session.setAttribute("reslut", "2");
			 return  Flage;
		}
		@Autowired
		public void setLoginService(LoginService loginService) {
			this.loginService = loginService;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public void setStudent(Student student) {
			this.student =student;
		}
	

	public void setStudent2(Student student2) {
		this.student2 = student2;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public  String   Showperson()
	{
		
		try
		{ 
			 String  unString=(String)session.getAttribute("username");
			student2= loginService.Finds(unString);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		String flageString=SUCCESS;
		return flageString;
	}
}
