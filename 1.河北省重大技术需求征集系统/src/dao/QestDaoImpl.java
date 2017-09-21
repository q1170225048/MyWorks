package dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import entity.BasisInformation;
import entity.Info;

public class QestDaoImpl implements QestDao
{
	private SessionFactory sessionFactory;
	
	@Resource
	 public void setSessionFactory(SessionFactory sessionFactory)
     {
               this.sessionFactory = sessionFactory;
     }
	@Transactional
	@Override
	public void saveOrUpdate(BasisInformation basis)
	{
		this.sessionFactory.getCurrentSession().saveOrUpdate(basis);
		
	}
	@Transactional
	@Override
	public List<BasisInformation> findAll()
	{
		@SuppressWarnings("unchecked")
		List<BasisInformation> list=sessionFactory.getCurrentSession().createQuery("from BasisInformation basis ").list();
		return list;
	}
	@Transactional
	@Override
	public List<BasisInformation> findByNo(String no)
	{
		@SuppressWarnings("unchecked")
		List<BasisInformation> list=sessionFactory.getCurrentSession().createQuery("from BasisInformation basis where no='"+no+"'").list();
		return list;
	}
	@Transactional
	@Override
	public List<BasisInformation> findByState(int state)
	{
		@SuppressWarnings("unchecked")
		List<BasisInformation> list=sessionFactory.getCurrentSession().createQuery("from BasisInformation basis where state="+state).list();
		return list;
	}
	@Transactional
	@Override
	public BasisInformation find(BasisInformation basis)
	{
		@SuppressWarnings("unchecked")
		List<BasisInformation> list=sessionFactory.getCurrentSession().createQuery("from Info info where no ="+basis.getNo()+"and techno="+basis.getTechNo()).list();
        if(list!=null&&list.size()>0){
            return list.get(0);
        }

        return null;
	}
	@Transactional
	public List<BasisInformation> findBySearch(BasisInformation basis)
	{
		System.out.println(basis.getNo());
		String hql="from BasisInformation basis ";
		if(!basis.getName().equals("")) 
		{
			System.out.println(basis.getNo());
		}
		if(!basis.getNo().equals(""))
		{
			hql+="where no like '%"+basis.getNo()+"%' ";
			if(!basis.getName().equals(""))
			{
				hql+="and name like '%"+basis.getName()+"%' ";
			}
			if(!basis.getTechNo().equals(""))
			{
				hql+="and techNo like '%"+basis.getTechNo()+"%' ";
			}
			if(!basis.getTechName().equals(""))
			{
				hql+="and techName like '%"+basis.getTechName()+"%' ";
			}
			if(!basis.getKeyword().equals(""))
			{
				hql+="and keyword like '%"+basis.getKeyword()+"%' ";
			}
			if(!basis.getActionType().equals(""))
			{
				hql+="and actionType like '%"+basis.getActionType()+"%' ";
			}
			if(!basis.getSujectSpecific().equals(""))
			{
				hql+="and sujectSpecific like '%"+basis.getSujectSpecific()+"%' ";
			}
			if(!basis.getApplicationIndustry().equals(""))
			{
				hql+="and applicationIndustry like '%"+basis.getApplicationIndustry()+"%' ";
			}
			if(!basis.getNameJoinUnit().equals(""))
			{
				hql+="and nameJoinUnit like '%"+basis.getNameJoinUnit()+"%' ";
			}
			if(!basis.getField().equals(""))
			{
				hql+="and field like '%"+basis.getField()+"%' ";
			}
			if(!basis.getTimeStart().equals(""))
			{
				hql+="and timeStart >= "+basis.getTimeStart()+" ";
			}
			if(!basis.getTimeEnd().equals(""))
			{
				hql+="and timeEnd <= "+basis.getTimeEnd()+" ";
			}
		}
		else
		{
			if(!basis.getName().equals(""))
			{
				hql+="where name like '%"+basis.getName()+"%' ";
				if(!basis.getTechNo().equals(""))
				{
					hql+="and techNo like '%"+basis.getTechNo()+"%' ";
				}
				if(!basis.getTechName().equals(""))
				{
					hql+="and techName like '%"+basis.getTechName()+"%' ";
				}
				if(!basis.getKeyword().equals(""))
				{
					hql+="and keyword like '%"+basis.getKeyword()+"%' ";
				}
				if(!basis.getActionType().equals(""))
				{
					hql+="and actionType like '%"+basis.getActionType()+"%' ";
				}
				if(!basis.getSujectSpecific().equals(""))
				{
					hql+="and sujectSpecific like '%"+basis.getSujectSpecific()+"%' ";
				}
				if(!basis.getApplicationIndustry().equals(""))
				{
					hql+="and applicationIndustry like '%"+basis.getApplicationIndustry()+"%' ";
				}
				if(!basis.getNameJoinUnit().equals(""))
				{
					hql+="and nameJoinUnit like '%"+basis.getNameJoinUnit()+"%' ";
				}
				if(!basis.getField().equals(""))
				{
					hql+="and field like '%"+basis.getField()+"%' ";
				}
				if(!basis.getTimeStart().equals(""))
				{
					hql+="and timeStart >= "+basis.getTimeStart()+" ";
				}
				if(!basis.getTimeEnd().equals(""))
				{
					hql+="and timeEnd <= "+basis.getTimeEnd()+" ";
				}
			}
			else
			{
				if(!basis.getTechNo().equals(""))
				{
					hql+="where techNo like '%"+basis.getTechNo()+"%' ";
					if(!basis.getTechName().equals(""))
					{
						hql+="and techName like '%"+basis.getTechName()+"%' ";
					}
					if(!basis.getKeyword().equals(""))
					{
						hql+="and keyword like '%"+basis.getKeyword()+"%' ";
					}
					if(!basis.getActionType().equals(""))
					{
						hql+="and actionType like '%"+basis.getActionType()+"%' ";
					}
					if(!basis.getSujectSpecific().equals(""))
					{
						hql+="and sujectSpecific like '%"+basis.getSujectSpecific()+"%' ";
					}
					if(!basis.getApplicationIndustry().equals(""))
					{
						hql+="and applicationIndustry like '%"+basis.getApplicationIndustry()+"%' ";
					}
					if(!basis.getNameJoinUnit().equals(""))
					{
						hql+="and nameJoinUnit like '%"+basis.getNameJoinUnit()+"%' ";
					}
					if(!basis.getField().equals(""))
					{
						hql+="and field like '%"+basis.getField()+"%' ";
					}
					if(!basis.getTimeStart().equals(""))
					{
						hql+="and timeStart >= "+basis.getTimeStart()+" ";
					}
					if(!basis.getTimeEnd().equals(""))
					{
						hql+="and timeEnd <= "+basis.getTimeEnd()+" ";
					}
				}
				else
				{
					if(!basis.getTechName().equals(""))
					{
						hql+="where techName like '%"+basis.getTechName()+"%' ";
						
						if(!basis.getKeyword().equals(""))
						{
							hql+="and keyword like '%"+basis.getKeyword()+"%' ";
						}
						if(!basis.getActionType().equals(""))
						{
							hql+="and actionType like '%"+basis.getActionType()+"%' ";
						}
						if(!basis.getSujectSpecific().equals(""))
						{
							hql+="and sujectSpecific like '%"+basis.getSujectSpecific()+"%' ";
						}
						if(!basis.getApplicationIndustry().equals(""))
						{
							hql+="and applicationIndustry like '%"+basis.getApplicationIndustry()+"%' ";
						}
						if(!basis.getNameJoinUnit().equals(""))
						{
							hql+="and nameJoinUnit like '%"+basis.getNameJoinUnit()+"%' ";
						}
						if(!basis.getField().equals(""))
						{
							hql+="and field like '%"+basis.getField()+"%' ";
						}
						if(!basis.getTimeStart().equals(""))
						{
							hql+="and timeStart >= "+basis.getTimeStart()+" ";
						}
						if(!basis.getTimeEnd().equals(""))
						{
							hql+="and timeEnd <= "+basis.getTimeEnd()+" ";
						}
					}
					else
					{
						if(!basis.getKeyword().equals(""))
						{
							hql+="where keyword like '%"+basis.getKeyword()+"%' ";
							if(!basis.getActionType().equals(""))
							{
								hql+="and actionType like '%"+basis.getActionType()+"%' ";
							}
							if(!basis.getSujectSpecific().equals(""))
							{
								hql+="and sujectSpecific like '%"+basis.getSujectSpecific()+"%' ";
							}
							if(!basis.getApplicationIndustry().equals(""))
							{
								hql+="and applicationIndustry like '%"+basis.getApplicationIndustry()+"%' ";
							}
							if(!basis.getNameJoinUnit().equals(""))
							{
								hql+="and nameJoinUnit like '%"+basis.getNameJoinUnit()+"%' ";
							}
							if(!basis.getField().equals(""))
							{
								hql+="and field like '%"+basis.getField()+"%' ";
							}
							if(!basis.getTimeStart().equals(""))
							{
								hql+="and timeStart >= "+basis.getTimeStart()+" ";
							}
							if(!basis.getTimeEnd().equals(""))
							{
								hql+="and timeEnd <= "+basis.getTimeEnd()+" ";
							}
						}
						else
						{
							if(!basis.getActionType().equals(""))
							{
								hql+="where actionType like '%"+basis.getActionType()+"%' ";
								if(!basis.getSujectSpecific().equals(""))
								{
									hql+="and sujectSpecific like '%"+basis.getSujectSpecific()+"%' ";
								}
								if(!basis.getApplicationIndustry().equals(""))
								{
									hql+="and applicationIndustry like '%"+basis.getApplicationIndustry()+"%' ";
								}
								if(!basis.getNameJoinUnit().equals(""))
								{
									hql+="and nameJoinUnit like '%"+basis.getNameJoinUnit()+"%' ";
								}
								if(!basis.getField().equals(""))
								{
									hql+="and field like '%"+basis.getField()+"%' ";
								}
								if(!basis.getTimeStart().equals(""))
								{
									hql+="and timeStart >= "+basis.getTimeStart()+" ";
								}
								if(!basis.getTimeEnd().equals(""))
								{
									hql+="and timeEnd <= "+basis.getTimeEnd()+" ";
								}
							}
							else
							{
								if(!basis.getSujectSpecific().equals(""))
								{
									hql+="where sujectSpecific like '%"+basis.getSujectSpecific()+"%' ";
									if(!basis.getApplicationIndustry().equals(""))
									{
										hql+="and applicationIndustry like '%"+basis.getApplicationIndustry()+"%' ";
									}
									if(!basis.getNameJoinUnit().equals(""))
									{
										hql+="and nameJoinUnit like '%"+basis.getNameJoinUnit()+"%' ";
									}
									if(!basis.getField().equals(""))
									{
										hql+="and field like '%"+basis.getField()+"%' ";
									}
									if(!basis.getTimeStart().equals(""))
									{
										hql+="and timeStart >= "+basis.getTimeStart()+" ";
									}
									if(!basis.getTimeEnd().equals(""))
									{
										hql+="and timeEnd <= "+basis.getTimeEnd()+" ";
									}
								}
								else
								{
									if(!basis.getApplicationIndustry().equals(""))
									{
										hql+="where applicationIndustry like '%"+basis.getApplicationIndustry()+"%' ";
										if(!basis.getNameJoinUnit().equals(""))
										{
											hql+="and nameJoinUnit like '%"+basis.getNameJoinUnit()+"%' ";
										}
										if(!basis.getField().equals(""))
										{
											hql+="and field like '%"+basis.getField()+"%' ";
										}
										if(!basis.getTimeStart().equals(""))
										{
											hql+="and timeStart >= "+basis.getTimeStart()+" ";
										}
										if(!basis.getTimeEnd().equals(""))
										{
											hql+="and timeEnd <= "+basis.getTimeEnd()+" ";
										}
									}
									else
									{
										if(!basis.getNameJoinUnit().equals(""))
										{
											hql+="where nameJoinUnit like '%"+basis.getNameJoinUnit()+"%' ";
											if(!basis.getField().equals(""))
											{
												hql+="and field like '%"+basis.getField()+"%' ";
											}
											if(!basis.getTimeStart().equals(""))
											{
												hql+="and timeStart >= "+basis.getTimeStart()+" ";
											}
											if(!basis.getTimeEnd().equals(""))
											{
												hql+="and timeEnd <= "+basis.getTimeEnd()+" ";
											}
										}
										else
										{
											if(!basis.getField().equals(""))
											{
												hql+="where field like '%"+basis.getField()+"%' ";
												if(!basis.getTimeStart().equals(""))
												{
													hql+="and timeStart >= "+basis.getTimeStart()+" ";
												}
												if(!basis.getTimeEnd().equals(""))
												{
													hql+="and timeEnd <= "+basis.getTimeEnd()+" ";
												}
											}
											else
											{
												if(!basis.getTimeStart().equals(""))
												{
													hql+="where timeStart >= "+basis.getTimeStart()+" ";
													if(!basis.getTimeEnd().equals(""))
													{
														hql+="and timeEnd <= "+basis.getTimeEnd()+" ";
													}
												}
												else
												{
													if(!basis.getTimeEnd().equals(""))
													{
														hql+="where timeStart <= "+basis.getTimeStart()+" ";
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		@SuppressWarnings("unchecked")
		List<BasisInformation> list=sessionFactory.getCurrentSession().createQuery(hql).list();
		if(list!=null&&list.size()>0){
            return list;
        }

        return null;
	}
	
	@Override
	@Transactional
	public List<BasisInformation> findBySql(String hql)
	{
		@SuppressWarnings("unchecked")
		List<BasisInformation> list=sessionFactory.getCurrentSession().createQuery(hql).list();
		if(list!=null&&list.size()>0){
            return list;
        }

        return null;
	}
}
