package com.gkt.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * AbstractStudent entity provides the base persistence definition of the
 * Student entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractStudent implements java.io.Serializable {

	// Fields

	private String studentNumber;
	private Classunit classunit;
	private String studentName;
	private String studentGender;
	private String studentBirth;
	private String studentPassword;
	private String studentPhone;
	private String studentAddress;
	private Set<Grade> grades = new HashSet<Grade>(0);

	// Constructors

	/** default constructor */
	public AbstractStudent() {
	}

	/** minimal constructor */
	public AbstractStudent(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	/** full constructor */
	public AbstractStudent(String studentNumber, Classunit classunit,
			String studentName, String studentGender, String studentBirth,
			String studentPassword, String studentPhone, String studentAddress,
			Set<Grade> grades) {
		this.studentNumber = studentNumber;
		this.classunit = classunit;
		this.studentName = studentName;
		this.studentGender = studentGender;
		this.studentBirth = studentBirth;
		this.studentPassword = studentPassword;
		this.studentPhone = studentPhone;
		this.studentAddress = studentAddress;
		this.grades = grades;
	}

	// Property accessors
	@Id
	@Column(name = "student_number", unique = true, nullable = false, length = 50)
	public String getStudentNumber() {
		return this.studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_classnumber")
	public Classunit getClassunit() {
		return this.classunit;
	}

	public void setClassunit(Classunit classunit) {
		this.classunit = classunit;
	}

	@Column(name = "student_name", length = 50)
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Column(name = "student_gender", length = 50)
	public String getStudentGender() {
		return this.studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	@Column(name = "student_birth", length = 50)
	public String getStudentBirth() {
		return this.studentBirth;
	}

	public void setStudentBirth(String studentBirth) {
		this.studentBirth = studentBirth;
	}

	@Column(name = "student_password", length = 50)
	public String getStudentPassword() {
		return this.studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	@Column(name = "student_phone", length = 50)
	public String getStudentPhone() {
		return this.studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	@Column(name = "student_address", length = 50)
	public String getStudentAddress() {
		return this.studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "student")
	public Set<Grade> getGrades() {
		return this.grades;
	}

	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}

}