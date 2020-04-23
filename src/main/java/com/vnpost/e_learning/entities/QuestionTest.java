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
 * The persistent class for the QuestionTest database table.
 * 
 */
@Entity
@Table(name = "QuestionTest")
@Setter
@Getter
public class QuestionTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@LastModifiedDate
	private Date lastUpdate;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to Question
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idQuestion")
	private Question question;

	//bi-directional many-to-one association to Test
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTest")
	private Test test;

	public QuestionTest() {
	}

}