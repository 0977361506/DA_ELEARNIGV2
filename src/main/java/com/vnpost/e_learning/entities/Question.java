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
 * The persistent class for the Question database table.
 * 
 */
@Entity
@Table(name = "Question")
@Getter
@Setter
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Lob
	private String explain;
	@ManyToOne
	@JoinColumn(name = "idTypeQuestion")
	private TypeQuestion typeQuestion;
	@LastModifiedDate
	private Date lastUpdate;

	private int mix;

	@Column(name = "question",columnDefinition = "TEXT")
	private String question;

	private int statusQuestion;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to Answer
	@OneToMany(mappedBy="question")
	private List<Answer> answers;

	//bi-directional many-to-one association to Levell
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idLevel")
	private Levell levell;

	//bi-directional many-to-one association to QuestionCategory
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idQuestionCategory")
	private QuestionCategory questionCategory;

	//bi-directional many-to-one association to Tag
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idTag")
	private Tag tag;



	//bi-directional many-to-one association to QuestionRoundTest
	@OneToMany(mappedBy="question")
	private List<QuestionRoundTest> questionRoundTests;

	//bi-directional many-to-one association to QuestionTest
	@OneToMany(mappedBy="question")
	private List<QuestionTest> questionTests;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="question")
	private List<Result> results;

	public Question() {
	}


}