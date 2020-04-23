package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FreedomLectureProcess database table.
 * 
 */
@Entity
@Table(name = "FreedomLectureProcess")
@Getter
@Setter
public class FreedomLectureProcess implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    long id ;

	private int timeLearn;

	//bi-directional many-to-one association to Chapter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idChapter")
	private Chapter chapter;

	//bi-directional many-to-one association to FreedomLecture
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idFreedomLecture")
	private FreedomLecture freedomLecture;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private User user;

	public FreedomLectureProcess() {
	}



}