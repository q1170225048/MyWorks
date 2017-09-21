package com.swz.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.swz.entity.Kc;
import com.swz.service.CourseService;

@Controller("courseAction")
@Scope("prototype") 
public class CourseAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private    HttpServletRequest   request=ServletActionContext.getRequest();
	private	  HttpSession session=request.getSession();		
	private    CourseService courseService;
	private    Kc kc;
	private    Kc kc2= new Kc();
	private   List <Kc> listKcs;
	
	public String AddCourse()
	{
		try 
		{
			courseService.AddCourse(kc);
			session.setAttribute("ReslutOfCourse", "AddSuccess");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			session.setAttribute("ReslutOfCourse", "AddError");
		}
		return SUCCESS;
	}

	public  String FindAllCourse()
	{
		try
		{
			listKcs=courseService.FindAllCourse();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			session.setAttribute("ReslutOfCourse", "FindAllError");
		}
		return SUCCESS;
	}
	
	public String DelCourse()
	{
		String idString=request.getParameter("mark");
		Integer idInteger=Integer.parseInt(idString);
		kc2=courseService.FindCourseById(idInteger);
		try 
		{
			courseService.DelCourse(kc2);
			listKcs=courseService.FindAllCourse();
			session.setAttribute("ReslutOfCourse", "DelSuccess");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			session.setAttribute("ReslutOfCourse", "DelError");
		}
		return SUCCESS;
	}
	
	public CourseService getCourseService() {
		return courseService;
	}
 
	public Kc getKc() {
		return kc;
	}
	public List<Kc> getListKcs() {
		return listKcs;
	}
	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public void setKc(Kc kc) {
		this.kc = kc;
	}
	
	public void setListKcs(List<Kc> listKcs) {
		this.listKcs = listKcs;
	}

	public String UpdateCourse()
	{
		try 
		{
			Integer idInteger=Integer.parseInt(request.getParameter("mark"));
			kc=courseService.FindCourseById(idInteger);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
			return SUCCESS;
	}
	public String Update()
	{
		try 
		{
			  Kc kcs=new Kc();
			  System.out.println("返回的ID"+kc.getKcid());
			  kcs=courseService.FindCourseById(kc.getKcid());
			  kcs.setKcname(kc.getKcname());
			  kcs.setKcxz(kc.getKcxz());
			 courseService.AddCourse(kcs);
			 listKcs=courseService.FindAllCourse();
			 session.setAttribute("ReslutOfCourse", "UpSuccess"); 
		} catch (Exception e) {
			e.printStackTrace();
			 session.setAttribute("ReslutOfCourse", "UpError"); 
		}
		return SUCCESS;
	}
}
