package com.vnpost.e_learning.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vnpost.e_learning.entities.AnswerComment;

@Repository
public interface AnswerCommentRespository  extends CrudRepository<AnswerComment, Long>{

}
