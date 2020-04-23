package com.vnpost.e_learning.service;

import java.util.List;

import com.vnpost.e_learning.entities.AnswerComment;

public interface IAnswerCommentService {
	public List<AnswerComment> findAll() ;
	public AnswerComment save(AnswerComment entity);
	public long count() ;
	public AnswerComment findById(Long id);
}
