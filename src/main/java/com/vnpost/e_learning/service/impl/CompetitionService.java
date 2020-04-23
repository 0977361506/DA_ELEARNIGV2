package com.vnpost.e_learning.service.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnpost.e_learning.entities.Competition;
import com.vnpost.e_learning.entities.Document;

import com.vnpost.e_learning.service.ICompetitionService;

@Service
public class CompetitionService implements ICompetitionService{

	@Autowired
	EntityManagerFactory entityManagerFactory;
	public List<Competition> getListCompetitions(){
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hqlString = "from Competition d where d. statusCompetition=0 and d.highlight=0";
		Query query = session.createQuery(hqlString);
		List<Competition> list = query.getResultList();
		return list;
	}
	public Competition findById(long id) {
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		return session.find(Competition.class,id);
	}
	public List<Competition> getListCompetitionsFromCategory(Long id){
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hqlString = "from Competition d where d.competitionCategory.id=:cid";
		Query query = session.createQuery(hqlString);
		query.setParameter("cid", id);
		List<Competition> list = query.getResultList();
		return list;
	}
	public List<Competition> getListFindByName(String a){
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hqlString = "from Competition d where d. statusCompetition=0 and d.name like :cid";
		Query query = session.createQuery(hqlString);
		 query.setParameter("cid", "%"+a+"%");
		List<Competition> list = query.getResultList();
		
		return list;
	}
}
