package com.vnpost.e_learning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnpost.e_learning.entities.MailContact;
import com.vnpost.e_learning.repository.MailContactRepository;
import com.vnpost.e_learning.service.IMailContactService;
@Service
public class MailContactService implements IMailContactService{
  @Autowired
  MailContactRepository mail;

public  MailContact save(MailContact entity) {
	return mail.save(entity);
}

public List<MailContact> findAll() {
	return mail.findAll();
}

  
}
