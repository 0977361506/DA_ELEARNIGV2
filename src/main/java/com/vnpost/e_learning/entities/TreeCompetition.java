package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;




/**
 * The persistent class for the TreeCompetition database table.
 * 
 */
@Entity
@Table(name = "TreeCompetition")
@Getter
@Setter
public class TreeCompetition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@LastModifiedDate
	private Date lastUpdate;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to CompetitionCategory
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCompetitionCategoryOne")
	private CompetitionCategory competitionCategory1;

	//bi-directional many-to-one association to CompetitionCategory
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCompetitionCategoryTwo")
	private CompetitionCategory competitionCategory2;



}