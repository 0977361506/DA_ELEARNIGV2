package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.DocumentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentCategoryRepository extends JpaRepository<DocumentCategory,Long> {
}
