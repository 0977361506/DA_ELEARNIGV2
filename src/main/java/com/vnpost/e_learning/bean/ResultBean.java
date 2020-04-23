package com.vnpost.e_learning.bean;

import java.util.List;

import org.springframework.stereotype.Component;

import com.vnpost.e_learning.entities.Answer;
import com.vnpost.e_learning.entities.Question;
import com.vnpost.e_learning.entities.TypeQuestion;
@Component
public class ResultBean {
	 private int index;
	  private Question question ;
	  private List<String> ans;
	  private TypeQuestion typeQuestion ;
	  private int check;
	public ResultBean() {

	}
	public ResultBean(int index, Question question, List<String> ans, TypeQuestion typeQuestion) {
	
		this.index = index;
		this.question = question;
		this.ans = ans;
		this.typeQuestion = typeQuestion;
	}
	public int getIndex() {
		return index;
	}
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	public ResultBean(int index, Question question, List<String> ans, TypeQuestion typeQuestion, int check) {
		
		this.index = index;
		this.question = question;
		this.ans = ans;
		this.typeQuestion = typeQuestion;
		this.check = check;
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
	public List<String> getAns() {
		return ans;
	}
	public void setAns(List<String> ans) {
		this.ans = ans;
	}
	public TypeQuestion getTypeQuestion() {
		return typeQuestion;
	}
	public void setTypeQuestion(TypeQuestion typeQuestion) {
		this.typeQuestion = typeQuestion;
	}
}
