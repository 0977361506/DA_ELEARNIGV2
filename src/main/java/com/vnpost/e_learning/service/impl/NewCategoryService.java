package com.vnpost.e_learning.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vnpost.e_learning.entities.NewCategory;
import com.vnpost.e_learning.repository.NewCategoryRepository;
import com.vnpost.e_learning.service.INewCategoryService;
@Service
public class NewCategoryService implements INewCategoryService{
  @Autowired
  NewCategoryRepository newCategoryRepository;
  @Autowired
  EntityManagerFactory entityManagerFactory;
public NewCategory  save(NewCategory  entity) {
	return newCategoryRepository.save(entity);
}
public <S extends NewCategory> Optional<S> findOne(Example<S> example) {
	return newCategoryRepository.findOne(example);
}
public Page<NewCategory> findAll(Pageable pageable) {
	return newCategoryRepository.findAll(pageable);
}
public List<NewCategory> findAll() {
	return newCategoryRepository.findAll();
}
public List<NewCategory> findAll(Sort sort) {
	return newCategoryRepository.findAll(sort);
}
public List<NewCategory> findAllById(Iterable<Long> ids) {
	return newCategoryRepository.findAllById(ids);
}
public <S extends NewCategory> List<S> saveAll(Iterable<S> entities) {
	return newCategoryRepository.saveAll(entities);
}
public Optional<NewCategory> findById(Long id) {
	return newCategoryRepository.findById(id);
}
public void flush() {
	newCategoryRepository.flush();
}
public <S extends NewCategory> S saveAndFlush(S entity) {
	return newCategoryRepository.saveAndFlush(entity);
}
public boolean existsById(Long id) {
	return newCategoryRepository.existsById(id);
}
public void deleteInBatch(Iterable<NewCategory> entities) {
	newCategoryRepository.deleteInBatch(entities);
}
public <S extends NewCategory> Page<S> findAll(Example<S> example, Pageable pageable) {
	return newCategoryRepository.findAll(example, pageable);
}
public void deleteAllInBatch() {
	newCategoryRepository.deleteAllInBatch();
}
public NewCategory getOne(Long id) {
	return newCategoryRepository.getOne(id);
}
public <S extends NewCategory> long count(Example<S> example) {
	return newCategoryRepository.count(example);
}
public <S extends NewCategory> boolean exists(Example<S> example) {
	return newCategoryRepository.exists(example);
}
public <S extends NewCategory> List<S> findAll(Example<S> example) {
	return newCategoryRepository.findAll(example);
}
public long count() {
	return newCategoryRepository.count();
}
public void deleteById(Long id) {
	newCategoryRepository.deleteById(id);
}
public <S extends NewCategory> List<S> findAll(Example<S> example, Sort sort) {
	return newCategoryRepository.findAll(example, sort);
}
public void delete(NewCategory entity) {
	newCategoryRepository.delete(entity);
}
public void deleteAll(Iterable<? extends NewCategory> entities) {
	newCategoryRepository.deleteAll(entities);
}
public void deleteAll() {
	newCategoryRepository.deleteAll();
}
  
}
