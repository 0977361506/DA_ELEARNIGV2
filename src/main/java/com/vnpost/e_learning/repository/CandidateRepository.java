package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {
}
