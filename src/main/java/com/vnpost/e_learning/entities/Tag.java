package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Tags database table.
 * 
 */
@Entity
@Table(name="Tags")
@Getter
@Setter
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
    @OneToOne
  
    private Course course;
	private Date lastUpdate;
	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String name;

	private Date timeCreate;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="tag")
	private List<Question> questions;

	//bi-directional many-to-one association to StructTest
	@OneToMany(mappedBy="tag")
	private List<StructTest> structTests;


}