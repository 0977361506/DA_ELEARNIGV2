package com.vnpost.e_learning.service;

import java.util.List;

import com.vnpost.e_learning.entities.HelpDesk;

public interface IHelpDeskService {
	public List<HelpDesk> findAll();
	public  HelpDesk save(HelpDesk entity);
}
