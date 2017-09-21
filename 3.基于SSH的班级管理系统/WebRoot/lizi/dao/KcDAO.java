package com.swz.dao;

import java.util.List;
import java.util.Set;

import javax.jms.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.swz.entity.Kc;

/**
 * A data access object (DAO) providing persistence and search support for Kc
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.swz.entity.Kc
 * @author MyEclipse Persistence Tools
 */
@Component
public class KcDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(KcDAO.class);
	// property constants
	public static final String KCNAME = "kcname";
	public static final String KCXZ = "kcxz";

	protected void initDao() {
		// do nothing
	}

	public void save(Kc transientInstance) {
		log.debug("saving Kc instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Kc persistentInstance) {
		log.debug("deleting Kc instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public void update()
	{
	}
	public Kc findById(java.lang.Integer id) {
		log.debug("getting Kc instance with id: " + id);
		try {
			Kc instance = (Kc) getHibernateTemplate().get("com.swz.entity.Kc",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Kc> findByExample(Kc instance) {
		log.debug("finding Kc instance by example");
		try {
			List<Kc> results = (List<Kc>) getHibernateTemplate().findByExample(
					instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Kc instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Kc as model where model." + propertyName
					+ "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Kc> findByKcname(Object kcname) {
		return findByProperty(KCNAME, kcname);
	}

	public List<Kc> findByKcxz(Object kcxz) {
		return findByProperty(KCXZ, kcxz);
	}

	public List findAll() {
		log.debug("finding all Kc instances");
		try {
			String queryString = "from Kc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Kc merge(Kc detachedInstance) {
		log.debug("merging Kc instance");
		try {
			Kc result = (Kc) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Kc instance) {
		log.debug("attaching dirty Kc instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Kc instance) {
		log.debug("attaching clean Kc instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static KcDAO getFromApplicationContext(ApplicationContext ctx) {
		return (KcDAO) ctx.getBean("KcDAO");
	}
}