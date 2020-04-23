package com.vnpost.e_learning.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vnpost.e_learning.entities.New;
import com.vnpost.e_learning.repository.NewRepository;
import com.vnpost.e_learning.service.INewService;
@Service
public class NewService implements INewService{
	@Autowired
	NewRepository res;
	@Autowired
	EntityManagerFactory entityManagerFactory;
   @Override
public New save(New entity) {
	return res.save(entity);
}
@Override
public <S extends New> Optional<S> findOne(Example<S> example) {
	return res.findOne(example);
}

@Override
public List<New> findAll() {
	  Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
  	   String hString = "from New ";
  	   Query query = session.createQuery(hString);
  	   query.setMaxResults(2);
  	  
  	  
  	   List<New> list = query.getResultList();
  	   return list;
}
@Override
public List<New> findAll(Sort sort) {
	return res.findAll(sort);
}
@Override
public List<New> findAllById(Iterable<Long> ids) {
	return res.findAllById(ids);
}
@Override
public <S extends New> List<S> saveAll(Iterable<S> entities) {
	return res.saveAll(entities);
}
@Override
public New findById(Long id) {
	Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
	New aNew = session.find(New.class, id);
	return aNew;
}
@Override
public void flush() {
	res.flush();
}
@Override
public <S extends New> S saveAndFlush(S entity) {
	return res.saveAndFlush(entity);
}
@Override
public boolean existsById(Long id) {
	return res.existsById(id);
}
@Override
public void deleteInBatch(Iterable<New> entities) {
	res.deleteInBatch(entities);
}
@Override
public <S extends New> Page<S> findAll(Example<S> example, Pageable pageable) {
	return res.findAll(example, pageable);
}
@Override
public void deleteAllInBatch() {
	res.deleteAllInBatch();
}
@Override
public New getOne(Long id) {
	return res.getOne(id);
}
@Override
public <S extends New> long count(Example<S> example) {
	return res.count(example);
}
@Override
public <S extends New> boolean exists(Example<S> example) {
	return res.exists(example);
}
@Override
public <S extends New> List<S> findAll(Example<S> example) {
	return res.findAll(example);
}
@Override
public long count() {
	return res.count();
}
@Override
public void deleteById(Long id) {
	res.deleteById(id);
}
@Override
public <S extends New> List<S> findAll(Example<S> example, Sort sort) {
	return res.findAll(example, sort);
}
@Override
public void delete(New entity) {
	res.delete(entity);
}
@Override
public void deleteAll(Iterable<? extends New> entities) {
	res.deleteAll(entities);
}
@Override
public void deleteAll() {
	res.deleteAll();
}
   public List<New> findbyidCategory(Long cid){
	   Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
	   String hString = "from New n where n.newCategory.id=:cid ";
	   Query query = session.createQuery(hString);
	   query.setParameter("cid", cid);
	   List<New> list = query.getResultList();
	   return list;
   }
   public List<New> findbyidHightlight(){
	   Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
	   String hString = "from New n where n.highlightNew = 1 ";
	   Query query = session.createQuery(hString);
	  
	   List<New> list = query.getResultList();
	   return list;
   }
    public List<New> phantrang(int m ,int n ){
    	  Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
   	   String hString = "from New ";
   	   Query query = session.createQuery(hString);
   	   query.setFirstResult(m*n);
   	   query.setMaxResults(m);
   	  
   	  
   	   List<New> list = query.getResultList();
   	   return list;
    }
}
