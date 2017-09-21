package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.UserDao;
import entity.Info;
import entity.Qx;
@Service
public class UserServiceImpl {
    //对UserDao的注入
    private UserDao userDao;

    /**
     * @param userDao the userDao to set
     */
    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //登录方法
    public Info login(Info user) {
        // TODO Auto-generated method stub
    	
        return userDao.login(user);
    }

	public Info getByNo(String no)
	{
		// TODO Auto-generated method stub
		return userDao.findByNo(no);
	}

	public void add(Info user)
	{
		userDao.saveOrUpdate(user);
		
	}

	public Qx findBySF(String shenfen)
	{
		// TODO Auto-generated method stub
		return userDao.findBySF(shenfen);
	}

	public void saveOrUpdate(Info user)
	{
		userDao.saveOrUpdate(user);
		
	}

	public List<Info> findAll()
	{
		// TODO Auto-generated method stub
		return userDao.findBy();
	}

	


}