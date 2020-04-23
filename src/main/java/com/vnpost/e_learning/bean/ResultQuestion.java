package com.vnpost.e_learning.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ResultQuestion {
  private Long idquestion; 
  private Long iduser;
  private Long idRoundtest;
 private List<String> check;
 private List<String> nocheck;
 private int count ;
 
public ResultQuestion(Long idquestion, Long iduser, Long idRoundtest, List<String> check, List<String> nocheck,
		int count) {
	
	this.idquestion = idquestion;
	this.iduser = iduser;
	this.idRoundtest = idRoundtest;
	this.check = check;
	this.nocheck = nocheck;
	this.count = count;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public Long getIdquestion() {
	return idquestion;
}
public void setIdquestion(Long idquestion) {
	this.idquestion = idquestion;
}
public Long getIduser() {
	return iduser;
}
public void setIduser(Long iduser) {
	this.iduser = iduser;
}
public Long getIdRoundtest() {
	return idRoundtest;
}
public void setIdRoundtest(Long idRoundtest) {
	this.idRoundtest = idRoundtest;
}
public List<String> getCheck() {
	return check;
}
public void setCheck(List<String> check) {
	this.check = check;
}
public List<String> getNocheck() {
	return nocheck;
}
public void setNocheck(List<String> nocheck) {
	this.nocheck = nocheck;
}
public ResultQuestion(Long idquestion, Long iduser, Long idRoundtest, List<String> check, List<String> nocheck) {
	
	this.idquestion = idquestion;
	this.iduser = iduser;
	this.idRoundtest = idRoundtest;
	this.check = check;
	this.nocheck = nocheck;
}
public ResultQuestion() {
	
}
 
  
  
}