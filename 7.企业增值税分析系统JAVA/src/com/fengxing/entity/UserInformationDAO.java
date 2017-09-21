package com.fengxing.entity;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserInformation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.fengxing.entity.UserInformation
 * @author MyEclipse Persistence Tools
 */
public class UserInformationDAO extends BaseHibernateDAO
{
	private static final Logger log = LoggerFactory
			.getLogger(UserInformationDAO.class);
	// property constants
	public static final String PASSWORD = "password";
	public static final String NAME = "name";
	public static final String PHONE = "phone";
	public static final String EMAIL = "email";
	public static final String COMPANY = "company";
	public static final String ADRESS = "adress";

	public void save(UserInformation transientInstance)
	{
		log.debug("saving UserInformation instance");
		try
		{
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserInformation persistentInstance)
	{
		log.debug("deleting UserInformation instance");
		try
		{
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserInformation findById(java.lang.String id)
	{
		log.debug("getting UserInformation instance with id: " + id);
		try
		{
			UserInformation instance = (UserInformation) getSession().get(
					"com.fengxing.entity.UserInformation", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserInformation instance)
	{
		log.debug("finding UserInformation instance by example");
		try
		{
			List results = getSession()
					.createCriteria("com.fengxing.entity.UserInformation")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding UserInformation instance with property: "
				+ propertyName + ", value: " + value);
		try
		{
			String queryString = "from UserInformation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPassword(Object password)
	{
		return findByProperty(PASSWORD, password);
	}

	public List findByName(Object name)
	{
		return findByProperty(NAME, name);
	}

	public List findByPhone(Object phone)
	{
		return findByProperty(PHONE, phone);
	}

	public List findByEmail(Object email)
	{
		return findByProperty(EMAIL, email);
	}

	public List findByCompany(Object company)
	{
		return findByProperty(COMPANY, company);
	}

	public List findByAdress(Object adress)
	{
		return findByProperty(ADRESS, adress);
	}

	public List findAll()
	{
		log.debug("finding all UserInformation instances");
		try
		{
			String queryString = "from UserInformation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserInformation merge(UserInformation detachedInstance)
	{
		log.debug("merging UserInformation instance");
		try
		{
			UserInformation result = (UserInformation) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserInformation instance)
	{
		log.debug("attaching dirty UserInformation instance");
		try
		{
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserInformation instance)
	{
		log.debug("attaching clean UserInformation instance");
		try
		{
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}
}