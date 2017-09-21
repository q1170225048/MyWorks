package com.gkt.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.gkt.entity.*;

/**
 * A data access object (DAO) providing persistence and search support for Grade
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.gkt.entity.Grade
 * @author MyEclipse Persistence Tools
 */
public class GradeDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(GradeDAO.class);
	// property constants
	private SessionFactory sessionFactory1;
	private Session session;
	public static final String GRADE_GRADE = "gradeGrade";
	public static final String GRADE_COURSENUMBER = "course";

	 

	public void setSessionFactory1(SessionFactory sessionFactory1)
	{
		this.sessionFactory1 = sessionFactory1;
	}

	protected void initDao() {
		// do nothing
	}
	
	public  boolean findByGId(GradeId  id) 
	{
		    if(id!= null)
		    {
			Grade gun = findById(id);
			if(gun == null)
			{
				return  false;
			}
		    }
			return  true;    
	}

	public void save(Grade transientInstance) {
		log.debug("saving Grade instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Grade persistentInstance) {
		log.debug("deleting Grade instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public List<Grade> findByCourseClass(Course course,Classunit classno)
	{
		List<Grade> gradeList1 = null;
		List<Grade> gradeList2 = new ArrayList<Grade>();
		List<Student> student=null;
		
		try
		{
			
			
			gradeList1=findByCourse(course);
			StudentDAO studentDao=new StudentDAO();
			student= studentDao.findByProperty("Classunit", classno.getClassNumber());	
			
			for(Grade item1:gradeList1)
			{
				for(Student item2:student)
				{
					if(item1.getId().getGradeStudentnumber().equals(item2.getStudentNumber()))
					{
						gradeList2.add(item1);
					}
				}				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return gradeList2;
	}

	public Grade findById(com.gkt.entity.GradeId id) {
		log.debug("getting Grade instance with id: " + id);
		try {
			Grade instance = (Grade) getHibernateTemplate().get(
					"com.gkt.entity.Grade", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Grade> findByExample(Grade instance) {
		log.debug("finding Grade instance by example");
		try {
			List<Grade> results = (List<Grade>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
    
	//根据这个表中的某一项查询集合(根据课程编号查询成绩表)
	public List findByCourse(String Course, Object course) {
		log.debug("finding Grade instance with property: " + Course
				+ ", value: " + course);
		try {
			String queryString = "from Grade as model where model."
					+ Course + "= ?";
			return getHibernateTemplate().find(queryString,course);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	//根据这个表中的某一项查询集合(根据学生编号查询成绩表)
	public List findByStudent(String Student, Object student) {
		log.debug("finding Grade instance with property: " + Student
				+ ", value: " + student);
		try {
			String queryString = "from Grade as model where model."
					+ Student + "= ?";
			return getHibernateTemplate().find(queryString, student);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Grade instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Grade as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


	@SuppressWarnings("unchecked")
	public List<Grade> findByGradeGrade(Object gradeGrade) {
		return findByProperty(GRADE_GRADE, gradeGrade);
	}
	
	@SuppressWarnings("unchecked")
	public List<Grade> findByCourse(Course course) {
		return findByProperty(GRADE_COURSENUMBER, course);
	}

	public List<Grade> findAll() {
		log.debug("finding all Grade instances");
		try {
			String queryString = "from Grade";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Grade merge(Grade detachedInstance) {
		log.debug("merging Grade instance");
		try {
			Grade result = (Grade) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Grade instance) {
		log.debug("attaching dirty Grade instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Grade instance) {
		log.debug("attaching clean Grade instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static GradeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (GradeDAO) ctx.getBean("GradeDAO");
	}
}