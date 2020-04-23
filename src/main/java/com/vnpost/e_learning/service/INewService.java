package com.vnpost.e_learning.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.vnpost.e_learning.entities.New;
import com.vnpost.e_learning.repository.NewRepository;

public interface INewService {
	public List<New> findbyidHightlight();
	public List<New> findbyidCategory(Long cid);
	void deleteAll();

	void deleteAll(Iterable<? extends New> entities);

	void delete(New entity);

	<S extends New> List<S> findAll(Example<S> example, Sort sort);

	void deleteById(Long id);

	long count();

	<S extends New> List<S> findAll(Example<S> example);

	<S extends New> boolean exists(Example<S> example);

	<S extends New> long count(Example<S> example);

	New getOne(Long id);

	void deleteAllInBatch();

	<S extends New> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<New> entities);

	boolean existsById(Long id);

	<S extends New> S saveAndFlush(S entity);

	void flush();
	 public List<New> phantrang(int m ,int n );
	New findById(Long id);

	<S extends New> List<S> saveAll(Iterable<S> entities);

	List<New> findAllById(Iterable<Long> ids);

	List<New> findAll(Sort sort);

	List<New> findAll();

	<S extends New> Optional<S> findOne(Example<S> example);

	New save(New entity);

	

}
