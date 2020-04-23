package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * The persistent class for the CourseConfig database table.
 * 
 */
@Entity
@Table(name = "CourseConfig")
@Getter
@Setter
public class CourseConfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private int approveAuto;


	private Date ends;

	private int freedomRegister;

	private Date registerEnd;

	private Date registerStart;

	private Date startLearning; //TIME BAT DDAU HOCJ 

	private Date endLearning;	// thoi gian ket thuc

	private Date starts;

	//bi-directional many-to-one association to Course
	@JsonIgnore
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCourse")
	private Course course;

	public CourseConfig() {
	}



	
}