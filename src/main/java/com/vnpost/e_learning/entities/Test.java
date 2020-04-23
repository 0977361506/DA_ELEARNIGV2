package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Test database table.
 * 
 */
@Entity
@Table(name = "Test")
@Getter
@Setter
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String name;
	@CreatedDate
	private Date timeCreate;

	private int typeTest;

	//bi-directional many-to-one association to QuestionTest
	@OneToMany(mappedBy="test")
	private List<QuestionTest> questionTests;

	//bi-directional many-to-one association to StructTest
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idStructTest")
	private StructTest structTest;

	//bi-directional many-to-one association to TestKit
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idTestKit")
	private TestKit testKit;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private User user;



	}