package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Rate database table.
 * 
 */
@Entity
@Table(name = "Rate")
@Getter
@Setter
public class Rate implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    private double avg ;
	private int valuess;
	  private String star_one;
	  private String star_two;
	  private String star_three;
      
	  private String star_for;
	 
	  private String star_five;
	//bi-directional many-to-one association to Course
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCourse")
	private Course course;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private User user;

	public Rate() {
	}



}