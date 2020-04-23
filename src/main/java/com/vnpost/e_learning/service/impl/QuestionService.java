package com.vnpost.e_learning.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import com.vnpost.e_learning.entities.Question;
import com.vnpost.e_learning.entities.Result;
import com.vnpost.e_learning.service.IQuestionService;
@Service
public class QuestionService implements IQuestionService{
  @Autowired
  EntityManager entityManager ;
  public Question findbyId(Long id) {
	  return entityManager.unwrap(Session.class).find(Question.class, id);
  }

}
