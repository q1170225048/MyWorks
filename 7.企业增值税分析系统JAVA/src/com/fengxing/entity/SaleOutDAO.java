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
 * SaleOut entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.fengxing.entity.SaleOut
 * @author MyEclipse Persistence Tools
 */
public class SaleOutDAO extends BaseHibernateDAO
{
	private static final Logger log = LoggerFactory.getLogger(SaleOutDAO.class);
	// property constants
	public static final String YEAR = "year";
	public static final String MONTH = "month";
	public static final String DAY = "day";
	public static final String PROJECT = "project";
	public static final String MONEY = "money";

	public void save(SaleOut transientInstance)
	{
		log.debug("saving SaleOut instance");
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

	public void delete(SaleOut persistentInstance)
	{
		log.debug("deleting SaleOut instance");
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

	public SaleOut findById(java.lang.Integer id)
	{
		log.debug("getting SaleOut instance with id: " + id);
		try
		{
			SaleOut instance = (SaleOut) getSession().get(
					"com.fengxing.entity.SaleOut", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SaleOut instance)
	{
		log.debug("finding SaleOut instance by example");
		try
		{
			List results = getSession()
					.createCriteria("com.fengxing.entity.SaleOut")
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
		log.debug("finding SaleOut instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from SaleOut as model where model."
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
		log.debug("finding all SaleOut instances");
		try
		{
			String queryString = "from SaleOut";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public SaleOut merge(SaleOut detachedInstance)
	{
		log.debug("merging SaleOut instance");
		try
		{
			SaleOut result = (SaleOut) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SaleOut instance)
	{
		log.debug("attaching dirty SaleOut instance");
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

	public void attachClean(SaleOut instance)
	{
		log.debug("attaching clean SaleOut instance");
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
        
        String sql="select month,money from SaleOut";  
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