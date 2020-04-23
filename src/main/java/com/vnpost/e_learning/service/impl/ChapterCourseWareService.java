package com.vnpost.e_learning.service.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnpost.e_learning.entities.CourseWare;
import com.vnpost.e_learning.repository.ChapterCourseWareResponsitory;
import com.vnpost.e_learning.service.IChapterCourseWareService;

@Service
public class ChapterCourseWareService implements IChapterCourseWareService {
  @Autowired
  ChapterCourseWareResponsitory chapterCourseWareResponsitory;
  @Autowired
  EntityManagerFactory entityManagerFactory;
  public List<CourseWare> getListCourseWareFromChapterCourseWare(Long id){
	  Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
	  String hqString = "select c.courseWare from ChapterCourseWare  c where c.chapter.id=:cid";
	  Query query = session.createQuery(hqString);
	  query.setParameter("cid", id);
	  List<CourseWare> list = query.getResultList();
	  return list ;
  } 
}
