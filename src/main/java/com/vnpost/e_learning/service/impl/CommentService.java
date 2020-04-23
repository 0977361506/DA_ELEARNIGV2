package com.vnpost.e_learning.service.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnpost.e_learning.entities.AnswerComment;
import com.vnpost.e_learning.entities.Comment;
import com.vnpost.e_learning.repository.CommentRepository;
import com.vnpost.e_learning.service.ICommentServicce;
@Service
public class CommentService implements ICommentServicce {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    EntityManagerFactory en;
	public Comment  save(Comment entity) {
		return commentRepository.save(entity);
	}

	public List<Comment> findAll() {
		return commentRepository.findAll();
	}

	public long count() {
		return commentRepository.count();
	}
	@Override
	public Comment findById(Long id) {
		Session session = en.createEntityManager().unwrap(Session.class);
		Comment aNew = session.find(Comment.class, id);
		return aNew;
	}

}
