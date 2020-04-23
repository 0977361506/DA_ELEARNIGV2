package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Provine database table.
 * 
 */
@Entity
@Table(name = "Provine")
@Getter
@Setter
public class Provine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String name;

	//bi-directional many-to-one association to District
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idDistrict")
	private District district;

	//bi-directional many-to-one association to Ward
	@OneToMany(mappedBy="provine")
	private List<Ward> wards;

	public Provine() {
	}



}