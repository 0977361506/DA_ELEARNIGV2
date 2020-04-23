package com.vnpost.e_learning.service;

import java.util.List;

import com.vnpost.e_learning.entities.QuestionRoundTest;
import com.vnpost.e_learning.entities.RoundTest;

public interface IRoundTestService {
	public RoundTest findByid(Long id) ;
	 public List<Object[]> getListQuestionForRountest(Long id);
	 public List<Object[]> getListAnswerForRoundTesst();
	 public List<QuestionRoundTest> getListQuestionRountest(Long id);
	 public RoundTest save(RoundTest entity);

}
