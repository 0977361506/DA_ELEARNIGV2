package com.vnpost.e_learning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnpost.e_learning.entities.DetailCategoryEvent;
import com.vnpost.e_learning.repository.DetailCategoryEventRepository;
import com.vnpost.e_learning.service.IDetailCategoryEventService;

@Service
public class DetailCategoryEventService implements IDetailCategoryEventService{
	@Autowired 
	DetailCategoryEventRepository d;

	public List<DetailCategoryEvent> findAll() {
		return d.findAll();
	}
	
}
