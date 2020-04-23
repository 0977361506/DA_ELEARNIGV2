package com.vnpost.e_learning.service.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnpost.e_learning.entities.Course;
import com.vnpost.e_learning.entities.CourseJoin;
import com.vnpost.e_learning.repository.CourseJoinRepository;
import com.vnpost.e_learning.service.ICourseJoinService;

@Service

public class CourseJoinService implements ICourseJoinService{
  @Autowired
  CourseJoinRepository c;
  @Autowired
  EntityManagerFactory entityManagerFactory;
  public List<Course> getListByCourseJion(Long id){
	  Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
	  String hqlString = "select course from CourseJoin c where c.user.id=:cid ";
	  Query query = session.createQuery(hqlString);
	  query.setParameter("cid", id);
	  List<Course> list  = query.getResultList();
	  return list;
  }
 
}
