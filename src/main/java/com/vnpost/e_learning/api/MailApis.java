package com.vnpost.e_learning.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vnpost.e_learning.entities.HelpDesk;
import com.vnpost.e_learning.entities.MailContact;
import com.vnpost.e_learning.service.IHelpDeskService;
import com.vnpost.e_learning.service.IMailContactService;

@RestController
public class MailApis {
	@Autowired
	IMailContactService mail;
	@Autowired
	IHelpDeskService he;
  @RequestMapping("/api/registration/{mail}")
  public boolean save(@PathVariable("mail") String a) {
	  List<HelpDesk> mailContacts= he.findAll();
	  for(HelpDesk c: mailContacts) {
		  System.out.println(c.getEmail());
	  }
	
		 if(check(a, mailContacts)== false) {
			 if(a.matches("^\\w+[a-z0-9]*@\\w+[a-z0-9].com$")== true) {
				 HelpDesk mailContact = new HelpDesk();
				 mailContact.setEmail(a);
				 
				 he.save(mailContact);
				 return true;
			  }
		 }

	  return false;
  }
  public boolean check(String a ,List<HelpDesk> list) {
	  int i = 0 ;
	  for(HelpDesk c:list) {
		  if(a.equals(c.getEmail())) i++;
		
	  }
	  if(i > 0) return true;
	  return false;
  }
}
