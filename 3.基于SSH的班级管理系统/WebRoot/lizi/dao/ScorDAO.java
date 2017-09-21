package com.swz.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import com.swz.entity.Scor;
import com.swz.entity.ScorId;
import com.swz.entity.Student;
/**
 * @see com.swz.entity.Scor
 * @author MyEclipse Persistence Tools
 */
@Component
public class ScorDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(ScorDAO.class);
	// property constants
	public static final String SCOR = "scor";

	protected void initDao() {
		// do nothing
	}

	public void save(Scor transientInstance) {
		log.debug("saving Scor instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Scor persistentInstance) {
		log.debug("deleting Scor instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Scor findById(com.swz.entity.ScorId id) {
		log.debug("getting Scor instance with id: " + id);
		try {
			Scor instance = (Scor) getHibernateTemplate().get(
					"com.swz.entity.Scor", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Scor> findByExample(Scor instance) {
		log.debug("finding Scor instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Scor> results = (List<Scor>) getHibernateTemplate()
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
	public List<Scor> findByProperty(String propertyName, Object value) {
		log.debug("finding Scor instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Scor as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Scor> findByScor(Object scor) {
		return findByProperty(SCOR, scor);
	}

	@SuppressWarnings("unchecked")
	public List<Scor> findAll() {
		log.debug("finding all Scor instances");
		try {
			String queryString = "from Scor";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List<Scor> findByStudent(Student student)
	{
			return  findByProperty("student", student);
	}
	public Scor merge(Scor detachedInstance) {
		log.debug("merging Scor instance");
		try {
			Scor result = (Scor) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Scor instance) {
		log.debug("attaching dirty Scor instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Scor instance) {
		log.debug("attaching clean Scor instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ScorDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ScorDAO) ctx.getBean("ScorDAO");
	}
}