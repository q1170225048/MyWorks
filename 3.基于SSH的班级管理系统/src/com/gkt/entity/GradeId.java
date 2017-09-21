package com.gkt.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.stereotype.Component;

/**
 * GradeId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
@Component
public class GradeId implements java.io.Serializable {

	// Fields

	private String gradeStudentnumber;
	private String gradeCoursenumber;

	// Constructors

	/** default constructor */
	public GradeId() {
	}

	/** full constructor */
	public GradeId(String gradeStudentnumber, String gradeCoursenumber) {
		this.gradeStudentnumber = gradeStudentnumber;
		this.gradeCoursenumber = gradeCoursenumber;
	}

	// Property accessors

	@Column(name = "grade_studentnumber", nullable = false, length = 50)
	public String getGradeStudentnumber() {
		return this.gradeStudentnumber;
	}

	public void setGradeStudentnumber(String gradeStudentnumber) {
		this.gradeStudentnumber = gradeStudentnumber;
	}

	@Column(name = "grade_coursenumber", nullable = false, length = 50)
	public String getGradeCoursenumber() {
		return this.gradeCoursenumber;
	}

	public void setGradeCoursenumber(String gradeCoursenumber) {
		this.gradeCoursenumber = gradeCoursenumber;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GradeId))
			return false;
		GradeId castOther = (GradeId) other;

		return ((this.getGradeStudentnumber() == castOther
				.getGradeStudentnumber()) || (this.getGradeStudentnumber() != null
				&& castOther.getGradeStudentnumber() != null && this
				.getGradeStudentnumber().equals(
						castOther.getGradeStudentnumber())))
				&& ((this.getGradeCoursenumber() == castOther
						.getGradeCoursenumber()) || (this
						.getGradeCoursenumber() != null
						&& castOther.getGradeCoursenumber() != null && this
						.getGradeCoursenumber().equals(
								castOther.getGradeCoursenumber())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getGradeStudentnumber() == null ? 0 : this
						.getGradeStudentnumber().hashCode());
		result = 37
				* result
				+ (getGradeCoursenumber() == null ? 0 : this
						.getGradeCoursenumber().hashCode());
		return result;
	}

}