package dao;

import java.util.List;

import entity.Info;
import entity.Qx;

public interface UserDao
{
	public  Info login(Info user);
	public void saveOrUpdate(Info user);
	public void delete(Info user);
	public Info findByNo(String no);
	public Qx findBySF(String shenfen);
	public List<Info> findBy();

	
}
