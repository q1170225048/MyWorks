package entity;

/**
 * Qx entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Qx implements java.io.Serializable
{

	// Fields

	private String shenfen;
	private Integer power;
	private Integer tbqx;
	private Integer xqgl;
	private Integer yhxx;
	private Integer xgmm;
	private Integer xsshqx;
	private Integer jssh;
	private Integer tjcx;

	// Constructors

	/** default constructor */
	public Qx()
	{
	}

	/** minimal constructor */
	public Qx(String shenfen)
	{
		this.shenfen = shenfen;
	}

	/** full constructor */
	public Qx(String shenfen, Integer power, Integer tbqx, Integer xqgl,
			Integer yhxx, Integer xgmm, Integer xsshqx, Integer jssh,
			Integer tjcx)
	{
		this.shenfen = shenfen;
		this.power = power;
		this.tbqx = tbqx;
		this.xqgl = xqgl;
		this.yhxx = yhxx;
		this.xgmm = xgmm;
		this.xsshqx = xsshqx;
		this.jssh = jssh;
		this.tjcx = tjcx;
	}

	// Property accessors

	public String getShenfen()
	{
		return this.shenfen;
	}

	public void setShenfen(String shenfen)
	{
		this.shenfen = shenfen;
	}

	public Integer getPower()
	{
		return this.power;
	}

	public void setPower(Integer power)
	{
		this.power = power;
	}

	public Integer getTbqx()
	{
		return this.tbqx;
	}

	public void setTbqx(Integer tbqx)
	{
		this.tbqx = tbqx;
	}

	public Integer getXqgl()
	{
		return this.xqgl;
	}

	public void setXqgl(Integer xqgl)
	{
		this.xqgl = xqgl;
	}

	public Integer getYhxx()
	{
		return this.yhxx;
	}

	public void setYhxx(Integer yhxx)
	{
		this.yhxx = yhxx;
	}

	public Integer getXgmm()
	{
		return this.xgmm;
	}

	public void setXgmm(Integer xgmm)
	{
		this.xgmm = xgmm;
	}

	public Integer getXsshqx()
	{
		return this.xsshqx;
	}

	public void setXsshqx(Integer xsshqx)
	{
		this.xsshqx = xsshqx;
	}

	public Integer getJssh()
	{
		return this.jssh;
	}

	public void setJssh(Integer jssh)
	{
		this.jssh = jssh;
	}

	public Integer getTjcx()
	{
		return this.tjcx;
	}

	public void setTjcx(Integer tjcx)
	{
		this.tjcx = tjcx;
	}

}