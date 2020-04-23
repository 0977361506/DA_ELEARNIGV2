package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the MixCompetition database table.
 * 
 */
@Entity
@Table(name = "MixCompetition")
@Getter
@Setter
public class MixCompetition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "nameMix",columnDefinition = "nvarchar(255)")
	private String nameMix;

	//bi-directional many-to-one association to RoundTest
	@OneToMany(mappedBy="mixCompetition")
	private List<RoundTest> roundTests;

	public MixCompetition() {
	}


}