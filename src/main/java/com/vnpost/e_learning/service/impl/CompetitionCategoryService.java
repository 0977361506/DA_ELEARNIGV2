package com.vnpost.e_learning.service.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnpost.e_learning.entities.CompetitionCategory;
import com.vnpost.e_learning.repository.CompetitionCategoryRepository;
import com.vnpost.e_learning.service.IConpetitionCategoryService;

@Service
public class CompetitionCategoryService  implements IConpetitionCategoryService{
	@Autowired
   EntityManagerFactory entityManagerFactory;
 @Autowired 
   CompetitionCategoryRepository cate;
public List<CompetitionCategory> findAll() {
	return cate.findAll();
}
 
}
