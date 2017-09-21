package com.swz.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.swz.entity.Classes;
import com.swz.service.ClassesService;

@Controller("banjiAction")
@Scope("prototype") 
public class BanjiAction  extends ActionSupport
{
	private static final long serialVersionUID = 1L; 
	private    Classes classes;
	private  Classes classes2=new Classes();
	private    List<Classes> listclasses;
	private  List <Classes> list ;
	private    ClassesService classesService;
	private    HttpServletRequest request=ServletActionContext.getRequest();
	private	  HttpSession session=request.getSession();
	public String AddCl()
	{
		try
		{
			classesService.AddCla(getClasses());
		}
		catch (Exception e) 
		{
			session.setAttribute("addc", "失败");
			return SUCCESS;
		}
		session.setAttribute("addc", "成功");
		return SUCCESS;
	}
	public String ShowClass()
	{
		try 
		{
			listclasses=classesService.FindAllC();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return SUCCESS;
	}
    public Classes getClasses() {
		return classes;
	}
    
    public String DelClass()
    {
    	String  CID=request.getParameter("mark");
    	System.out.println("在BanJiAction类中传过来的参数是："+CID);
    	Integer idInteger=Integer.parseInt(CID);
    	classes2=classesService.FindById(idInteger);
    	if(classesService.DelClass(classes2))
    	{
    			session.setAttribute("delclassmark", "success");
    	}
    	else
    	{
    			session.setAttribute("delclassmark", "failed");
		}
    	listclasses=classesService.FindAllC();
    	return SUCCESS;
    }
    
    
    public void  FindClass()
    {
    	HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        JSONObject json = new JSONObject();
        list=classesService.FindAllC();
        System.out.println("ajax查找到的数据条数"+list.size());
        for(int i=0;i<list.size();i++)
        {
        	json.put("classname", listclasses.get(i).getBjname());
        	json.put("classid", listclasses.get(i).getBjid());
        }
        try {
	            response.getWriter().print(json.toString());
	            response.getWriter().close();
        	}
        catch (IOException e) 
        {
        	e.printStackTrace();
        }
    }
    
    
    
	public ClassesService getClassesService() {
		return classesService;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	@Autowired
	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}
	public List<Classes> getListclasses() {
		return listclasses;
	}
	public void setListclasses(List<Classes> listclasses) {
		this.listclasses = listclasses;
	}

}
