package com.gkt.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gkt.entity.Classunit;
import com.gkt.entity.Student;

/**
 * A data access object (DAO) providing persistence and search support for
 * Classunit entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.gkt.entity.Classunit
 * @author MyEclipse Persistence Tools
 */
public class ClassunitDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(ClassunitDAO.class);
	private SessionFactory sessionFactory;
	private Session session;
	// property constants
	public static final String CLASS_NAME = "className";

	protected void initDao() {
		// do nothing
	}
	
	public  boolean checkClassnumber(String  classunitnumber) 
	{
		    if(classunitnumber!= null)
		    {
			Classunit cun = findById(classunitnumber);
			if(cun == null)
			{
				return  false;
			}
		    }
			return  true;    
	}
	
	public Classunit findclassunitnumber(String classunitnumber)
	{
		System.out.println("2");
		if(classunitnumber!=null)
		{
			System.out.println("3");
			return findById(classunitnumber);
		}
		return null;
		
	}

	public void save(Classunit transientInstance) {
		log.debug("saving Classunit instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Classunit persistentInstance) {
		log.debug("deleting Classunit instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Classunit findById(java.lang.String id) {
		log.debug("getting Classunit instance with id: " + id);
		try {
			Classunit instance = (Classunit) getHibernateTemplate().get(
					"com.gkt.entity.Classunit", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Classunit> findByExample(Classunit instance) {
		log.debug("finding Classunit instance by example");
		try {
			List<Classunit> results = (List<Classunit>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Classunit instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Classunit as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Classunit> findByClassName(Object className) {
		return findByProperty(CLASS_NAME, className);
	}

	public List<Classunit> findAll() {
		log.debug("finding all Classunit instances");
		try {
			String queryString = "from Classunit";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Classunit merge(Classunit detachedInstance) {
		log.debug("merging Classunit instance");
		try {
			Classunit result = (Classunit) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Classunit instance) {
		log.debug("attaching dirty Classunit instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Classunit instance) {
		log.debug("attaching clean Classunit instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ClassunitDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ClassunitDAO) ctx.getBean("ClassunitDAO");
	}
}