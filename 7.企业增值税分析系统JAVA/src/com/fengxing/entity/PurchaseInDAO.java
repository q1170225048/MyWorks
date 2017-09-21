package com.fengxing.entity;

import java.util.List;
import java.util.TreeMap;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * PurchaseIn entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.fengxing.entity.PurchaseIn
 * @author MyEclipse Persistence Tools
 */
public class PurchaseInDAO extends BaseHibernateDAO
{
	private static final Logger log = LoggerFactory
			.getLogger(PurchaseInDAO.class);
	// property constants
	public static final String YEAR = "year";
	public static final String MONTH = "month";
	public static final String DAY = "day";
	public static final String PROJECT = "project";
	public static final String MONEY = "money";

	public void save(PurchaseIn transientInstance)
	{
		log.debug("saving PurchaseIn instance");
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

	public void delete(PurchaseIn persistentInstance)
	{
		log.debug("deleting PurchaseIn instance");
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

	public PurchaseIn findById(java.lang.Integer id)
	{
		log.debug("getting PurchaseIn instance with id: " + id);
		try
		{
			PurchaseIn instance = (PurchaseIn) getSession().get(
					"com.fengxing.entity.PurchaseIn", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PurchaseIn instance)
	{
		log.debug("finding PurchaseIn instance by example");
		try
		{
			List results = getSession()
					.createCriteria("com.fengxing.entity.PurchaseIn")
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
		log.debug("finding PurchaseIn instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from PurchaseIn as model where model."
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

	public List findByYear(Object year)
	{
		return findByProperty(YEAR, year);
	}

	public List findByMonth(Object month)
	{
		return findByProperty(MONTH, month);
	}

	public List findByDay(Object day)
	{
		return findByProperty(DAY, day);
	}

	public List findByProject(Object project)
	{
		return findByProperty(PROJECT, project);
	}

	public List findByMoney(Object money)
	{
		return findByProperty(MONEY, money);
	}

	public List findAll()
	{
		log.debug("finding all PurchaseIn instances");
		try
		{
			String queryString = "from PurchaseIn";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public PurchaseIn merge(PurchaseIn detachedInstance)
	{
		log.debug("merging PurchaseIn instance");
		try
		{
			PurchaseIn result = (PurchaseIn) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PurchaseIn instance)
	{
		log.debug("attaching dirty PurchaseIn instance");
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

	public void attachClean(PurchaseIn instance)
	{
		log.debug("attaching clean PurchaseIn instance");
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
	public TreeMap<String, Integer> findA(){  
         
        String sql="select month,money from PurchaseIn";  
        @SuppressWarnings("unchecked")
		List<Object[]> objects=getSession().createQuery(sql).list();  
		
        TreeMap<String, Integer> map = null;  
        if(objects!=null && objects.size()>0){  
            map = new TreeMap<String, Integer>();  
            for(int i=1;i<13;i++)
            {
            	map.put(String.valueOf(i), 0);
            }
            for (int i = 0; i < objects.size(); i++) {  
                Object[] objs = objects.get(i); 
                for(int j=1;j<13;j++)
                {
                	if(objs[0].equals(j))
                	{
                	
                		int m=map.get(String.valueOf(objs[0]));
                		map.put(String.valueOf(objs[0]), m+Integer.parseInt(String.valueOf(objs[1])));
                	
                	}
                }
               
                
                //map.put(String.valueOf(objs[0]), Integer.parseInt(String.valueOf(objs[1])));  
            }  
        }  
        return map;  
          
    }  
}