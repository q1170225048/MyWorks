package com.fengxing.entity;

/**
 * UserInformation entity. @author MyEclipse Persistence Tools
 */

public class UserInformation implements java.io.Serializable
{

	// Fields

	private String usernamae;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String company;
	private String adress;

	// Constructors

	/** default constructor */
	public UserInformation()
	{
	}

	/** minimal constructor */
	public UserInformation(String usernamae)
	{
		this.usernamae = usernamae;
	}

	/** full constructor */
	public UserInformation(String usernamae, String password, String name,
			String phone, String email, String company, String adress)
	{
		this.usernamae = usernamae;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.company = company;
		this.adress = adress;
	}

	// Property accessors

	public String getUsernamae()
	{
		return this.usernamae;
	}

	public void setUsernamae(String usernamae)
	{
		this.usernamae = usernamae;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPhone()
	{
		return this.phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getCompany()
	{
		return this.company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

	public String getAdress()
	{
		return this.adress;
	}

	public void setAdress(String adress)
	{
		this.adress = adress;
	}

}