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
 * The persistent class for the QuestionCategory database table.
 * 
 */
@Entity
@Table(name = "QuestionCategory")
@Getter
@Setter
public class QuestionCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "describes",columnDefinition = "nvarchar(255)")
	private String describes;
	@ManyToOne
	@JoinColumn(name = "idUnit")
	private PoscodeVnpost poscodeVnpost;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "nameCategory",columnDefinition = "nvarchar(255)")
	private String nameCategory;
	private Long parent;
	private int shares;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="questionCategory")
	private List<Question> questions;

	//bi-directional many-to-one association to TreeQuestion
	@OneToMany(mappedBy="questionCategory1")
	private List<TreeQuestion> treeQuestions1;

	//bi-directional many-to-one association to TreeQuestion
	@OneToMany(mappedBy="questionCategory2")
	private List<TreeQuestion> treeQuestions2;

	public QuestionCategory() {
	}


	
}