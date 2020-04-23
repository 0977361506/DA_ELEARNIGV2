package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Groupposition database table.
 * 
 */
@Entity
@Table(name = "Groupposition")
@Getter
@Setter
public class Groupposition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name = "idUnit")
	private PoscodeVnpost poscodeVnpost;
	@Column(name = "nameGroup",columnDefinition = "nvarchar(255)")
	private String nameGroup;

	//bi-directional many-to-one association to KindPositionName
	@OneToMany(mappedBy="groupposition")
	private List<KindPositionName> kindPositionNames;

	public Groupposition() {
	}


}