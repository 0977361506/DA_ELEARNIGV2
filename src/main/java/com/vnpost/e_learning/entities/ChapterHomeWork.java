package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ChapterHomeWork database table.
 * 
 */
@Entity
@Table(name = "ChapterHomeWork")
@Getter
@Setter
public class ChapterHomeWork implements Serializable {
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

	//bi-directional many-to-one association to HomeWork
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idHomeWork",insertable = false, updatable = false)
	private HomeWork homeWork;


}