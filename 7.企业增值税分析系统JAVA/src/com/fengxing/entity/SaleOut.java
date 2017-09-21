package com.fengxing.entity;

/**
 * SaleOut entity. @author MyEclipse Persistence Tools
 */

public class SaleOut implements java.io.Serializable
{

	// Fields

	private Integer id;
	private Integer year;
	private Integer month;
	private Integer day;
	private String project;
	private String money;

	// Constructors

	/** default constructor */
	public SaleOut()
	{
	}

	/** minimal constructor */
	public SaleOut(Integer id)
	{
		this.id = id;
	}

	/** full constructor */
	public SaleOut(Integer id, Integer year, Integer month, Integer day,
			String project, String money)
	{
		this.id = id;
		this.year = year;
		this.month = month;
		this.day = day;
		this.project = project;
		this.money = money;
	}

	// Property accessors

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getYear()
	{
		return this.year;
	}

	public void setYear(Integer year)
	{
		this.year = year;
	}

	public Integer getMonth()
	{
		return this.month;
	}

	public void setMonth(Integer month)
	{
		this.month = month;
	}

	public Integer getDay()
	{
		return this.day;
	}

	public void setDay(Integer day)
	{
		this.day = day;
	}

	public String getProject()
	{
		return this.project;
	}

	public void setProject(String project)
	{
		this.project = project;
	}

	public String getMoney()
	{
		return this.money;
	}

	public void setMoney(String money)
	{
		this.money = money;
	}

}