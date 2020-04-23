package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ChapterVideoLecture database table.
 * 
 */
@Entity
@Table(name = "ChapterVideoLecture")
@Getter
@Setter
public class ChapterVideoLecture implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int position;

	//bi-directional many-to-one association to Chapter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idChapter",insertable = false, updatable = false)
	private Chapter chapter;

	//bi-directional many-to-one association to VideoLecture
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idVideoLecture",insertable = false, updatable = false)
	private VideoLecture videoLecture;

	public ChapterVideoLecture() {
	}



}