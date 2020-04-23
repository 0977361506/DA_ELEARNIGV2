package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TypeQuestion database table.
 * 
 */
@Entity
@Table(name = "TypeQuestion")
@Getter
@Setter
public class TypeQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "nameType",columnDefinition = "nvarchar(255)")
	private String nameType;
	@CreatedDate
	private Date timeCreate;

//	//bi-directional many-to-one association to AddPoint
//	@OneToMany(mappedBy="typeQuestion")
//	private List<AddPoint> addPoints;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="typeQuestion")
	private List<Question> questions;

	//bi-directional many-to-one association to StructTest
	@OneToMany(mappedBy="typeQuestion")
	private List<StructTest> structTests;

//	//bi-directional many-to-one association to SubPoint
//	@OneToMany(mappedBy="typeQuestion")
//	private List<SubPoint> subPoints;

	public TypeQuestion() {
	}



}