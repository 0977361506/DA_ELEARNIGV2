package com.vnpost.e_learning.service.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnpost.e_learning.entities.CourseCategoryTree;
import com.vnpost.e_learning.entities.Coursecategory;
import com.vnpost.e_learning.repository.CoursesCategoryRespository;
import com.vnpost.e_learning.service.ICoursesCategoryTreeService;

@Service
public class CoursesCategoryTreeService implements ICoursesCategoryTreeService{
  @Autowired
  CoursesCategoryRespository c;
  @Autowired
  EntityManagerFactory entityManagerFactory;

public List<Coursecategory> findAll() {
	Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
	
	String qString = "select  distinct  c.courseCategoryOne from CourseCategoryTree c";
	Query query = session.createQuery(qString);
	List<Coursecategory> list = query.getResultList();
	return list;
}
public List<CourseCategoryTree> findCategoryByid(Long id) {
	Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
	
	String qString = "from CourseCategoryTree c where c.courseCategoryOne.id=:cid ";
	Query query = session.createQuery(qString);
	query.setParameter("cid", id);
	List<CourseCategoryTree> list = query.getResultList();
	if(list!=null) return list;
	
	return null;
}

public long count() {
	return c.count();
}
  
}
