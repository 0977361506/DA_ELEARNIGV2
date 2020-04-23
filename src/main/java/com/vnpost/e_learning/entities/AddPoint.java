package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the AddPoint database table.
 * 
 */
@Entity
@Table(name = "AddPoint")
@Getter
@Setter
public class AddPoint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private int addPoint;
	@LastModifiedDate
	private Date lastUpdate;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to RoundTest
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idRoundTest")
	private RoundTest roundTest;

	//bi-directional many-to-one association to TypeQuestion
	//@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="idTypeQuestion")
	//private TypeQuestion typeQuestion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idLevel")
	private Levell levells;

	public AddPoint() {
	}



}