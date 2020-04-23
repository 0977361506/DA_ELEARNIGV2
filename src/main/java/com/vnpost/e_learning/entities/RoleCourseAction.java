package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the RoleCourseAction database table.
 * 
 */
@Entity
@Table(name = "RoleCourseAction")
@Getter
@Setter
public class RoleCourseAction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private long idActionCourse;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "nameAction",columnDefinition = "nvarchar(255)")
	private String nameAction;

	private int statusAction;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to CourseRole
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCourseRole")
	private CourseRole courseRole;

	public RoleCourseAction() {
	}



}