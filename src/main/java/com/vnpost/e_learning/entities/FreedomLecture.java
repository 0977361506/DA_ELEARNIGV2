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
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the FreedomLecture database table.
 * 
 */
@Entity
@Table(name = "FreedomLecture")
@Getter
@Setter
public class FreedomLecture extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "contents",columnDefinition = "TEXT")
	private String contents;

	@Column(name = "description",columnDefinition = "TEXT")
	private String description;
	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String name;

	private int shared;

	private int stored;
	@ManyToOne
	@JoinColumn(name = "idCourseWare")
	private CourseWare courseWare ;



	//bi-directional many-to-one association to ChapterFreedomLecture
	@OneToMany(mappedBy="freedomLecture")
	private List<ChapterFreedomLecture> chapterFreedomLectures;

	//bi-directional many-to-one association to FreedomLectureProcess
	@OneToMany(mappedBy="freedomLecture")
	private List<FreedomLectureProcess> freedomLectureProcesses;



}