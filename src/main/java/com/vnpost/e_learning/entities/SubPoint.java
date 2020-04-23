package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;




/**
 * The persistent class for the SubPoint database table.
 * 
 */
@Entity
@Table(name = "SubPoint")
@Getter
@Setter
public class SubPoint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@LastModifiedDate
	private Date lastUpdate;

	private int sub;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to RoundTest
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idRoundTest")
	private RoundTest roundTest;

//	//bi-directional many-to-one association to TypeQuestion
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="idTypeQuestion")
//	private TypeQuestion typeQuestion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idLevel")
	private Levell levells;

	public SubPoint() {
	}


}