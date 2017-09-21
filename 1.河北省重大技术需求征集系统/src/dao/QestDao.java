package dao;

import java.util.List;

import entity.*;


public interface QestDao
{
	public void saveOrUpdate(BasisInformation basis);
	public List<BasisInformation> findAll();
	public List<BasisInformation> findByNo(String no);
	public List<BasisInformation> findByState(int state);
	public BasisInformation find(BasisInformation basis);
	public List<BasisInformation> findBySearch(BasisInformation basis);
	public List<BasisInformation> findBySql(String hql);
}
