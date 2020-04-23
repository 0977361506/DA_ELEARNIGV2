package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ScormLecture database table.
 * 
 */
@Entity
@Table(name = "ScormLecture")
@Getter
@Setter
public class ScormLecture extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name = "files",columnDefinition = "TEXT")
	private String files;

	private int isFlash;

	@Column(name = "name",columnDefinition = "TEXT")
	private String name;

	private int shared;

	private int stored;

	private int totalTime;

	//bi-directional many-to-one association to ChapterScormLecture
	@OneToMany(mappedBy="scormLecture")
	private List<ChapterScormLecture> chapterScormLectures;

	//bi-directional many-to-one association to CourseWare
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCourseWare")
	private CourseWare courseWare;

	//bi-directional many-to-one association to ScormLectureProcess
	@OneToMany(mappedBy="scormLecture")
	private List<ScormLectureProcess> scormLectureProcesses;

	public ScormLecture() {
	}



}