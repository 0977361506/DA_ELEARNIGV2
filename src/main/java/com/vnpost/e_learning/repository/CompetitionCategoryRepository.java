package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.CompetitionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionCategoryRepository extends JpaRepository<CompetitionCategory,Long> {
}
