package com.vnpost.e_learning.service;

import java.util.List;

import com.vnpost.e_learning.entities.Course;
import com.vnpost.e_learning.entities.Rate;

public interface IRateService {
	public  Rate  save(Rate entity);
	public List<Rate> findAll();
	public long count();
	 public Course getFromCourse(Long id);
	 public List<Rate> getRateFromCourse(Long id);
	 public Rate findbyId(Long id);
	 public List<Rate> sortByid(Long id);
}
