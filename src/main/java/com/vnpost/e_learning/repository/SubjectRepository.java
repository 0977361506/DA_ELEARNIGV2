package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
