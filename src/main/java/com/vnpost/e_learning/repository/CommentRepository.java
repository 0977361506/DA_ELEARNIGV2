package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
