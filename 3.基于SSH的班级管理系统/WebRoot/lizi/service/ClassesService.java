package com.swz.service;

import java.util.List;

import com.swz.entity.Classes;

public interface ClassesService {

	public boolean  AddCla(Classes classes);
	public List<Classes>    FindAllC();
	public  boolean DelClass(Classes classes );
	public Classes FindById(Integer id);
}
