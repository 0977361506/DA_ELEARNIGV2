package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
