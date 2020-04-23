package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the InterActiveLectureprocess database table.
 * 
 */
@Entity
@Table(name = "InterActiveLectureprocess")
@Getter
@Setter
public class InterActiveLectureprocess extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "comments",columnDefinition = "nvarchar(255)")
	private String comments;
	@Column(name = "contents",columnDefinition = "TEXT")
	private String contents;

	private int status;

	//bi-directional many-to-one association to Chapter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idChapter")
	private Chapter chapter;

	//bi-directional many-to-one association to InterActiveLecture
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idInterActiveLecture")
	private InterActiveLecture interActiveLecture;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private User user;

	public InterActiveLectureprocess() {
	}


}