package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.HelpDesk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface HelpDeskRepository extends JpaRepository<HelpDesk,Long> {
}
