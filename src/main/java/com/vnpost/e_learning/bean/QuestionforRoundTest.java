package com.vnpost.e_learning.bean;

import java.util.List;

import org.springframework.stereotype.Component;

import com.vnpost.e_learning.entities.Answer;
import com.vnpost.e_learning.entities.Question;
import com.vnpost.e_learning.entities.TypeQuestion;

@Component
public class QuestionforRoundTest {
  private int index;
  private Question question ;
  private List<Answer> answers;
  private TypeQuestion typeQuestion ;
public int getIndex() {
	return index;
}
public void setIndex(int index) {
	this.index = index;
}
public Question getQuestion() {
	return question;
}
public void setQuestion(Question question) {
	this.question = question;
}
public List<Answer> getAnswers() {
	return answers;
}
public void setAnswers(List<Answer> answers) {
	this.answers = answers;
}

public TypeQuestion getTypeQuestion() {
	return typeQuestion;
}
public QuestionforRoundTest(int index, Question question, List<Answer> answers, TypeQuestion typeQuestion) {
	
	this.index = index;
	this.question = question;
	this.answers = answers;
	this.typeQuestion = typeQuestion;
}
public void setTypeQuestion(TypeQuestion typeQuestion) {
	this.typeQuestion = typeQuestion;
}
public QuestionforRoundTest() {
	
}
  
}
