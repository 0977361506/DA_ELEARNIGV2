package com.vnpost.e_learning.service;

import java.util.List;

import com.vnpost.e_learning.entities.CourseCategoryTree;
import com.vnpost.e_learning.entities.Coursecategory;

public interface ICoursesCategoryTreeService {
	public List<Coursecategory> findAll();
	public long count();
	public List<CourseCategoryTree> findCategoryByid(Long id);
}
