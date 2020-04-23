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
 * The persistent class for the Condition database table.
 * 
 */
@Entity
@Table(name = "Condition")
@Getter
@Setter
public class Condition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "nameCondition",columnDefinition = "nvarchar(255)")
	private String nameCondition;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to RoundTest
	@OneToMany(mappedBy="condition")
	private List<RoundTest> roundTests;

	public Condition() {
	}


	
}