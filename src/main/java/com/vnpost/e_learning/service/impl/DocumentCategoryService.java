package com.vnpost.e_learning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.vnpost.e_learning.entities.DocumentCategory;
import com.vnpost.e_learning.repository.DocumentCategoryRepository;

import com.vnpost.e_learning.service.IDocumentCategoryService;
@Service
public class DocumentCategoryService implements IDocumentCategoryService {
	@Autowired
	DocumentCategoryRepository ducment;

	public List<DocumentCategory> findAll() {
		return ducment.findAll();
	}
	
}
