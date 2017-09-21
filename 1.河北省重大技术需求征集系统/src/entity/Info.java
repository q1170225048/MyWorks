package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Info entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Info implements java.io.Serializable
{

	// Fields

	private String no;
	private String name;
	private String pwd;
	private String address;
	private String url;
	private String fr;
	private String email;
	private String pcode;
	private String contact;
	private String phone;
	private String mphone;
	private String cz;
	private String pro;
	private String belong;
	private String intro;
	private String szdy;
	private String subm;
	private String shenfen;
	private Set basisInformations = new HashSet(0);
	private Set nonBasises = new HashSet(0);

	// Constructors

	/** default constructor */
	public Info()
	{
	}

	/** minimal constructor */
	public Info(String no, String name, String pwd, String address,
			String belong)
	{
		this.no = no;
		this.name = name;
		this.pwd = pwd;
		this.address = address;
		this.belong = belong;
	}
	public Info(String no , String pwd)
	{
		this.no=no;
		this.pwd=pwd;
	}
	public Info(String no)
	{
		this.no=no;
	}
	public Info(String no, String name, String pwd, String address, String url,
			String fr, String email, String pcode, String contact,
			String phone, String cz, String belong)
	{
		this.no = no;
		this.name = name;
		this.pwd = pwd;
		this.address = address;
		this.url = url;
		this.fr = fr;
		this.email = email;
		this.pcode = pcode;
		this.contact = contact;
		this.phone = phone;
		this.cz = cz;
		this.belong = belong;
	}
	/** full constructor */
	public Info(String no, String name, String pwd, String address, String url,
			String fr, String email, String pcode, String contact,
			String phone, String mphone, String cz, String pro, String belong,
			String intro, String szdy, String subm, String shenfen,
			Set basisInformations, Set nonBasises)
	{
		this.no = no;
		this.name = name;
		this.pwd = pwd;
		this.address = address;
		this.url = url;
		this.fr = fr;
		this.email = email;
		this.pcode = pcode;
		this.contact = contact;
		this.phone = phone;
		this.mphone = mphone;
		this.cz = cz;
		this.pro = pro;
		this.belong = belong;
		this.intro = intro;
		this.szdy = szdy;
		this.subm = subm;
		this.shenfen = shenfen;
		this.basisInformations = basisInformations;
		this.nonBasises = nonBasises;
	}

	// Property accessors

	public String getNo()
	{
		return this.no;
	}

	public void setNo(String no)
	{
		this.no = no;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPwd()
	{
		return this.pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getUrl()
	{
		return this.url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getFr()
	{
		return this.fr;
	}

	public void setFr(String fr)
	{
		this.fr = fr;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPcode()
	{
		return this.pcode;
	}

	public void setPcode(String pcode)
	{
		this.pcode = pcode;
	}

	public String getContact()
	{
		return this.contact;
	}

	public void setContact(String contact)
	{
		this.contact = contact;
	}

	public String getPhone()
	{
		return this.phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getMphone()
	{
		return this.mphone;
	}

	public void setMphone(String mphone)
	{
		this.mphone = mphone;
	}

	public String getCz()
	{
		return this.cz;
	}

	public void setCz(String cz)
	{
		this.cz = cz;
	}

	public String getPro()
	{
		return this.pro;
	}

	public void setPro(String pro)
	{
		this.pro = pro;
	}

	public String getBelong()
	{
		return this.belong;
	}

	public void setBelong(String belong)
	{
		this.belong = belong;
	}

	public String getIntro()
	{
		return this.intro;
	}

	public void setIntro(String intro)
	{
		this.intro = intro;
	}

	public String getSzdy()
	{
		return this.szdy;
	}

	public void setSzdy(String szdy)
	{
		this.szdy = szdy;
	}

	public String getSubm()
	{
		return this.subm;
	}

	public void setSubm(String subm)
	{
		this.subm = subm;
	}

	public String getShenfen()
	{
		return this.shenfen;
	}

	public void setShenfen(String shenfen)
	{
		this.shenfen = shenfen;
	}

	public Set getBasisInformations()
	{
		return this.basisInformations;
	}

	public void setBasisInformations(Set basisInformations)
	{
		this.basisInformations = basisInformations;
	}

	public Set getNonBasises()
	{
		return this.nonBasises;
	}

	public void setNonBasises(Set nonBasises)
	{
		this.nonBasises = nonBasises;
	}

}