package com.swz.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "classes", catalog = "banjims")
@Component
public class Classes implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer bjid;
	private String bjname;
	private Set<Student> students = new HashSet<Student>(0);

	// Constructors

	/** default constructor */
	public Classes() {
	}

	/** minimal constructor */
	public Classes(String bjname) {
		this.bjname = bjname;
	}

	/** full constructor */
	public Classes(String bjname, Set<Student> students) {
		this.bjname = bjname;
		this.students = students;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BJID", unique = true, nullable = false)
	public Integer getBjid() {
		return this.bjid;
	}

	public void setBjid(Integer bjid) {
		this.bjid = bjid;
	}

	@Column(name = "BJName", nullable = false, length = 100)
	public String getBjname() {
		return this.bjname;
	}

	public void setBjname(String bjname) {
		this.bjname = bjname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classes")
	public Set<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}