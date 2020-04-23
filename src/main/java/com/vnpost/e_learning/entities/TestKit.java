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
 * The persistent class for the TestKit database table.
 * 
 */
@Entity
@Table(name = "TestKit")
@Getter
@Setter
public class TestKit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name = "describes",columnDefinition = "TEXT")
	private String describes;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "nameTest",columnDefinition = "nvarchar(255)")
	private String nameTest;
	@CreatedDate
	private Date timeCreate;
	private Long parent;
	
	//bi-directional many-to-one association to SourceQuestion
	@OneToMany(mappedBy="testKit")
	private List<SourceQuestion> sourceQuestions;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="testKit")
	private List<Test> tests;

	//bi-directional many-to-one association to TreeTestKit
	@OneToMany(mappedBy="testKit1")
	private List<TreeTestKit> treeTestKits1;

	//bi-directional many-to-one association to TreeTestKit
	@OneToMany(mappedBy="testKit2")
	private List<TreeTestKit> treeTestKits2;

	public TestKit() {
	}



}