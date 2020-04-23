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


/**
 * The persistent class for the HomeWorkAnswer database table.
 * 
 */
@Entity
@Table(name = "HomeWorkAnswer")
@Getter
@Setter
public class HomeWorkAnswer extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "contents",columnDefinition = "TEXT")
	private String contents;

	@Column(name = "files",columnDefinition = "nvarchar(255)")
	private String files;


	//bi-directional many-to-one association to HomeWorkLectureProcess
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idHomeWorkLectureProcess")
	private HomeWorkLectureProcess homeWorkLectureProcess;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private User user;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCourseWareProcess")
	private CourseWareProcess courseWareProcess;

}