package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the HomeWorkLectureProcess database table.
 * 
 */
@Entity
@Table(name = "HomeWorkLectureProcess")
@Getter
@Setter
public class HomeWorkLectureProcess extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;


	private int score;

	private int status;

	//bi-directional many-to-one association to HomeWorkAnswer
	@OneToMany(mappedBy="homeWorkLectureProcess")
	private List<HomeWorkAnswer> homeWorkAnswers;

	//bi-directional many-to-one association to Chapter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idChapter")
	private Chapter chapter;

	//bi-directional many-to-one association to HomeWork
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idHomeWork")
	private HomeWork homeWork;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private User user;




}