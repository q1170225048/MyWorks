package com.fengxing.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.fengxing.entity.UserInformation;
import com.fengxing.entity.UserInformationDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;




@SuppressWarnings("serial")
public class Login extends ActionSupport implements ModelDriven<UserInformation>
{
	private UserInformationDAO dao =new UserInformationDAO();
	private UserInformation user=new UserInformation();
    public UserInformation getModel(){
    	
        return user;
    }
    public String login(){
    	System.out.println(user.getUsernamae());
        org.hibernate.Transaction tra=dao.getSession().beginTransaction();
        System.out.println("开启事务");
        	UserInformation existUser=(UserInformation)dao.findByExample(user).get(0);
        	tra.commit();
        	dao.getSession().flush();
        	dao.getSession().close();
        	 if(existUser==null){
                 //登陆失败
        		 System.out.println("失败");
             	HttpServletRequest request = ServletActionContext.getRequest(); 
             	request.setAttribute("tipMessage","登陆失败：用户名或密码错误用户未激活！");
                 return LOGIN;
             }
        	 else 
        	 {
                 //登陆成功
                 //将用户的信息存入session中
            	 System.out.println("成功");
                 ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
                 
                 //页面跳转
                 return "loginSuccess";
             }
        
      
        
       

    }
}
