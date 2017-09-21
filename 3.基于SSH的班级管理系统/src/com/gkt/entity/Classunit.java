package com.gkt.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classunit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "classunit", schema = "dbo", catalog = "ClassManagement")
public class Classunit extends AbstractClassunit implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Classunit() {
	}

	/** minimal constructor */
	public Classunit(String classNumber) {
		super(classNumber);
	}

	/** full constructor */
	public Classunit(String classNumber, String className, Set<Student> students) {
		super(classNumber, className, students);
	}


}
