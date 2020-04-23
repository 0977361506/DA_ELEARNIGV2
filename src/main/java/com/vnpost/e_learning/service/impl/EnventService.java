package com.vnpost.e_learning.service.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnpost.e_learning.entities.Eventt;
import com.vnpost.e_learning.entities.New;
import com.vnpost.e_learning.repository.EventRepository;
import com.vnpost.e_learning.service.IEventService;
@Service
public class EnventService implements IEventService {
   @Autowired
   EventRepository r;
 @Autowired
 EntityManagerFactory entityManagerFactory;
public List<Eventt> findAll() {
	return r.findAll();
}
   public Eventt findbyid(Long id) {
	   Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		Eventt aNew = session.find(Eventt.class, id);
		return aNew;
   }
   public List<Eventt> findbyidCategory(Long cid){
	   Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
	   String hString = "from Eventt n where n.detailCategoryEvent.id=:cid ";
	   Query query = session.createQuery(hString);
	   query.setParameter("cid", cid);
	   List<Eventt> list = query.getResultList();
	   return list;
   }
public Eventt save(Eventt entity) {
	return r.save(entity);
}
   
}
