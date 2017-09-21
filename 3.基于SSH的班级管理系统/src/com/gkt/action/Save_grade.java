package com.gkt.action;


import com.gkt.service.*;
import com.gkt.entity.*;

import com.opensymphony.xwork2.ActionSupport;

public class Save_grade extends ActionSupport
{
	private String no;
	private String name;
	private int grade;
	private String result;
	private ClassunitService classService;	
	private CourseService courseService;
	private GradeService gradeService;
	private StudentService studentService;
	private Course course;
	private Classunit classno;
	private Student student;
	
	public StudentService getStudentService()
	{
		return studentService;
	}

	public void setStudentService(StudentService studentService)
	{
		this.studentService = studentService;
	}

	public Course getCourse()
	{
		return course;
	}

	public void setCourse(Course course)
	{
		this.course = course;
	}

	public Classunit getClassno()
	{
		return classno;
	}

	public void setClassno(Classunit classno)
	{
		this.classno = classno;
	}

	public Student getStudent()
	{
		return student;
	}

	public void setStudent(Student student)
	{
		this.student = student;
	}

	@Override
	public String execute() throws Exception
	{
		System.out.println("执行Save_grade的execute的方法");
		System.out.println(getNo()+getName()+getGrade());
		
		try
		{
			course=(Course)courseService.findByno(getName());
			student=(Student)studentService.findstudentnumber(no.toString());
			
			if(course==null||student==null)
			{
				result="失败";
			}
			else
			{				
				GradeId id=new GradeId(student.getStudentNumber(),course.getCourseNumber());
				Grade gra=new Grade(id, course, student, grade);
				gradeService.update(gra);
				
			}
		}
		catch(Exception e)
		{
			result="失败";
		}
		
		result="成功";
		
		return SUCCESS;
	}

	public String getNo()
	{
		return no;
	}

	public void setNo(String no)
	{
		this.no = no;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getGrade()
	{
		return grade;
	}

	public void setGrade(int grade)
	{
		this.grade = grade;
	}

	public String getResult()
	{
		return result;
	}

	public void setResult(String result)
	{
		this.result = result;
	}
	public ClassunitService getClassService()
	{
		return classService;
	}

	public void setClassService(ClassunitService classService)
	{
		this.classService = classService;
	}
	public GradeService getGradeService()
	{
		return gradeService;
	}

	public void setGradeService(GradeService gradeService)
	{
		this.gradeService = gradeService;
	}

	public CourseService getCourseService()
	{
		return courseService;
	}

	public void setCourseService(CourseService courseService)
	{
		this.courseService = courseService;
	}
}
