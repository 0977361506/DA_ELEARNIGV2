package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



/**
 * The persistent class for the CourseJoin database table.
 * 
 */
@Entity
@Table(name = "CourseJoin")
@Getter
@Setter
public class CourseJoin extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private int status;




	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser",insertable = false, updatable = false)
	private User user;

	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name = "id_course")
	private Course course;

	public CourseJoin() {
	}



	
}