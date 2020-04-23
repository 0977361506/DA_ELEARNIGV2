package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the LimitDocument database table.
 * 
 */
@Entity
@Table(name = "LimitDocument")
@Getter
@Setter
public class LimitDocument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "nameLimit",columnDefinition = "nvarchar(255)")
	private String nameLimit;

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="limitDocument")
	private List<Document> documents;

	public LimitDocument() {
	}


}