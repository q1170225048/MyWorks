package com.swz.tests;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.swz.dao.StudentDAO;
import com.swz.entity.Student;

public class Test 
{
	@org.junit.Test
	public void tests()
	{
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("applicationContext.xml");
//	    	   System.out.println(beanFactory.getBean("sessionFactory"));
//			   System.out.println(beanFactory.getBean("scorDAO"));
//		       System.out.println(beanFactory.getBean("studentDAO"));
//				System.out.println(beanFactory.getBean("student"));	
//		       	System.out.println(beanFactory.getBean("courseAction"));
					System.out.println(beanFactory.getBean("banjiAction"));
	}
}
