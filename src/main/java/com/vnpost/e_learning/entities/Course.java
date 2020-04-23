package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Course database table.
 * 
 */
@Entity
@Table(name = "Course")
@Getter
@Setter
public class Course extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name = "avatar",columnDefinition = "nvarchar(255)")
	private String avatar;

	@Column(name = "description",columnDefinition = "TEXT")
	private String description;

	private int highlight;
  
	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String name;
	@Column(name = "code",columnDefinition = "nvarchar(255)")
	private String code;
	private int price;

	private int showName;// bien thi ten giang vien
	@OneToOne
	@JoinColumn(name = "id_tag")
	private Tag tag;

	private int status;  // trang thi hojc
    
	private int stepbystep; // lam tung buoec

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="course")
	private List<Comment> comments;

	//bi-directional many-to-one association to Coursecategory
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCourseCategory")
	private Coursecategory coursecategory;

	//bi-directional many-to-one association to CourseConfig

	@OneToOne(mappedBy="course")
	private CourseConfig courseConfig;

	//bi-directional many-to-many association to Course
	@JsonIgnore
	@ManyToMany
	@JoinTable(
		name="CourseCourse"
		, joinColumns={
			@JoinColumn(name="idCourse2")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idCourse")
			}
		)
	private List<Course> courses1;

	//bi-directional many-to-many association to Course
	@JsonIgnore
	@ManyToMany(mappedBy="courses1")
	private List<Course> courses2;

	//bi-directional many-to-one association to CourseRequirement
	@OneToMany(mappedBy="course")
	private List<CourseRequirement> courseRequirements;

	//bi-directional many-to-one association to Group
	@OneToMany(mappedBy="course")
	private List<Group> groups;

	//bi-directional many-to-one association to Outline
	@OneToOne(mappedBy="course")
	private Outline outline;

	//bi-directional many-to-one association to Rate
	@OneToMany(mappedBy="course")
	private List<Rate> rates = new ArrayList<>();

	//bi-directional many-to-one association to UserRoleCourse
	@OneToMany(mappedBy="course")
	private List<UserRoleCourse> userRoleCourses = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "CourseDocument",joinColumns = @JoinColumn(name = "idCourse")
			,inverseJoinColumns = @JoinColumn(name = "idDocument"))
	List<Document> documents = new ArrayList<>();
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idposcodeVnpost")
	private PoscodeVnpost poscodeVnpost;
	@JsonIgnore
	@OneToMany(mappedBy="course")
	private List<CourseJoin> courseJoins;

	@ManyToMany
	@JoinTable(name = "poscode_vnpost_course"
	,	joinColumns = @JoinColumn(name = "id_course")
	,inverseJoinColumns = @JoinColumn(name = "id_poscode_vnpost"))
	private List<PoscodeVnpost> poscodeVnposts = new ArrayList<>();



	
}