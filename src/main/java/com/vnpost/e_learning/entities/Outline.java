package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


/**
 * The persistent class for the Outline database table.
 * 
 */
@Entity
@Table(name = "Outline")
@Getter
@Setter
public class Outline implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String name;

	@OneToMany(mappedBy = "outline")
	private List<Chapter> chapters = new ArrayList<>();

	//bi-directional many-to-one association to Course
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCourse")
	private Course course;

	public Outline() {
	}



}