package com.gkt.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * AbstractCourse entity provides the base persistence definition of the Course
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractCourse implements java.io.Serializable {

	// Fields

	private String courseNumber;
	private String courseName;
	private String courseType;
	private String courseGrade;
	private Set<Grade> grades = new HashSet<Grade>(0);

	// Constructors

	/** default constructor */
	public AbstractCourse() {
	}

	/** minimal constructor */
	public AbstractCourse(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	/** full constructor */
	public AbstractCourse(String courseNumber, String courseName,
			String courseType, String courseGrade, Set<Grade> grades) {
		this.courseNumber = courseNumber;
		this.courseName = courseName;
		this.courseType = courseType;
		this.courseGrade = courseGrade;
		this.grades = grades;
	}

	// Property accessors
	@Id
	@Column(name = "course_number", unique = true, nullable = false, length = 50)
	public String getCourseNumber() {
		return this.courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	@Column(name = "course_name", length = 50)
	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Column(name = "course_type", length = 50)
	public String getCourseType() {
		return this.courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	@Column(name = "course_grade", length = 50)
	public String getCourseGrade() {
		return this.courseGrade;
	}

	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<Grade> getGrades() {
		return this.grades;
	}

	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}

}