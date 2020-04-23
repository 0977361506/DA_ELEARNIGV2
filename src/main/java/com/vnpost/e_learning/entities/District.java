package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the District database table.
 * 
 */
@Entity
@Table(name = "District")
@Getter
@Setter
public class District implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String name;

	//bi-directional many-to-one association to Provine
	@OneToMany(mappedBy="district")
	private List<Provine> provines;




}