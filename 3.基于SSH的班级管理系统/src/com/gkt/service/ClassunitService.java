package com.gkt.service;

import java.util.List;

import com.gkt.entity.*;

public interface ClassunitService {
    //查询所有班级信息
	public List<Classunit> findAll();
	//判断班级编号是否存在
	public boolean checkClassnumber(String classunitnumber);
	//新增班级信息
	public void addClassunit(com.gkt.entity.Classunit classnumber);
	//查找修改对象
	public Classunit findclassunitnumber(String classunit);
	//保存修改信息
	public void editClassunit(Classunit classnumber);
	//删除班级信息
	public void delClassunit(Classunit classnumber);
	public Classunit findByno(String classStr);
}
