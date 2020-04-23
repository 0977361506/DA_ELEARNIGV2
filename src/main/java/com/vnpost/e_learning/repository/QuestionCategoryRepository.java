package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.QuestionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionCategoryRepository extends JpaRepository<QuestionCategory,Long> {
}
