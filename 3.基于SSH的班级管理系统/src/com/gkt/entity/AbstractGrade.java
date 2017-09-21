package com.gkt.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * AbstractGrade entity provides the base persistence definition of the Grade
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractGrade implements java.io.Serializable {

	// Fields

	private GradeId id;
	private Course course;
	private Student student;
	private Integer gradeGrade;

	// Constructors

	/** default constructor */
	public AbstractGrade() {
	}

	/** minimal constructor */
	public AbstractGrade(GradeId id, Course course, Student student) {
		this.id = id;
		this.course = course;
		this.student = student;
	}

	/** full constructor */
	public AbstractGrade(GradeId id, Course course, Student student,
			Integer gradeGrade) {
		this.id = id;
		this.course = course;
		this.student = student;
		this.gradeGrade = gradeGrade;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "gradeStudentnumber", column = @Column(name = "grade_studentnumber", nullable = false, length = 50)),
			@AttributeOverride(name = "gradeCoursenumber", column = @Column(name = "grade_coursenumber", nullable = false, length = 50)) })
	public GradeId getId() {
		return this.id;
	}

	public void setId(GradeId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "grade_coursenumber", nullable = false, insertable = false, updatable = false)
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "grade_studentnumber", nullable = false, insertable = false, updatable = false)
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Column(name = "grade_grade", length = 50)
	public Integer getGradeGrade() {
		return this.gradeGrade;
	}

	public void setGradeGrade(Integer gradeGrade) {
		this.gradeGrade = gradeGrade;
	}

}