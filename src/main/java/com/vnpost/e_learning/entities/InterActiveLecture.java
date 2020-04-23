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
 * The persistent class for the InterActiveLecture database table.
 * 
 */
@Entity
@Table(name = "InterActiveLecture")
@Getter
@Setter
public class InterActiveLecture extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "contents",columnDefinition = "TEXT")
	private String contents;

	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String name;

	private int status;

	private int stored;

	//bi-directional many-to-one association to CourseWare
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCourseWare")
	private CourseWare courseWare;

	//bi-directional many-to-one association to InterActiveLectureChapter
	@OneToMany(mappedBy="interActiveLecture")
	private List<InterActiveLectureChapter> interActiveLectureChapters;

	//bi-directional many-to-one association to InterActiveLectureprocess
	@OneToMany(mappedBy="interActiveLecture")
	private List<InterActiveLectureprocess> interActiveLectureprocesses;

	public InterActiveLecture() {
	}


	

}