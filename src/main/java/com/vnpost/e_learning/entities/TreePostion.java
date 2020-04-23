package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TreePostion database table.
 * 
 */
@Entity
@Table(name = "TreePostion")
@Getter
@Setter
public class TreePostion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name = "describes",columnDefinition = "nvarchar(255)")
	private String describes;

	private int levels;

	//bi-directional many-to-one association to PositionName
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idPositionname")
	private PositionName positionName;

	//bi-directional many-to-one association to Routeposition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idRouteposition")
	private Routeposition routeposition;

	public TreePostion() {
	}



}