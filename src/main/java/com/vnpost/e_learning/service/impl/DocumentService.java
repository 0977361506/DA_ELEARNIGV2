package com.vnpost.e_learning.service.impl;

import java.util.List;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnpost.e_learning.entities.Document;
import com.vnpost.e_learning.repository.DocumentRepository;
import com.vnpost.e_learning.service.IDocumentService;
@Service
public class DocumentService implements IDocumentService {
	@Autowired
    DocumentRepository document;
	@Autowired
	EntityManagerFactory entityManagerFactory;
	public List<Document> getListDocuments(){
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hqlString = "from Document d where d.status=1";
		Query query = session.createQuery(hqlString);
		List<Document> list = query.getResultList();
		return list;
	}
	public Document findById(long id) {
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		return session.find(Document.class,id);
	}
	public List<Document> getListDocumentsFromCategory(Long id){
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hqlString = "from Document d where d.documentCategory.id=:cid";
		Query query = session.createQuery(hqlString);
		query.setParameter("cid", id);
		List<Document> list = query.getResultList();
		return list;
	}
	public List<Document> getListFindByName(String a){
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hqlString = "from Document d where d.status=1 and d.name like :cid";
		Query query = session.createQuery(hqlString);
		 query.setParameter("cid", "%"+a+"%");
		List<Document> list = query.getResultList();
		
		return list;
	}
}
