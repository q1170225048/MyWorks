package com.gkt.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Grade entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "grade", schema = "dbo", catalog = "ClassManagement")
@Component
public class Grade extends AbstractGrade implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Grade() {
	}

	/** minimal constructor */
	public Grade(GradeId id, Course course, Student student) {
		super(id, course, student);
	}

	/** full constructor */
	public Grade(GradeId id, Course course, Student student, Integer gradeGrade) {
		super(id, course, student, gradeGrade);
	}

}
