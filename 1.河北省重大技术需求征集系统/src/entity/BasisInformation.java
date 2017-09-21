package entity;

/**
 * BasisInformation entity. @author MyEclipse Persistence Tools
 */

public class BasisInformation implements java.io.Serializable
{

	// Fields

	private String no;
	private String techNo;
	private String techName;
	private String techIntroMajorproblem;
	private String techIntroKeytechnology;
	private String techIntroTarget;
	private String timeStart;
	private String timeEnd;
	private String keyword;
	private String moneyInvestment;
	private String solution;
	private String nameJoinUnit;
	private String actionType;
	private String sujectSpecific;
	private String field;
	private String applicationIndustry;
	private String state;
	private String name;
	private String glbm;
	private String xsshyj;
	private String bmshyj;

	// Constructors

	/** default constructor */
	public BasisInformation()
	{
	}

	/** minimal constructor */
	public BasisInformation(String no,String techNo)
	{
		this.no=no;
		this.techNo=techNo;
	}

	/** full constructor */
	public BasisInformation(String no,String techNo, String techName,
			String techIntroMajorproblem, String techIntroKeytechnology,
			String techIntroTarget, String timeStart, String timeEnd,
			String keyword, String moneyInvestment, String solution,
			String nameJoinUnit, String actionType, String sujectSpecific,
			String field, String applicationIndustry, String state,
			String name, String glbm, String xsshyj, String bmshyj)
	{
		this.no = no;
		this.techNo=techNo;
		this.techName = techName;
		this.techIntroMajorproblem = techIntroMajorproblem;
		this.techIntroKeytechnology = techIntroKeytechnology;
		this.techIntroTarget = techIntroTarget;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.keyword = keyword;
		this.moneyInvestment = moneyInvestment;
		this.solution = solution;
		this.nameJoinUnit = nameJoinUnit;
		this.actionType = actionType;
		this.sujectSpecific = sujectSpecific;
		this.field = field;
		this.applicationIndustry = applicationIndustry;
		this.state = state;
		this.name = name;
		this.glbm = glbm;
		this.xsshyj = xsshyj;
		this.bmshyj = bmshyj;
	}

	// Property accessors


	public String getTechName()
	{
		return this.techName;
	}

	public void setTechName(String techName)
	{
		this.techName = techName;
	}

	public String getTechIntroMajorproblem()
	{
		return this.techIntroMajorproblem;
	}

	public void setTechIntroMajorproblem(String techIntroMajorproblem)
	{
		this.techIntroMajorproblem = techIntroMajorproblem;
	}

	public String getTechIntroKeytechnology()
	{
		return this.techIntroKeytechnology;
	}

	public void setTechIntroKeytechnology(String techIntroKeytechnology)
	{
		this.techIntroKeytechnology = techIntroKeytechnology;
	}

	public String getTechIntroTarget()
	{
		return this.techIntroTarget;
	}

	public void setTechIntroTarget(String techIntroTarget)
	{
		this.techIntroTarget = techIntroTarget;
	}

	public String getTimeStart()
	{
		return this.timeStart;
	}

	public void setTimeStart(String timeStart)
	{
		this.timeStart = timeStart;
	}

	public String getTimeEnd()
	{
		return this.timeEnd;
	}

	public void setTimeEnd(String timeEnd)
	{
		this.timeEnd = timeEnd;
	}

	public String getKeyword()
	{
		return this.keyword;
	}

	public void setKeyword(String keyword)
	{
		this.keyword = keyword;
	}

	public String getMoneyInvestment()
	{
		return this.moneyInvestment;
	}

	public void setMoneyInvestment(String moneyInvestment)
	{
		this.moneyInvestment = moneyInvestment;
	}

	public String getSolution()
	{
		return this.solution;
	}

	public void setSolution(String solution)
	{
		this.solution = solution;
	}

	public String getNameJoinUnit()
	{
		return this.nameJoinUnit;
	}

	public void setNameJoinUnit(String nameJoinUnit)
	{
		this.nameJoinUnit = nameJoinUnit;
	}

	public String getActionType()
	{
		return this.actionType;
	}

	public void setActionType(String actionType)
	{
		this.actionType = actionType;
	}

	public String getSujectSpecific()
	{
		return this.sujectSpecific;
	}

	public void setSujectSpecific(String sujectSpecific)
	{
		this.sujectSpecific = sujectSpecific;
	}

	public String getField()
	{
		return this.field;
	}

	public void setField(String field)
	{
		this.field = field;
	}

	public String getApplicationIndustry()
	{
		return this.applicationIndustry;
	}

	public void setApplicationIndustry(String applicationIndustry)
	{
		this.applicationIndustry = applicationIndustry;
	}

	public String getState()
	{
		return this.state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getGlbm()
	{
		return this.glbm;
	}

	public void setGlbm(String glbm)
	{
		this.glbm = glbm;
	}

	public String getXsshyj()
	{
		return this.xsshyj;
	}

	public void setXsshyj(String xsshyj)
	{
		this.xsshyj = xsshyj;
	}

	public String getBmshyj()
	{
		return this.bmshyj;
	}

	public void setBmshyj(String bmshyj)
	{
		this.bmshyj = bmshyj;
	}

	public String getNo()
	{
		return no;
	}

	public void setNo(String no)
	{
		this.no = no;
	}

	public String getTechNo()
	{
		return techNo;
	}

	public void setTechNo(String techNo)
	{
		this.techNo = techNo;
	}

}