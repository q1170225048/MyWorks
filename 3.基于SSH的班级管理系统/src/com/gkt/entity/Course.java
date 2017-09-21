package com.gkt.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "course", schema = "dbo", catalog = "ClassManagement")
@Component
public class Course extends AbstractCourse implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(String courseNumber) {
		super(courseNumber);
	}

	/** full constructor */
	public Course(String courseNumber, String courseName, String courseType,
			String courseGrade, Set<Grade> grades) {
		super(courseNumber, courseName, courseType, courseGrade, grades);
	}

}
