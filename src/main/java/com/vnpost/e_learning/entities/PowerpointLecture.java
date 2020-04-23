package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PowerpointLecture database table.
 * 
 */
@Entity
@Table(name = "PowerpointLecture")
@Getter
@Setter
public class PowerpointLecture extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name = "description",columnDefinition = "Text")
	private String description;
	@Column(name = "files",columnDefinition = "TEXT")
	private String files;


	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String name;

	private int shared;

	private int stored;

	@Column(name="Totallearn")
	private int totallearn;

	//bi-directional many-to-one association to ChapterPowerpointlecture
	@OneToMany(mappedBy="powerpointLecture")
	private List<ChapterPowerpointlecture> chapterPowerpointlectures;

	//bi-directional many-to-one association to CourseWare
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCourseWare")
	private CourseWare courseWare;

	//bi-directional many-to-one association to PowerpointLectureProcess
	@OneToMany(mappedBy="powerpointLecture")
	private List<PowerpointLectureProcess> powerpointLectureProcesses;


}