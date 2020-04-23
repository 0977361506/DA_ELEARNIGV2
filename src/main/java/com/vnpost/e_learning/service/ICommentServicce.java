package com.vnpost.e_learning.service;

import java.util.List;

import com.vnpost.e_learning.entities.Comment;

public interface ICommentServicce {
	public Comment  save(Comment entity);
	public List<Comment> findAll();
	public long count();
	Comment findById(Long id);
}
