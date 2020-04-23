package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Routeposition database table.
 * 
 */
@Entity
@Table(name = "Routeposition")
@Getter
@Setter
public class Routeposition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "describe",columnDefinition = "TEXT")
	private String describe;
	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String name;

	//bi-directional many-to-one association to TreePostion
	@OneToMany(mappedBy="routeposition")
	private List<TreePostion> treePostions;

	public Routeposition() {
	}



}