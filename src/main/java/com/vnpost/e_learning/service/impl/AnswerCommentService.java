package com.vnpost.e_learning.service.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnpost.e_learning.entities.AnswerComment;
import com.vnpost.e_learning.entities.Course;
import com.vnpost.e_learning.repository.AnswerCommentRespository;
import com.vnpost.e_learning.service.IAnswerCommentService;

@Service
public class AnswerCommentService  implements IAnswerCommentService{
  @Autowired
  AnswerCommentRespository cm;
  @Autowired
  EntityManagerFactory en;
public AnswerComment save(AnswerComment entity) {
	return cm.save(entity);
}

@Override
public AnswerComment findById(Long id) {
	Session session = en.createEntityManager().unwrap(Session.class);
	AnswerComment aNew = session.find(AnswerComment.class, id);
	return aNew;
}

public List<AnswerComment> findAll() {
	return (List<AnswerComment>) cm.findAll();
}



public long count() {
	return cm.count();
}
  
}
