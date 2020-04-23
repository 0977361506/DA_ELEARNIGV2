package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the GroupTest database table.
 * 
 */
@Entity
@Table(name = "GroupTest")
@Getter
@Setter
public class GroupTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "nameGroup",columnDefinition = "nvarchar(255)")
	private String nameGroup;

	//bi-directional many-to-one association to Candidate
	@OneToMany(mappedBy="groupTest")
	private List<Candidate> candidates;

	//bi-directional many-to-one association to RoundTest
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idRoundTest")
	private RoundTest roundTest;

	public GroupTest() {
	}




}