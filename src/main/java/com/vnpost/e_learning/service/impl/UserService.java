package com.vnpost.e_learning.service.impl;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnpost.e_learning.entities.User;
import com.vnpost.e_learning.service.IUserService;

@Service
public class UserService implements IUserService{
	@Autowired
	EntityManager entityManager ;
	public User findbyId(Long id) {
		return entityManager.unwrap(Session.class).find(User.class, id);
	}
}
