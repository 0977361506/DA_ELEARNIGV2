package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the CourseWare database table.
 * 
 */
@Entity
@Table(name = "CourseWare")
@Getter
@Setter
public class CourseWare implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String name;

	@Column(name = "status")
	private String status;
	@Column(name = "files",columnDefinition = "TEXT")
	private String files;

	@ManyToOne
	@JoinColumn(name = "id_course_ware_type")
	private CourseWareType courseWareType;

	@OneToMany(mappedBy = "courseWare")
	private List<CourseWareProcess> courseWareProcesses = new ArrayList<>();

	@OneToMany(mappedBy = "courseWare")
	private List<ChapterCourseWare> chapterCourseWares = new ArrayList<>();
	//bi-directional many-to-one association to Chapter

	//bi-directional many-to-one association to HomeWork
	@OneToOne(mappedBy="courseWare")
	private HomeWork homeWork;

	//bi-directional many-to-one association to InterActiveLecture
	@OneToOne(mappedBy="courseWare")
	private InterActiveLecture interActiveLecture;

	//bi-directional many-to-one association to PowerpointLecture
	@OneToOne(mappedBy="courseWare")
	private PowerpointLecture powerpointLecture;

	//bi-directional many-to-one association to ScormLecture
	@OneToOne(mappedBy="courseWare")
	private ScormLecture scormLectures;

	//bi-directional many-to-one association to VideoLecture
	@OneToOne(mappedBy="courseWare")
	private VideoLecture videoLecture;

	@OneToOne(mappedBy = "courseWare")
	private FreedomLecture freedomLectures;


}