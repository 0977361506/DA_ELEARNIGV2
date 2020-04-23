package com.vnpost.e_learning.service.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.vnpost.e_learning.entities.Course;
import com.vnpost.e_learning.entities.Rate;
import com.vnpost.e_learning.repository.RateRepository;
import com.vnpost.e_learning.service.IRateService;

@Service
public class RateService  implements IRateService{
  @Autowired
  RateRepository rateRepository;
@Autowired
EntityManagerFactory entityManagerFactory ;
public  Rate  save(Rate entity) {
	return rateRepository.save(entity);
}

public List<Rate> findAll() {
	return rateRepository.findAll();
}
public List<Rate> sortByid(Long id){
	 Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
	String hqString = "from Rate r  where r.course.id=:cid order by r.id desc";
	  Query query = session.createQuery(hqString);
	  query.setParameter("cid", id);
	List<Rate> list = query.getResultList();
	return list ;
}
public long count() {
	return rateRepository.count();
}

public Rate findbyId(Long id) {
	 Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
	 return session.find(Rate.class, id);
	
}
  public Course getFromCourse(Long id) {
	  Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
	  String hqlString = "select course from Rate c where c.course.id=:cid ";
	  Query query = session.createQuery(hqlString);
	  query.setParameter("cid", id);
	  List<Course> list  = query.getResultList();
	  for(Course c : list) {
		  if(c.getId()==id) return c;
	  }
	  return null;

	  
	  
  }
  public List<Rate> getRateFromCourse(Long id){
	  Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
	  String hqlString = " from Rate c where c.course.id=:cid ";
	  Query query = session.createQuery(hqlString);
	  query.setParameter("cid", id);
	  List<Rate> list  = query.getResultList();
	  return list;
  }
  
}
