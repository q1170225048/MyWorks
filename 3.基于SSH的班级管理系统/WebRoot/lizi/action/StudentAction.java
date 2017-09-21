package com.swz.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.taglibs.standard.tag.el.core.OutTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mysql.fabric.Response;
import com.opensymphony.xwork2.ActionSupport;
import com.swz.entity.Student;
import com.swz.service.StudentService;

@Controller("studentAction")
@Scope("prototype") 
public class StudentAction  extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private    HttpServletRequest request=ServletActionContext.getRequest();
	private	  HttpSession session=request.getSession();
	private HttpServletResponse response=ServletActionContext.getResponse();
	private    StudentService  studentService;
	private  List<Student> list;
	private  Student studentperson;
	private Student studentdel=new Student();
	public String FindAllStudent()
	{
		try 
		{
			 list=studentService.FindAllStudent();
			 if(list.size()==0)
			 {
				 session.setAttribute("findreslut", "无信息");
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  SUCCESS;
	}
	public String   FindStById()
	{
		 try 
		 {
			 String  idxString=request.getParameter("id").trim();
			 System.out.println("查找学生传值：StudentAction"+idxString);
			Integer id=Integer.parseInt(idxString);
		    studentperson=studentService.FindById(id);
		  } catch (NumberFormatException e) 
		  {
			e.printStackTrace();
		  }
		return SUCCESS;
	}
	
	public String DelStudent()
	{
		 String  idxString=request.getParameter("mark");
		 System.out.println("删除学生传值：StudentAction   "+idxString);
		 if(idxString!=null)
		 {
				 Integer id=Integer.parseInt(idxString);
			    	studentdel= studentService.FindById(id);
				if(studentdel!=null)
				{
					studentService.DelStudent(studentdel);
				}
				else 
				{
			               try {
							PrintWriter out = response.getWriter();
							out.append("没有可删除的信息了");
						} catch (IOException e) {
							e.printStackTrace();
						}
				}
				list=studentService.FindAllStudent();
		}
		 
		 return SUCCESS;
	}
	public List<Student> getList()
	{
		return list;
	}
	public Student getStudentperson() {
		return studentperson;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
	public void setStudentperson(Student studentperson) {
		this.studentperson = studentperson;
	}
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
}
