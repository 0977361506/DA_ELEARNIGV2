package com.vnpost.e_learning.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.vnpost.e_learning.entities.QuestionRoundTest;
import com.vnpost.e_learning.entities.RoundTest;
import com.vnpost.e_learning.repository.RoundTestRepository;
import com.vnpost.e_learning.service.IRoundTestService;
@Service
public class RoundTestService implements IRoundTestService {
   @Autowired
   RoundTestRepository r;
  public RoundTest save(RoundTest entity) {
	return r.save(entity);
}

@PersistenceContext
  EntityManager  entityManager ;
  public RoundTest findByid(Long id) {
	  return entityManager.unwrap(Session.class).find(RoundTest.class, id);
  }
  
  public List<Object[]> getListQuestionForRountest(Long id) {
		StoredProcedureQuery query = entityManager
			    .createStoredProcedureQuery("getListQuestionForRoundTesst")
			    .registerStoredProcedureParameter(
			        "id", Long.class, ParameterMode.IN)
//			   
				    .setParameter("id", id);

			query.execute();
			List<Object[]> result = query.getResultList();
		
		return result;
	} //getListAnswerForRoundTesst
  
  public List<Object[]> getListAnswerForRoundTesst() {
		StoredProcedureQuery query = entityManager
			    .createStoredProcedureQuery("getListAnswerForRoundTesst")
			 ;

			query.execute();
			List<Object[]> result = query.getResultList();
		
		return result;
	}

@Override
public List<QuestionRoundTest> getListQuestionRountest(Long id) {
	String hqlString = "from QuestionRoundTest q where q.roundTest.id=:cid";
	List<QuestionRoundTest> list =  entityManager.unwrap(Session.class).createQuery(hqlString).setParameter("cid", id).getResultList();		
	return list;
}
}
