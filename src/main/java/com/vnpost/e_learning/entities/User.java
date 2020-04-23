package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name="Users")
@Getter
@Setter
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private Date birthday;
	@Column(name = "email",columnDefinition = "nvarchar(255)")
	private String email;

	private long idPosition;

	@ManyToOne
	@JoinColumn(name = "idUnit")
	private PoscodeVnpost poscodeVnpost;
	@Column(name = "imageUsers",columnDefinition = "nvarchar(255)")
	private String imageUsers;

	@Column(name = "username",columnDefinition = "nvarchar(255)")
	private String username;
	@Column(name = "password",columnDefinition = "nvarchar(255)")
	private String password;
	@Column(name = "phoneNumber",columnDefinition = "nvarchar(255)")
	private String phoneNumber;
	@Column(name = "place",columnDefinition = "nvarchar(255)")
	private String place;
  @OneToMany(mappedBy = "user")
  private List<AnswerComment> list;
	@Column(name = "sex")
	private int gender;
	@Column(name = "statusUsers")
	private int status;
	@LastModifiedDate
	private Date lastUpdate;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to Candidate
	@OneToMany(mappedBy="user")
	private List<Candidate> candidates;

	//bi-directional many-to-one association to Certificatee
	@OneToMany(mappedBy="user")
	private List<Certificatee> certificatees;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="user")
	private List<Comment> comments;

	//bi-directional many-to-one association to CourseJoin
	@OneToMany(mappedBy="user")
	private List<CourseJoin> courseJoins;

	//bi-directional many-to-one association to Eventt
	@OneToMany(mappedBy="user")
	private List<Eventt> eventts;

	//bi-directional many-to-one association to Formemail
	@OneToMany(mappedBy="user")
	private List<Formemail> formemails;

	//bi-directional many-to-one association to FreedomLectureProcess
	@OneToMany(mappedBy="user")
	private List<FreedomLectureProcess> freedomLectureProcesses;

	//bi-directional many-to-one association to HomeWorkAnswer
	@OneToMany(mappedBy="user")
	private List<HomeWorkAnswer> homeWorkAnswers;

	//bi-directional many-to-one association to HomeWorkLectureProcess
	@OneToMany(mappedBy="user")
	private List<HomeWorkLectureProcess> homeWorkLectureProcesses;

	//bi-directional many-to-one association to InterActiveLectureprocess
	@OneToMany(mappedBy="user")
	private List<InterActiveLectureprocess> interActiveLectureprocesses;

	//bi-directional many-to-one association to New
	@OneToMany(mappedBy="user")
	private List<New> news;

	//bi-directional many-to-one association to PowerpointLectureProcess
	@OneToMany(mappedBy="user")
	private List<PowerpointLectureProcess> powerpointLectureProcesses;

	//bi-directional many-to-one association to Rate
	@OneToMany(mappedBy="user")
	private List<Rate> rates;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="user")
	private List<Result> results;

	//bi-directional many-to-one association to ScormLectureProcess
	@OneToMany(mappedBy="user")
	private List<ScormLectureProcess> scormLectureProcesses;

	//bi-directional many-to-one association to StatisticalAction
	@OneToMany(mappedBy="user")
	private List<StatisticalAction> statisticalActions;

	//bi-directional many-to-one association to StatisticalRoundTest
	@OneToMany(mappedBy="user")
	private List<StatisticalRoundTest> statisticalRoundTests;

	//bi-directional many-to-one association to Subject
	@OneToMany(mappedBy="user")
	private List<Subject> subjects;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="user")
	private List<Test> tests;

	//bi-directional many-to-one association to UserPermistion
	@OneToMany(mappedBy="user")
	private List<UserPermistion> userPermistions;

	//bi-directional many-to-one association to UserRoleCourse
	@OneToMany(mappedBy="user")
	private List<UserRoleCourse> userRoleCourses;

	//bi-directional many-to-one association to Ward
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idWard")
	private Ward ward;

	//bi-directional many-to-one association to VideoLectureProcess
	@OneToMany(mappedBy="user")
	private List<VideoLectureProcess> videoLectureProcesses;

	@ManyToMany
	@JoinTable(name ="user_course_group",
		joinColumns = @JoinColumn(name = "idUser")
		,inverseJoinColumns = @JoinColumn(name = "idGroup"))
	private List<Group> groups = new ArrayList<>();
	public User() {
	}



}