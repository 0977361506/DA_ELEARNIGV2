package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.NewCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewCategoryRepository extends JpaRepository<NewCategory,Long> {
}
