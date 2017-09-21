package com.swz.serviceImpl;
import java.util.List;

import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swz.dao.ScorDAO;
import com.swz.entity.Scor;
import com.swz.entity.ScorId;
import com.swz.entity.Student;
import com.swz.service.ScorService;
@Component
public class ScorServiceImpl  implements ScorService
{
	private ScorDAO scorDAO;
	@Override
	public String  AddScor(Scor scor)
	{
		try
		{
			Scor scors=scorDAO.findById(scor.getId());
			if(scors==null)
			{	
			    	scorDAO.save(scor);
			}
			else 
			{
				System.out.println("service层保存分数出错,因为已经有这项分数了");
				 return "AddError";
			}
		} catch (Exception e)
		{
			System.out.println("保存分数出了错：");
			e.printStackTrace();
		}
		return "AddSuccess";
	}

	@Override
	public List<Scor> FindAllScor() 
	{
		return scorDAO.findAll();
	}

	@Override
	public Scor FindById(ScorId id)
	{
		return scorDAO.findById(id);
	}

	@Override
	public void DelScor(Scor scor) {
		
		try 
		{
			scorDAO.delete(scor);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public ScorDAO getScorDAO() {
		return scorDAO;
	}
	@Autowired
	public void setScorDAO(ScorDAO scorDAO) {
		this.scorDAO = scorDAO;
	}


	@Override
	public List<Scor> FindByStudent(Student student) {
		return  scorDAO.findByStudent(student);
	}

}
