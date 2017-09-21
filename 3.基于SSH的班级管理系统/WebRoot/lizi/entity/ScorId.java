package com.swz.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.stereotype.Component;

/**
 * ScorId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
@Component
public class ScorId implements java.io.Serializable {

	// Fields

	private Integer sid;
	private Integer kcid;

	// Constructors

	/** default constructor */
	public ScorId() {
	}

	/** full constructor */
	public ScorId(Integer sid, Integer kcid) {
		this.sid = sid;
		this.kcid = kcid;
	}

	// Property accessors

	@Column(name = "SID", nullable = false)
	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Column(name = "KCID", nullable = false)
	public Integer getKcid() {
		return this.kcid;
	}

	public void setKcid(Integer kcid) {
		this.kcid = kcid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ScorId))
			return false;
		ScorId castOther = (ScorId) other;

		return ((this.getSid() == castOther.getSid()) || (this.getSid() != null
				&& castOther.getSid() != null && this.getSid().equals(
				castOther.getSid())))
				&& ((this.getKcid() == castOther.getKcid()) || (this.getKcid() != null
						&& castOther.getKcid() != null && this.getKcid()
						.equals(castOther.getKcid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSid() == null ? 0 : this.getSid().hashCode());
		result = 37 * result
				+ (getKcid() == null ? 0 : this.getKcid().hashCode());
		return result;
	}

}