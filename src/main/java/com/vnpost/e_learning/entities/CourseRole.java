package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CourseRole database table.
 * 
 */
@Entity
@Table(name = "CourseRole")
@Getter
@Setter
public class CourseRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "nameCourse")
	private String name;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to RoleCourseAction
	@OneToMany(mappedBy="courseRole")
	private List<RoleCourseAction> roleCourseActions;

	//bi-directional many-to-one association to UserRoleCourse
	@OneToMany(mappedBy="courseRole")
	private List<UserRoleCourse> userRoleCourses;

	public CourseRole() {
	}


}