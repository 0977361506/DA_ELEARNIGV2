package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the StructTest database table.
 * 
 */
@Entity
@Table(name = "StructTest")
@Getter
@Setter
public class StructTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private int countTest;

	@ManyToOne
	@JoinColumn(name = "idUnit")
	private PoscodeVnpost poscodeVnpost;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "nameGroup",columnDefinition = "nvarchar(255)")
	private String nameGroup;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to RoundTest
	@OneToMany(mappedBy="structTest")
	private List<RoundTest> roundTests = new ArrayList<>();

	//bi-directional many-to-one association to Levell
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idLevel")
	private Levell levell;

	//bi-directional many-to-one association to Tag
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idTag")
	private Tag tag;

	//bi-directional many-to-one association to TypeQuestion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idTypeQuestion")
	private TypeQuestion typeQuestion;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="structTest")
	private List<Test> tests = new ArrayList<>();




}