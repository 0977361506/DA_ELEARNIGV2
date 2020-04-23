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
 * The persistent class for the Competition database table.
 * 
 */
@Entity
@Table(name = "Competition")
@Getter
@Setter
public class Competition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "describe",columnDefinition = "TEXT")
	private String describe;
	@ManyToOne
	@JoinColumn(name = "idUnit")
	private PoscodeVnpost poscodeVnpost;

	private String imageCompetition;
	
	@LastModifiedDate
	@Column(name = "last_update")
	private Date lastUpdate;
	
	@Column(name = "nameCompetition",columnDefinition = "nvarchar(255)")
	private String nameCompetition;

	private int statusCompetition;
	
	private int highlight;
	
	@CreatedDate
	private Date timeCreate;

	private Date timeEnd;

	private Date timeStart;

	//bi-directional many-to-one association to CompetitionCategory
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCompetitionCategory")
	private CompetitionCategory competitionCategory;

	//bi-directional many-to-one association to RequirementTest
	@OneToMany(mappedBy="competition")
	private List<RequirementTest> requirementTests;

	//bi-directional many-to-one association to RoundTest
	@OneToMany(mappedBy="competition")
	private List<RoundTest> roundTests;

	public Competition() {
	}



}