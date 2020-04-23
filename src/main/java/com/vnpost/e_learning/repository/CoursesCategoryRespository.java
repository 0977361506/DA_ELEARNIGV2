package com.vnpost.e_learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.vnpost.e_learning.entities.CourseCategoryTree;

@Repository
public interface CoursesCategoryRespository extends JpaRepository< CourseCategoryTree, Long>{

}
