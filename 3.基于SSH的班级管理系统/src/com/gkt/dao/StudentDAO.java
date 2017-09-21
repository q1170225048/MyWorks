package com.gkt.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gkt.entity.Student;

/**
 * A data access object (DAO) providing persistence and search support for
 * Student entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.gkt.entity.Student
 * @author MyEclipse Persistence Tools
 */
public class StudentDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(StudentDAO.class);
	// property constants
	public static final String STUDENT_NUMBER = "studentNumber";
	public static final String STUDENT_NAME = "studentName";
	public static final String STUDENT_GENDER = "studentGender";
	public static final String STUDENT_BIRTH = "studentBirth";
	public static final String STUDENT_PASSWORD = "studentPassword";
	public static final String STUDENT_PHONE = "studentPhone";
	public static final String STUDENT_ADDRESS = "studentAddress";

	protected void initDao() {
		// do nothing
	}
	
	public  boolean CheckLogin(String  username,String password) 
	{
		if(username!=null)
		{
			List<Student> list=this.findByStudentNumber(username);
			if(list.size()>0)
			{
				for (Student student : list) {
					if(student.getStudentPassword().equals(password))
					{
						return true;
					}
				}
			}
		}
		return  false;
	}
	
	public  boolean checkStudentnumber(String studentnumber)
	{
		if(studentnumber!=null)
		{
			Student sun = findById(studentnumber);
			if(sun == null)
			{
				return false;
			}
		}
		return true;
	}

	public void save(Student transientInstance) {
		log.debug("saving Student instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Student persistentInstance) {
		log.debug("deleting Student instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Student findById(java.lang.String id) {
		log.debug("getting Student instance with id: " + id);
		try {
			System.out.println("1");
			Student instance = (Student) getHibernateTemplate().get(
					"com.gkt.entity.Student", id);
			System.out.println("2");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Student> findByExample(Student instance) {
		log.debug("finding Student instance by example");
		try {
			List<Student> results = (List<Student>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> findByClass(String Classunit, Object classunit) {
		log.debug("finding Student instance with property: " + Classunit
				+ ", value: " + classunit);
		try {
			String queryString = "from Student as model where model."
					+ Classunit + "= ?";
			return getHibernateTemplate().find(queryString, classunit);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Student> findByProperty(String propertyName, Object value) {
		log.debug("finding Student instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Student as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List<Student> findByStudentNumber(Object studentNumber) {
		return findByProperty(STUDENT_NUMBER, studentNumber);
	}

	public List<Student> findByStudentName(Object studentName) {
		return findByProperty(STUDENT_NAME, studentName);
	}

	public List<Student> findByStudentGender(Object studentGender) {
		return findByProperty(STUDENT_GENDER, studentGender);
	}

	public List<Student> findByStudentBirth(Object studentBirth) {
		return findByProperty(STUDENT_BIRTH, studentBirth);
	}

	public List<Student> findByStudentPassword(Object studentPassword) {
		return findByProperty(STUDENT_PASSWORD, studentPassword);
	}

	public List<Student> findByStudentPhone(Object studentPhone) {
		return findByProperty(STUDENT_PHONE, studentPhone);
	}

	public List<Student> findByStudentAddress(Object studentAddress) {
		return findByProperty(STUDENT_ADDRESS, studentAddress);
	}

	public List findAll() {
		log.debug("finding all Student instances");
		try {
			System.out.println("3");
			String queryString = "from Student";
			System.out.println("4");
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Student merge(Student detachedInstance) {
		log.debug("merging Student instance");
		try {
			Student result = (Student) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Student instance) {
		log.debug("attaching dirty Student instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Student instance) {
		log.debug("attaching clean Student instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StudentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StudentDAO) ctx.getBean("StudentDAO");
	}
}