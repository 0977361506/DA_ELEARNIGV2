package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the KindPositionName database table.
 * 
 */
@Entity
@Table(name = "KindPositionName")
@Getter
@Setter
public class KindPositionName implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "namePostion",columnDefinition = "nvarchar(255)")
	private String namePostion;

	//bi-directional many-to-one association to Groupposition
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idGroupposition")
	private Groupposition groupposition;

	//bi-directional many-to-one association to PositionName
	@OneToMany(mappedBy = "kindPositionName")
	private List<PositionName> positionNames;

	public KindPositionName() {
	}

}