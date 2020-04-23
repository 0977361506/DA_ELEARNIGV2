package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
