package com.swz.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "student", catalog = "banjims")
@Component("student")
public class Student implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer sids;
	private Integer sid;
	private Classes classes;
	private String sname;
	private String ssex;
	private Date sbri;
	private String spass;
	private String sphon;
	private String sadress;
	private Set<Scor> scors = new HashSet<Scor>(0);


	public Student() {
	}

	public Student(Classes classes, String sname, String ssex, Date sbri,
		String spass, String sphon) {
		this.classes = classes;
		this.sname = sname;
		this.ssex = ssex;
		this.sbri = sbri;
		this.spass = spass;
		this.sphon = sphon;
	}

	/** full constructor */
	public Student(Classes classes, String sname, String ssex, Date sbri,
			String spass, String sphon, String sadress, Set<Scor> scors) {
		this.classes = classes;
		this.sname = sname;
		this.ssex = ssex;
		this.sbri = sbri;
		this.spass = spass;
		this.sphon = sphon;
		this.sadress = sadress;
		this.scors = scors;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SID", unique = true, nullable = false)
	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SBJID", nullable = false)
	public Classes getClasses() {
		return this.classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	@Column(name = "SName", nullable = false, length = 50)
	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Column(name = "SSex", nullable = false, length = 10)
	public String getSsex() {
		return this.ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SBri", nullable = false, length = 10)
	public Date getSbri() {
		return this.sbri;
	}

	public void setSbri(Date sbri) {
		this.sbri = sbri;
	}

	@Column(name = "SPass", nullable = false, length = 100)
	public String getSpass() {
		return this.spass;
	}

	public void setSpass(String spass) {
		this.spass = spass;
	}

	@Column(name = "SPhon", nullable = false, length = 50)
	public String getSphon() {
		return this.sphon;
	}

	public void setSphon(String sphon) {
		this.sphon = sphon;
	}

	@Column(name = "SAdress", length = 100)
	public String getSadress() {
		return this.sadress;
	}

	public void setSadress(String sadress) {
		this.sadress = sadress;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "student")
	public Set<Scor> getScors() {
		return this.scors;
	}

	public void setScors(Set<Scor> scors) {
		this.scors = scors;
	}
	
	public Integer getSids() {
		return sids;
	}

	public void setSids(Integer sids) {
		this.sids = sids;
	}

}