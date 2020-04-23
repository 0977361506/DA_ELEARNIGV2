package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document,Long> {
}
