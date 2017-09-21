package com.gkt.action;

import java.util.ArrayList;
import java.util.List;

import com.gkt.entity.Classunit;
import com.gkt.entity.Count_course;
import com.gkt.entity.Count_grade;
import com.gkt.entity.Course;
import com.gkt.entity.Grade;
import com.gkt.entity.Student;
import com.gkt.service.ClassunitService;
import com.gkt.service.CourseService;
import com.gkt.service.GradeService;
import com.gkt.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

public class GradeQueryAction extends ActionSupport{
    //变量
	private List<Count_grade> count_grade;
	private List<Count_course> count_course;
	
	private StudentService studentService;
	private List<Student> studentex;
	
	private CourseService courseService;
	private List<Course> courseex;
	
	private GradeService gradeService;
	private List<Grade> gradeex;
	
	private ClassunitService classunitService;
	private List<Classunit> classunitex;
	
	public List<Count_grade> getCount_grade() {
		return count_grade;
	}

	public void setCount_grade(List<Count_grade> count_grade) {
		this.count_grade = count_grade;
	}

	public List<Count_course> getCount_course() {
		return count_course;
	}

	public void setCount_course(List<Count_course> count_course) {
		this.count_course = count_course;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public List<Student> getStudentex() {
		return studentex;
	}

	public void setStudentex(List<Student> studentex) {
		this.studentex = studentex;
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public List<Course> getCourseex() {
		return courseex;
	}

	public void setCourseex(List<Course> courseex) {
		this.courseex = courseex;
	}

	public GradeService getGradeService() {
		return gradeService;
	}

	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}

	public List<Grade> getGradeex() {
		return gradeex;
	}

	public void setGradeex(List<Grade> gradeex) {
		this.gradeex = gradeex;
	}

	public ClassunitService getClassunitService() {
		return classunitService;
	}

	public void setClassunitService(ClassunitService classunitService) {
		this.classunitService = classunitService;
	}

	public List<Classunit> getClassunitex() {
		return classunitex;
	}

	public void setClassunitex(List<Classunit> classunitex) {
		this.classunitex = classunitex;
	}

	public String execute() throws Exception
	{
//		try
//		{
			count_grade=new ArrayList<Count_grade>();
			count_course=new ArrayList<Count_course>();
			
			studentex = studentService.findAll();
			gradeex = gradeService.findAll();
			courseex = courseService.findAll();
			
			for(Course item2:courseex)
			{
				Count_course countcourse=new Count_course();
				
				countcourse.setCourseNumber(item2.getCourseNumber());
				countcourse.setCourseName(item2.getCourseName());
				countcourse.setCourseType(item2.getCourseType());
				countcourse.setCourseGrade(item2.getCourseGrade());
				
				count_course.add(countcourse);
				
				System.out.println("成绩长度"+count_course.size());
			}
			
			for(Student item1:studentex)
			{
				Count_grade countgrade=new Count_grade();
				
				countgrade.setStudentNumber(item1.getStudentNumber());
				countgrade.setStudentName(item1.getStudentName());
				countgrade.setClassunit(item1.getClassunit());
				
				List<Count_course> count_course_list=new ArrayList<Count_course>();
				double count = 0;
				
				for(Course item2:courseex)
				{
					Count_course countcourse=new Count_course();
					
					countcourse.setCourseNumber(item2.getCourseNumber());
					countcourse.setCourseName(item2.getCourseName());
					countcourse.setCourseType(item2.getCourseType());
					countcourse.setCourseGrade(item2.getCourseGrade());
					
					for(Grade item3:gradeex)
					{
						if(item3.getId().getGradeStudentnumber().equals(item1.getStudentNumber()) &&  item3.getId().getGradeCoursenumber().equals(item2.getCourseNumber()))
						{
							if(item3.getGradeGrade()!=null)
							{
								countcourse.setGrades(item3.getGradeGrade().toString());
								if(item3.getGradeGrade()>=60)
								{
									System.out.println("成绩："+countcourse.getCourseGrade());
									count=count+Double.parseDouble(item2.getCourseGrade());
								}
							}
							break;
						}
					}
					count_course_list.add(countcourse);	
				}
				
				countgrade.setCount_course(count_course_list);
				countgrade.setCount(String.valueOf(count));
				
				count_grade.add(countgrade);
			}
			System.out.println("总列表长度："+count_grade.size());
//		}
//		catch(Exception e)
//		{
//			System.out.println("出错了");
//		}
		
		return SUCCESS;
	}
}
