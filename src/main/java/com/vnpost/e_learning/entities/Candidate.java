package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the Candidates database table.
 * 
 */
@Entity
@Table(name="Candidates")
@Getter
@Setter
public class Candidate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@LastModifiedDate
	@Column(name = "lastUpdate")
	private Date lastUpdate;
	@Column(name = "statusCandidates")
	private int status;
	@CreatedDate
	@Column(name = "timeCreate")
	private Date timeCreate;
    private int counttest;
    private  Integer result;
    private Integer point ;
	private Date timeend;
     private Long timeouts ;
	private Date timestart;
	//bi-directional many-to-one association to GroupTest
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idGroupTest")
	private GroupTest groupTest;

	//bi-directional many-to-one association to RoundTest
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idRoundTest")
	private RoundTest roundTest;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private User user;

	public Candidate() {
	}


	

}