package com.swz.service;

import java.util.List;
import com.swz.entity.Scor;
import com.swz.entity.ScorId;
import com.swz.entity.Student;

public interface ScorService
{
	public  String AddScor(Scor scor);
	public  List<Scor> FindAllScor();
	public  void DelScor(Scor scor);
    public Scor FindById(ScorId id);
    public  List<Scor> FindByStudent(Student student);
}
