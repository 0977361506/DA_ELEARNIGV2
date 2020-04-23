package com.vnpost.e_learning.service;

import java.util.List;

import com.vnpost.e_learning.entities.Candidate;

public interface ICandidateService {
	public Candidate save(Candidate entity);
	public Candidate findbyIdUser(Long id);
	public int countByIdusser(Long id);
	public List<Candidate> getListByIdUser(Long id ,Long id2);
	public Candidate findbyIduAndUdrAndCount(Long idu , Long idr , int sl);
	public List<Candidate> OrderByCandicateByCountest(Long idu , Long idr);
}
