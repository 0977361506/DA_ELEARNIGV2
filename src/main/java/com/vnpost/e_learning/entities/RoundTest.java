package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the RoundTest database table.
 * 
 */
@Entity
@Table(name = "RoundTest")
@Getter
@Setter
public class RoundTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private int autoCreateQuestion;
	@Column(name = "codeRoundTest",columnDefinition = "nvarchar(255)")
	private String codeRoundTest;

	@Column(name = "describes",columnDefinition = "TEXT")
	private String describes;

	private int doAgain;

	private int fullTickAnswer;

	private int giveCertificate;


	@LastModifiedDate
	private Date lastUpdate;

	private int maxPoint;

	private int maxWork;

	private int minPoint;

	private int mixAnswer; // dảo câu hỏi
	@Column(name = "nameRound",columnDefinition = "nvarchar(255)")
	private String nameRound;

	private int showResutl;
	private int showAnswer;
	private int showExplain;

	private int sourceQuestion;

	private int statusRound;
	@CreatedDate
	private Date timeCreate;
	
	
	
	
	private Date timeEnd;
 
	private int timeRound;

	private Date timeStart;
//	@ManyToOne
//	@JoinColumn(name = "idUnit")
//	private PoscodeVnpost poscodeVnpost;
	//bi-directional many-to-one association to AddPoint
	@OneToMany(mappedBy="roundTest")
	private List<AddPoint> addPoints;

	//bi-directional many-to-one association to Candidate
	@OneToMany(mappedBy="roundTest")
	private List<Candidate> candidates;

	//bi-directional many-to-one association to Certificatee
	@OneToMany(mappedBy="roundTest")
	private List<Certificatee> certificatees;

	//bi-directional many-to-one association to GroupTest
	@OneToMany(mappedBy="roundTest")
	private List<GroupTest> groupTests;

	//bi-directional many-to-one association to QuestionRoundTest
	@OneToMany(mappedBy="roundTest")
	private List<QuestionRoundTest> questionRoundTests;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="roundTest")
	private List<Result> results;

	//bi-directional many-to-one association to Competition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCompetition")
	private Competition competition;

	//bi-directional many-to-one association to Condition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCondition")
	private Condition condition;

	//bi-directional many-to-one association to MixCompetition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idMixCompettion")
	private MixCompetition mixCompetition;

	//bi-directional many-to-one association to StructTest
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idStructTest")
	private StructTest structTest;

	//bi-directional many-to-one association to SourceQuestion
	@OneToMany(mappedBy="roundTest")
	private List<SourceQuestion> sourceQuestions;

	//bi-directional many-to-one association to StatisticalRoundTest
	@OneToMany(mappedBy="roundTest")
	private List<StatisticalRoundTest> statisticalRoundTests;

	//bi-directional many-to-one association to SubPoint
	@OneToMany(mappedBy="roundTest")
	private List<SubPoint> subPoints;


}