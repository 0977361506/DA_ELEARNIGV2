package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test,Long> {
}
