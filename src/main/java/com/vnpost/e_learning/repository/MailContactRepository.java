package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.MailContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailContactRepository extends JpaRepository<MailContact,Long> {
}
