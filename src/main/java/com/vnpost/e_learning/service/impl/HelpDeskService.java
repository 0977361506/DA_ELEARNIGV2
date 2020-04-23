package com.vnpost.e_learning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnpost.e_learning.entities.HelpDesk;
import com.vnpost.e_learning.repository.HelpDeskRepository;
import com.vnpost.e_learning.service.IHelpDeskService;
@Service
public class HelpDeskService implements IHelpDeskService{
    @Autowired
    HelpDeskRepository hel;

	public List<HelpDesk> findAll() {
		return hel.findAll();
	}

	public  HelpDesk save(HelpDesk entity) {
		return hel.save(entity);
	}
	
    
}
