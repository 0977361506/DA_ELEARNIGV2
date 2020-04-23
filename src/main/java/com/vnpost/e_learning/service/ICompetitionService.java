package com.vnpost.e_learning.service;

import java.util.List;

import com.vnpost.e_learning.entities.Competition;

public interface ICompetitionService {
	public List<Competition> getListCompetitions();
	public Competition findById(long id);
	public List<Competition> getListCompetitionsFromCategory(Long id);
	public List<Competition> getListFindByName(String a);

}
