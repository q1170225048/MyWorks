package entity;

/**
 * NonBasis entity. @author MyEclipse Persistence Tools
 */

public class NonBasis implements java.io.Serializable
{

	// Fields

	private String no;
	private Info info;
	private String type;
	private String field;
	private String BUse;
	private String oper;
	private String BName;
	private Double money;

	// Constructors

	/** default constructor */
	public NonBasis()
	{
	}

	/** minimal constructor */
	public NonBasis(String no, Info info)
	{
		this.no = no;
		this.info = info;
	}

	/** full constructor */
	public NonBasis(String no, Info info, String type, String field,
			String BUse, String oper, String BName, Double money)
	{
		this.no = no;
		this.info = info;
		this.type = type;
		this.field = field;
		this.BUse = BUse;
		this.oper = oper;
		this.BName = BName;
		this.money = money;
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

	public Info getInfo()
	{
		return this.info;
	}

	public void setInfo(Info info)
	{
		this.info = info;
	}

	public String getType()
	{
		return this.type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getField()
	{
		return this.field;
	}

	public void setField(String field)
	{
		this.field = field;
	}

	public String getBUse()
	{
		return this.BUse;
	}

	public void setBUse(String BUse)
	{
		this.BUse = BUse;
	}

	public String getOper()
	{
		return this.oper;
	}

	public void setOper(String oper)
	{
		this.oper = oper;
	}

	public String getBName()
	{
		return this.BName;
	}

	public void setBName(String BName)
	{
		this.BName = BName;
	}

	public Double getMoney()
	{
		return this.money;
	}

	public void setMoney(Double money)
	{
		this.money = money;
	}

}