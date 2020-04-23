package com.vnpost.e_learning.service;

import java.util.List;

import com.vnpost.e_learning.entities.MailContact;

public interface IMailContactService {
	public  MailContact save(MailContact entity);
	public List<MailContact> findAll() ;
}
