package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;




/**
 * The persistent class for the Subjects database table.
 * 
 */
@Entity
@Table(name="Subjects")
@Getter
@Setter
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name = "describes",columnDefinition = "nvarchar(255)")
	private String describes;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "nameSubjects",columnDefinition = "nvarchar(255)")
	private String nameSubjects;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private User user;

	public Subject() {
	}



}