package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CourseRequirement database table.
 * 
 */
@Entity
@Table(name = "CourseRequirement")
@Getter
@Setter
public class CourseRequirement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Course
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCourse")
	private Course course;

	//bi-directional many-to-one association to PositionName
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idPositionname")
	private PositionName positionName;

	public CourseRequirement() {
	}



}