package dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import entity.Info;
import entity.Qx;



public class UserDaoImpl implements UserDao{
	private SessionFactory sessionFactory;
	
	@Resource
	 public void setSessionFactory(SessionFactory sessionFactory)
     {
               this.sessionFactory = sessionFactory;
     }
	 @Transactional
	 @Override
    //用户登陆的方法
    public Info login(Info user) {
		@SuppressWarnings("unchecked")
		List<Info> list=sessionFactory.getCurrentSession().createQuery("from Info info where no ="+user.getNo()+"and pwd="+user.getPwd()).list();
        if(list!=null&&list.size()>0){
            return list.get(0);
        }

        return null;
    }
	 @Transactional
	@Override
	public void saveOrUpdate(Info user)
	{
		this.sessionFactory.getCurrentSession().saveOrUpdate(user);
		
	}
	@Transactional
	@Override
	public void delete(Info user)
	{
		this.sessionFactory.getCurrentSession().delete(user);
		
	}
	@Transactional
	@Override
	public Info findByNo(String no)
	{
		
		@SuppressWarnings("unchecked")
		
		List<Info> list=sessionFactory.getCurrentSession().createQuery("from Info info where no ="+no).list();
        if(list!=null&&list.size()>0){
            return list.get(0);
        }

        return null;
	}
	@Transactional
	@Override
	public List<Info> findBy()
	{
		@SuppressWarnings("unchecked")
		List<Info> list=sessionFactory.getCurrentSession().createQuery("from Info info where no !='123'").list();
		return list;
	}
	@Transactional
	@Override
	public Qx findBySF(String shenfen)
	{
		
		String hql="from Qx qx where shenfen = '"+shenfen+"'";
		@SuppressWarnings("unchecked")
		List<Qx> list=sessionFactory.getCurrentSession().createQuery(hql).list();
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        
        return null;
	}
}