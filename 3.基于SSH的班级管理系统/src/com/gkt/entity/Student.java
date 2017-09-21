package com.gkt.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "student", schema = "dbo", catalog = "ClassManagement")
public class Student extends AbstractStudent implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String studentNumber) {
		super(studentNumber);
	}

	/** full constructor */
	public Student(String studentNumber, Classunit classunit,
			String studentName, String studentGender, String studentBirth,
			String studentPassword, String studentPhone, String studentAddress,
			Set<Grade> grades) {
		super(studentNumber, classunit, studentName, studentGender,
				studentBirth, studentPassword, studentPhone, studentAddress,
				grades);
	}

}
