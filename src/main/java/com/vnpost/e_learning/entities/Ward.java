package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Ward database table.
 * 
 */
@Entity
@Table(name = "Ward")
@Getter
@Setter
public class Ward implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String name;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="ward")
	private List<User> users;

	//bi-directional many-to-one association to Provine
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idProvine")
	private Provine provine;


}