package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.Condition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConditionRepository extends JpaRepository<Condition,Long> {
}
