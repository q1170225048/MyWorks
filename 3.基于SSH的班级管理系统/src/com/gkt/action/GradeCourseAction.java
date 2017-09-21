package com.gkt.action;

import java.util.List;

import com.gkt.service.ClassunitService;
import com.gkt.service.CourseService;
import com.gkt.service.GradeService;
import com.gkt.service.StudentService;
import com.gkt.entity.*;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class GradeCourseAction extends ActionSupport
{
	// 变量 *********************************************************************
		private int max1=0,min1=0,avge=0,studentNum=0;;
		
		private String MAX;
		private String MIN;
		private String AVGE;
		
		private String classNum;
		private String courseNum;
		
		private String classStr;
		private String courseStr;
		
		private GradeId gradeId;
		private Grade grades;
		
		private GradeService gradeService;	
		private List<Grade> grade;
		
		private ClassunitService classService;	
		private List<com.gkt.entity.Classunit> classno;
		
		private CourseService courseService;
		private List<Course> course;
		
		private StudentService studentService;
		private List<Student> student;
		
		// 函数 *********************************************************************
		public int getStudentNum()
		{
			return studentNum;
		}
		public void setStudentNum(int studentNum)
		{
			this.studentNum = studentNum;
		}
		public int getMax1()
		{
			return max1;
		}
		public void setMax1(int max1)
		{
			this.max1 = max1;
		}
		public int getMin1()
		{
			return min1;
		}
		public void setMin1(int min1)
		{
			this.min1 = min1;
		}
		public int getAvge()
		{
			return avge;
		}
		public void setAvge(int avge)
		{
			this.avge = avge;
		}
		public String getMAX()
		{
			return MAX;
		}
		public void setMAX(String mAX)
		{
			MAX = mAX;
		}
		public String getMIN()
		{
			return MIN;
		}
		public void setMIN(String mIN)
		{
			MIN = mIN;
		}
		public String getAVGE()
		{
			return AVGE;
		}
		public void setAVGE(String aVGE)
		{
			AVGE = aVGE;
		}
		public String getClassNum()
		{
			return classNum;
		}
		public void setClassNum(String classNum)
		{
			this.classNum = classNum;
		}
		public String getCourseNum()
		{
			return courseNum;
		}
		public void setCourseNum(String courseNum)
		{
			this.courseNum = courseNum;
		}		
		public String getClassStr()
		{
			return classStr;
		}
		public void setClassStr(String classStr)
		{
			this.classStr = classStr;
		}
		public String getCourseStr()
		{
			return courseStr;
		}
		public void setCourseStr(String courseStr)
		{
			this.courseStr = courseStr;
		}
		public GradeId getGradeId()
		{
			return gradeId;
		}
		public void setGradeId(GradeId gradeId)
		{
			this.gradeId = gradeId;
		}
		public Grade getGrades()
		{
			return grades;
		}
		public void setGrades(Grade grades)
		{
			this.grades = grades;
		}
		public GradeService getGradeService()
		{
			return gradeService;
		}
		public void setGradeService(GradeService gradeService)
		{
			this.gradeService = gradeService;
		}
		public List<Grade> getGrade()
		{
			return grade;
		}
		public void setGrade(List<Grade> grade)
		{
			this.grade = grade;
		}
		public ClassunitService getClassService()
		{
			return classService;
		}
		public void setClassService(ClassunitService classService)
		{
			this.classService = classService;
		}
		public List<com.gkt.entity.Classunit> getClassno()
		{
			return classno;
		}
		public void setClassno(List<com.gkt.entity.Classunit> classno)
		{
			this.classno = classno;
		}
		public CourseService getCourseService()
		{
			return courseService;
		}
		public void setCourseService(CourseService courseService)
		{
			this.courseService = courseService;
		}
		public List<Course> getCourse()
		{
			return course;
		}
		public void setCourse(List<Course> course)
		{
			this.course = course;
		}
		public StudentService getStudentService()
		{
			return studentService;
		}
		public void setStudentService(StudentService studentService)
		{
			this.studentService = studentService;
		}
		public List<Student> getStudent()
		{
			return student;
		}
		public void setStudent(List<Student> student)
		{
			this.student = student;
		}
		@Override
		public String execute() throws Exception
		{
			System.out.println("Count_course_grade的exceute方法执行");
			try
			{
				classNum="全部";
				courseNum="全部";
				classStr="全部";
				courseStr="全部";
				
				gradeId=new GradeId();
				grades=new Grade();
				
				classno=classService.findAll();
				course=courseService.findAll();
				student=studentService.findAll();
				
				for(Student item1:student)
			    {
					for(Course item2:course)
				    {
						gradeId.setGradeStudentnumber(item1.getStudentNumber());
						gradeId.setGradeCoursenumber(item2.getCourseNumber());				
						grades.setId(gradeId);
						
						if(!gradeService.findById(gradeId))
						{
							gradeService.Save(grades);
						}					
				    }         	  	
			    }
				grade=gradeService.findAll();
					
				max1=0;min1=0;avge=0;studentNum=0;
				
				for(Grade item:grade)
				{
					if(item.getGradeGrade()!=null)
					{
						max1=item.getGradeGrade();
						min1=item.getGradeGrade();
						break;
					}
				}		
				
				for(Grade item:grade)
				{
					if(item.getGradeGrade()!=null)
					{
						studentNum++;
						if(item.getGradeGrade()>max1)
						{
							max1=item.getGradeGrade();
						}
						if(item.getGradeGrade()<min1)
						{
							min1=item.getGradeGrade();
						}
						avge=avge+item.getGradeGrade();
					}
				}
				MAX=String.valueOf(max1);
				MIN=String.valueOf(min1);
				
				if(studentNum!=0)
				{
					double a=avge;
					double b=studentNum;
					double av=(double)(a/b);
					AVGE=String.valueOf(av);
				}
				else
				{
					AVGE="0";
				}
				System.out.println(max1+"-"+min1+"-"+avge+"-"+studentNum);
				System.out.println(MAX+"-"+MIN+"-"+AVGE);
			}
			catch(Exception e)
			{
				System.out.println("出错了");
			}
			return SUCCESS;
		}
}
