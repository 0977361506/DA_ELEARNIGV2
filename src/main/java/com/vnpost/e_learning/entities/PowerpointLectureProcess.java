package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PowerpointLectureProcess database table.
 * 
 */
@Entity
@Table(name = "PowerpointLectureProcess")
@Getter
@Setter
public class PowerpointLectureProcess implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int lastView;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idChapter")
	private Chapter chapter;

	//bi-directional many-to-one association to PowerpointLecture
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idPowerpointLecture")
	private PowerpointLecture powerpointLecture;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private User user;



}