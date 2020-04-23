package com.vnpost.e_learning.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.aspectj.weaver.patterns.IfPointcut.IfFalsePointcut;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnpost.e_learning.entities.Candidate;
import com.vnpost.e_learning.repository.CandidateRepository;
import com.vnpost.e_learning.service.ICandidateService;

import ch.qos.logback.core.net.server.Client;
@Service
public class CandicateService implements ICandidateService{
 @Autowired
 CandidateRepository candidateRepository ;
@Autowired
  EntityManager entityManager ;
public Candidate save(Candidate entity) {
	return candidateRepository.save(entity);
}

public Candidate findbyIduAndUdrAndCount(Long idu , Long idr , int sl) {
	String hqString = "from Candidate c where c.user.id=:idu and c.roundTest.id=:idr and c.counttest=:sl";
	List<Candidate> list = entityManager.unwrap(Session.class).createQuery(hqString).setParameter("idu", idu).
			setParameter("idr", idr).setParameter("sl",sl).getResultList();
	if(list.size()>0) return list.get(0);
	return null;
}

public Candidate findbyIdUser(Long id) {
	String hqlString = "from Candidate c where c.user.id=:cid and c.counttest=0";
	List<Candidate> list = entityManager.unwrap(Session.class).createQuery(hqlString).setParameter("cid",id).getResultList();

		Candidate candidate = list.get(0);
		return candidate;	

}
public List<Candidate> OrderByCandicateByCountest(Long idu , Long idr){
	String hqString = "from Candidate c where c.user.id=:idu and c.roundTest.id=:idr order by(c.counttest) desc";
	List<Candidate> list = entityManager.unwrap(Session.class).createQuery(hqString).setParameter("idu", idu).
			setParameter("idr", idr).getResultList();
	return list ;
	
}
public List<Candidate> getListByIdUser(Long id ,Long id2) {
	String hqlString = "from Candidate c where c.user.id=:cid and c.roundTest.id=:cidd";
	List<Candidate> list = entityManager.unwrap(Session.class).createQuery(hqlString).setParameter("cid",id).setParameter("cidd",id2).getResultList();
		return list;	

}

public int countByIdusser(Long id) {
	int k = 0 ; int m = 0;
	String hqlString = "from Candidate c where c.user.id=:cid";
	List<Candidate> list = entityManager.unwrap(Session.class).createQuery(hqlString).setParameter("cid",id).getResultList();
	for(Candidate c: list) {
	     if(c.getCounttest() == 0) k++;
	     else {
	    	 m++;
	     }
	}
     
	if(k==1) return 0;
	if(m!=0) return m;
	return 0;

}
}
