package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the VideoLecture database table.
 * 
 */
@Entity
@Table(name = "VideoLecture")
@Getter
@Setter
public class VideoLecture extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name = "description",columnDefinition = "TEXT")
	private String description;

	private String files;

	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String name;

	private int shared;

	private int stored;

	private int totalDuration;

	//bi-directional many-to-one association to ChapterVideoLecture
	@OneToMany(mappedBy="videoLecture")
	private List<ChapterVideoLecture> chapterVideoLectures;

	//bi-directional many-to-one association to CourseWare
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCourseWare")
	private CourseWare courseWare;

	//bi-directional many-to-one association to VideoLectureProcess
	@OneToMany(mappedBy="videoLecture")
	private List<VideoLectureProcess> videoLectureProcesses;



}