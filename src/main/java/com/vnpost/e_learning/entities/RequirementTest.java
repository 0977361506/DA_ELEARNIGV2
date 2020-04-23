package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RequirementTest database table.
 * 
 */
@Entity
@Table(name = "RequirementTest")
@Getter
@Setter
public class RequirementTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	//bi-directional many-to-one association to Competition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCompetition")
	private Competition competition;

	//bi-directional many-to-one association to PositionName
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idPositionname")
	private PositionName positionName;



}