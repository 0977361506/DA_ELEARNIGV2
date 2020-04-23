package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the PositionName database table.
 * 
 */
@Entity
@Table(name = "PositionName")
@Getter
@Setter
public class PositionName implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "namePosition",columnDefinition = "nvarchar(255)")
	private String namePosition;

	@Column(name = "requestContent",columnDefinition = "Text")
	private String requestContent;

	//bi-directional many-to-one association to CourseRequirement
	@OneToMany(mappedBy="positionName")
	private List<CourseRequirement> courseRequirements;

	//bi-directional many-to-one association to KindPositionName
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idKindPosition")
	private KindPositionName kindPositionName;

	//bi-directional many-to-one association to RacingPositionName
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idRacing")
	private RacingPositionName racingPositionName;

	//bi-directional many-to-one association to RequirementTest
	@OneToMany(mappedBy="positionName")
	private List<RequirementTest> requirementTests;

	//bi-directional many-to-one association to TreePostion
	@OneToMany(mappedBy="positionName")
	private List<TreePostion> treePostions;

	public PositionName() {
	}



}