package com.swz.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.swz.entity.Classes;

/**
 * A data access object (DAO) providing persistence and search support for
 * Classes entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.swz.entity.Classes
 * @author MyEclipse Persistence Tools
 */
@Component
public class ClassesDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(ClassesDAO.class);
	// property constants
	public static final String BJNAME = "bjname";

	protected void initDao() {
		// do nothing
	}

	public void save(Classes transientInstance) {
		log.debug("saving Classes instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Classes persistentInstance) {
		log.debug("deleting Classes instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Classes findById(java.lang.Integer id) {
		log.debug("getting Classes instance with id: " + id);
		try {
			Classes instance = (Classes) getHibernateTemplate().get(
					"com.swz.entity.Classes", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Classes> findByExample(Classes instance) {
		log.debug("finding Classes instance by example");
		try {
			List<Classes> results = (List<Classes>) getHibernateTemplate()
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
		log.debug("finding Classes instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Classes as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Classes> findByBjname(Object bjname) {
		return findByProperty(BJNAME, bjname);
	}

	public List findAll() {
		log.debug("finding all Classes instances");
		try {
			String queryString = "from Classes";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Classes merge(Classes detachedInstance) {
		log.debug("merging Classes instance");
		try {
			Classes result = (Classes) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Classes instance) {
		log.debug("attaching dirty Classes instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Classes instance) {
		log.debug("attaching clean Classes instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ClassesDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ClassesDAO) ctx.getBean("ClassesDAO");
	}
}