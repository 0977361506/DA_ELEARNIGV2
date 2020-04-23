package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Chapter database table.
 * 
 */
@Entity
@Table(name = "Chapter")
@Getter
@Setter
public class Chapter extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name = "idOutline")
	private Outline outline ;


	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String name;

	//bi-directional many-to-one association to ChapterFreedomLecture

	@OneToMany(mappedBy = "chapter")
	private List<ChapterCourseWare> chapterCourseWares = new ArrayList<>();

	@OneToMany(mappedBy = "chapter")
	private List<CourseWareProcess> courseWareProcesses = new ArrayList<>();
	
	//bi-directional many-to-one association to ChapterHomeWork
	@OneToMany(mappedBy="chapter")
	private List<ChapterHomeWork> chapterHomeWorks;

	//bi-directional many-to-one association to ChapterPowerpointlecture
	@OneToMany(mappedBy="chapter")
	private List<ChapterPowerpointlecture> chapterPowerpointlectures;

	//bi-directional many-to-one association to ChapterScormLecture
	@OneToMany(mappedBy="chapter")
	private List<ChapterScormLecture> chapterScormLectures;

	//bi-directional many-to-one association to ChapterVideoLecture
	@OneToMany(mappedBy="chapter")
	private List<ChapterVideoLecture> chapterVideoLectures;

	//bi-directional many-to-one association to CourseWare


	//bi-directional many-to-one association to FreedomLectureProcess
	@OneToMany(mappedBy="chapter")
	private List<FreedomLectureProcess> freedomLectureProcesses;



	//bi-directional many-to-one association to HomeWorkLectureProcess
	@OneToMany(mappedBy="chapter")
	private List<HomeWorkLectureProcess> homeWorkLectureProcesses;

	//bi-directional many-to-one association to InterActiveLectureChapter
	@OneToMany(mappedBy="chapter")
	private List<InterActiveLectureChapter> interActiveLectureChapters;

	//bi-directional many-to-one association to InterActiveLectureprocess
	@OneToMany(mappedBy="chapter")
	private List<InterActiveLectureprocess> interActiveLectureprocesses;

	//bi-directional many-to-one association to PowerpointLectureProcess
	@OneToMany(mappedBy="chapter")
	private List<PowerpointLectureProcess> powerpointLectureProcesses;

	//bi-directional many-to-one association to ScormLectureProcess
	@OneToMany(mappedBy="chapter")
	private List<ScormLectureProcess> scormLectureProcesses;

	//bi-directional many-to-one association to VideoLectureProcess
	@OneToMany(mappedBy="chapter")
	private List<VideoLectureProcess> videoLectureProcesses;

	public Chapter() {
	}





	
}