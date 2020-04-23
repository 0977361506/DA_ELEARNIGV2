package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Levell database table.
 * 
 */
@Entity
@Table(name = "Levell")
@Getter
@Setter
public class Levell implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "nameLevell",columnDefinition = "nvarchar(255)")
	private String nameLevell;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="levell")
	private List<Question> questions;

	//bi-directional many-to-one association to StructTest
	@OneToMany(mappedBy="levell")
	private List<StructTest> structTests;
	
 //bi-directional many-to-one association to AddPoint
	 @OneToMany(mappedBy="levells")
	 private List<AddPoint> addPoints;
		
	 	//bi-directional many-to-one association to SubPoint
	 	@OneToMany(mappedBy="levells")
	 	private List<SubPoint> subPoints;

	public Levell() {
	}


}