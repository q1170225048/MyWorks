package com.swz.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Scor entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "scor", catalog = "banjims")
@Component
public class Scor implements java.io.Serializable {

	// Fields

	private ScorId id;
	private Student student;
	private Kc kc;
	private Double scor;

	public Scor() {
	}

	/** minimal constructor */
	public Scor(ScorId id, Student student, Kc kc) {
		this.id = id;
		this.student = student;
		this.kc = kc;
	}

	/** full constructor */
	public Scor(ScorId id, Student student, Kc kc, Double scor) {
		this.id = id;
		this.student = student;
		this.kc = kc;
		this.scor = scor;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "sid", column = @Column(name = "SID", nullable = false)),
			@AttributeOverride(name = "kcid", column = @Column(name = "KCID", nullable = false)) })
	public ScorId getId() {
		return this.id;
	}

	public void setId(ScorId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SID", nullable = false, insertable = false, updatable = false)
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KCID", nullable = false, insertable = false, updatable = false)
	public Kc getKc() {
		return this.kc;
	}

	public void setKc(Kc kc) {
		this.kc = kc;
	}

	@Column(name = "Scor", precision = 20)
	public Double getScor() {
		return this.scor;
	}

	public void setScor(Double scor) {
		this.scor = scor;
	}

}