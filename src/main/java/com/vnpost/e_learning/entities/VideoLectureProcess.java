package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;




/**
 * The persistent class for the VideoLectureProcess database table.
 * 
 */
@Entity
@Table(name = "VideoLectureProcess")
@Getter
@Setter
public class VideoLectureProcess extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;


	private int finished;

	private int lasttimeview;



	//bi-directional many-to-one association to Chapter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idChapter")
	private Chapter chapter;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private User user;

	//bi-directional many-to-one association to VideoLecture
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idVideoLecture")
	private VideoLecture videoLecture;

	public VideoLectureProcess() {
	}



}