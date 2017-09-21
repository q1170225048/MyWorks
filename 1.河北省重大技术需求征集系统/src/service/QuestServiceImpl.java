package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.QestDao;
import entity.BasisInformation;

@Service
public class QuestServiceImpl
{
	private QestDao qestDao;

	public void setQestDao(QestDao qestDao)
	{
		this.qestDao = qestDao;
	}
	public void saveOrUpdate(BasisInformation basis)
	{
		qestDao.saveOrUpdate(basis);
	}
	public List<BasisInformation> findAll()
	{
		return qestDao.findAll();
	}
	public List<BasisInformation> findByNo(String no)
	{
		return qestDao.findByNo(no);
	}
	public List<BasisInformation> findXSSH()
	{
		// TODO Auto-generated method stub
		return qestDao.findByState(1);
	}
	public List<BasisInformation> findJSSH()
	{
		// TODO Auto-generated method stub
		return qestDao.findByState(2);
	}
	public BasisInformation find(BasisInformation basis)
	{
		// TODO Auto-generated method stub
		return qestDao.find(basis);
	}
	public void add(BasisInformation basis)
	{
		qestDao.saveOrUpdate(basis);
		
	}
	public List<BasisInformation> findBySearch(BasisInformation basis)
	{
		// TODO Auto-generated method stub
		return qestDao.findBySearch(basis);
	}
	public List<BasisInformation> query(String hql)
	{
		// TODO Auto-generated method stub
		return qestDao.findBySql(hql);
	}
}
