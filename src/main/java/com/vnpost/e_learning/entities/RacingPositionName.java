package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the RacingPositionName database table.
 * 
 */
@Entity
@Table(name = "RacingPositionName")
@Setter
@Getter
public class RacingPositionName implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "describes",columnDefinition = "nvarchar(255)")
	private String describes;
	@Column(name = "racingName",columnDefinition = "nvarchar(255)")
	private String racingName;

	//bi-directional many-to-one association to PositionName
	@OneToMany(mappedBy="racingPositionName")
	private List<PositionName> positionNames;

	public RacingPositionName() {
	}



}