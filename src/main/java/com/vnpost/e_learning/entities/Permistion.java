package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Permistion database table.
 * 
 */
@Entity
@Table(name = "Permistion")
@Getter
@Setter
public class Permistion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "codename",columnDefinition = "nvarchar(255)")
	private String codename;
	@Column(name = "namePermistion",columnDefinition = "nvarchar(255)")
	private String namePermistion;
	
	private Long parent;
	
	//bi-directional many-to-one association to DetailPermisstion
	@OneToMany(mappedBy="permistion")
	private List<DetailPermisstion> detailPermisstions;

	//bi-directional many-to-one association to TreePermistion
	@OneToMany(mappedBy="permistion1")
	private List<TreePermistion> treePermistions1;

	//bi-directional many-to-one association to TreePermistion
	@OneToMany(mappedBy="permistion2")
	private List<TreePermistion> treePermistions2;

	//bi-directional many-to-one association to UserPermistion
	@OneToMany(mappedBy="permistion")
	private List<UserPermistion> userPermistions;

	public Permistion() {
	}


}