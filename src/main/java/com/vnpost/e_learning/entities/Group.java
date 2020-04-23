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
 * The persistent class for the Groups database table.
 * 
 */
@Entity
@Table(name="Groups")
@Getter
@Setter
public class Group extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String name;



	//bi-directional many-to-one association to Course
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCourse")
	private Course course;

	@ManyToMany
	@JoinTable(name = "user_course_group",
		joinColumns = @JoinColumn(name = "idGroup")
		,inverseJoinColumns = @JoinColumn(name = "idUser"))
	private List<User> users = new ArrayList<>();
	public Group() {
	}




}