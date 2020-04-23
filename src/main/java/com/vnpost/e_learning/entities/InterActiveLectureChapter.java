package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the InterActiveLectureChapter database table.
 * 
 */
@Entity
@Table(name = "InterActiveLectureChapter")
@Getter
@Setter
public class InterActiveLectureChapter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int position;

	//bi-directional many-to-one association to Chapter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idChapter",insertable = false, updatable = false)
	private Chapter chapter;

	//bi-directional many-to-one association to InterActiveLecture
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idInterActiveLecture",insertable = false, updatable = false)

	private InterActiveLecture interActiveLecture;

	public InterActiveLectureChapter() {
	}



}