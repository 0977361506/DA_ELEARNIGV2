package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the Coursecategory database table.
 * 
 */
@Entity
@Table(name = "Coursecategory")
@Getter
@Setter
public class Coursecategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String name;

	//bi-directional many-to-one association to Course

	@OneToMany(mappedBy="coursecategory") 
	
	private List<Course> courses;

	//bi-directional many-to-many association to Coursecategory
	@OneToMany(mappedBy = "courseCategoryOne")
	private List<CourseCategoryTree> courseCategoryTrees1 = new ArrayList<>();
    
	@OneToMany(mappedBy = "courseCategoryTwo")
	private List<CourseCategoryTree> courseCategoryTrees2 = new ArrayList<>();
	public Coursecategory() {
	}



	
}