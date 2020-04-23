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
 * The persistent class for the CompetitionCategory database table.
 * 
 */
@Entity
@Table(name ="CompetitionCategory" )
@Getter
@Setter
public class CompetitionCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "describes",columnDefinition = "nvarchar(255)")
	private String describes;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "nameCompetition",columnDefinition = "nvarchar(255)")
	private String nameCompetition;
	@CreatedDate
	private Date timeCreate;
	private Long parent;
	
	//bi-directional many-to-one association to Competition
	@OneToMany(mappedBy="competitionCategory")
	private List<Competition> competitions;

	//bi-directional many-to-one association to TreeCompetition
	@OneToMany(mappedBy="competitionCategory1")
	private List<TreeCompetition> treeCompetitions1;

	//bi-directional many-to-one association to TreeCompetition
	@OneToMany(mappedBy="competitionCategory2")
	private List<TreeCompetition> treeCompetitions2;



	
}