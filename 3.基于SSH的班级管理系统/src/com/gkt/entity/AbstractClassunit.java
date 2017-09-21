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
 * AbstractClassunit entity provides the base persistence definition of the
 * Classunit entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractClassunit implements java.io.Serializable {

	// Fields

	private String classNumber;
	private String className;
	private Set<Student> students = new HashSet<Student>(0);

	// Constructors

	/** default constructor */
	public AbstractClassunit() {
	}

	/** minimal constructor */
	public AbstractClassunit(String classNumber) {
		this.classNumber = classNumber;
	}

	/** full constructor */
	public AbstractClassunit(String classNumber, String className,
			Set<Student> students) {
		this.classNumber = classNumber;
		this.className = className;
		this.students = students;
	}

	// Property accessors
	@Id
	@Column(name = "class_number", unique = true, nullable = false, length = 50)
	public String getClassNumber() {
		return this.classNumber;
	}

	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}

	@Column(name = "class_name", length = 50)
	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classunit")
	public Set<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}