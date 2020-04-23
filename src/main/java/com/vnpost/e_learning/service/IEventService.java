package com.vnpost.e_learning.service;

import java.util.List;

import com.vnpost.e_learning.entities.Eventt;

public interface IEventService {
	public List<Eventt> findAll();
	 public Eventt findbyid(Long id);
	 public List<Eventt> findbyidCategory(Long cid);
	 public Eventt save(Eventt entity);
}
