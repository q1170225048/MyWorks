package com.swz.action;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;
import com.swz.entity.Kc;
import com.swz.entity.Scor;
import com.swz.entity.ScorId;
import com.swz.entity.Student;
import com.swz.service.CourseService;
import com.swz.service.ScorService;
import com.swz.service.StudentService;
import com.swz.tests.IDSC;

@Controller("scorAction")
@Scope("prototype")
public class ScorAction extends ActionSupport
{
		private static final long serialVersionUID = 1L;
		private CourseService courseService;
		private Kc kc;
		private    HttpServletRequest request=ServletActionContext.getRequest();
		private Scor scor;
		private ScorService scorService;
		private StudentService service;
		private	  HttpSession session=request.getSession();
		private Student student;
		private List<Student> studentlist;
		private List<Kc> kclist;
		private List<Scor> scorlist;
		private String sids,kcids,scorsString;
		public String AddScor()
		{
			try 
			{
				
				if(student.getSid()!=null&&kc.getKcid()!=null)
				{
				     Student	students=service.FindById(student.getSid());
				     System.out.println("保存分数函数搜到的students"+students.getSname());
				     Kc	kcs=courseService.FindCourseById(kc.getKcid());
				     System.out.println("scor.getscor()"+scor.getScor());
				     System.out.println("保存分数函数搜到的course"+kcs.getKcname());
				     if(students!=null&&kcs!=null)
				     {
				    	 	 ScorId scorId=new ScorId();
						     scorId.setKcid(kc.getKcid());
						     scorId.setSid(student.getSid());
						    scor.setId(scorId);
							scor.setKc(kcs);
							scor.setStudent(students);
							scor.setScor(scor.getScor());
						   	studentlist=service.FindAllStudent();
						    kclist=courseService.FindAllCourse();
				      		String rString=scorService.AddScor(scor);
				      	    session.setAttribute("ReslutOfScor", rString);
				     }
				}
			} catch (Exception e)
			{
				  session.setAttribute("ReslutOfScor", "AddError");
			}
			return SUCCESS;
		}

		public String ChangeScor()
		{
			String sidString=request.getParameter("sids");
			
			String kcidString=request.getParameter("kcids");
			
			String scorString=request.getParameter("scorss");
			System.out.println("分数  ："+scorsString);
			System.out.println("sid"+sidString);
			System.out.println("kcid"+kcidString);
			if(sids!=null&&kcids!=null)
			{
				Integer sidInteger = null;
				Integer kcidInteger = null;
				double scorInteger = 0;
				try {
					sidInteger = Integer.parseInt(sidString);
					kcidInteger = Integer.parseInt(kcidString);
					scorInteger = Double.parseDouble(scorString);
					if(scorInteger<0||scorInteger>100)
					{
						session.setAttribute("ReslutOfScor", "ScorError");
						return SUCCESS;
					}
				} catch (NumberFormatException e)
				{
					session.setAttribute("ReslutOfScor", "NotInteger");
					return SUCCESS;
				}
				ScorId scorId=new ScorId();
				scorId.setKcid(kcidInteger);
				scorId.setSid(sidInteger);
				Scor 	scor2=scorService.FindById(scorId);
				scor2.setScor(scorInteger);
				scorService.AddScor(scor2);
				scorlist=scorService.FindAllScor();
				session.setAttribute("ReslutOfScor", "UpdateSuccess");
			}
			return SUCCESS;
		}

		public String TjScorBySid()
		{
			String idString=request.getParameter("id");
			System.out.println("获取到的IDString是："+idString);
			if(idString!=null)
			{
			    student=service.FindById(Integer.parseInt(idString));
				scorlist=scorService.FindByStudent(student);
				scorlist=IDSC.sortparam(scorlist);
				double avg=IDSC.avrscor(scorlist);
				session.setAttribute("avg", avg);
			}
			return SUCCESS;
		}
		public String DelScor()
		{
			try
			{
				String sidString=request.getParameter("sid");
				String kcidString=request.getParameter("kcid");
				System.out.println("传过来的sid"+sidString);
				System.out.println("传过来的kcid"+kcidString);
				if(sidString!=null&kcidString!=null)
				{
					Integer sidInteger=Integer.parseInt(sidString);
					Integer kcidInteger=Integer.parseInt(kcidString);
					ScorId scorId=new ScorId();
					scorId.setKcid(kcidInteger);
					scorId.setSid(sidInteger);
					scor=scorService.FindById(scorId);
					scorService.DelScor(scor);
					scorlist=scorService.FindAllScor();//删完了以后再查一下保证值栈有值
					session.setAttribute("ReslutOfScor", "DelSuccess");
				}
			} catch (Exception e)
			{
				System.err.println("删除时出现了错误：");
				session.setAttribute("ReslutOfScor", "DelError");
				e.printStackTrace();
			}
			return SUCCESS;
		}

		public String FindStudentAndKc()
		{
			try
			{
				studentlist=service.FindAllStudent();
				kclist=courseService.FindAllCourse();
				scorlist=scorService.FindAllScor();
			} catch (Exception e) 
			{
				System.out.println("查询学生和课程的时候出现了错误");
				e.printStackTrace();
			}
			return SUCCESS;
		}

		public CourseService getCourseService() {
			return courseService;
		}

		public Kc getKc() {
			return kc;
		}

		public String getKcids() {
			return kcids;
		}

		public List<Kc> getKclist() {
			return kclist;
		}

		public Scor getScor() {
			return scor;
		}

		public List<Scor> getScorlist() {
			return scorlist;
		}
		public ScorService getScorService() {
			return scorService;
		}

		public String getScorsString() {
			return scorsString;
		}
		public StudentService getService() {
			return service;
		}

		public String getSids() {
			return sids;
		}

		public Student getStudent() {
			return student;
		}
		
		public List<Student> getStudentlist() {
			return studentlist;
		}
		
		
		
		@Autowired
		public void setCourseService(CourseService courseService) {
			this.courseService = courseService;
		}
		public void setKc(Kc kc) {
			this.kc = kc;
		}
		public void setKcids(String kcids) {
			this.kcids = kcids;
		}
		public void setKclist(List<Kc> kclist) {
			this.kclist = kclist;
		}
		public void setScor(Scor scor) {
			this.scor = scor;
		}
		public void setScorlist(List<Scor> scorlist) {
			this.scorlist = scorlist;
		}
		@Autowired
		public void setScorService(ScorService scorService) {
			this.scorService = scorService;
		}
		public void setScorsString(String scorsString) {
			this.scorsString = scorsString;
		}
		@Autowired
		public void setService(StudentService service) {
			this.service = service;
		}
		public void setSids(String sids) {
			this.sids = sids;
		}
		public void setStudent(Student student) {
			this.student = student;
		}
		public void setStudentlist(List<Student> studentlist) {
			this.studentlist = studentlist;
		}

}
