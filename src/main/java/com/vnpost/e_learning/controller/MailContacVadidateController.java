package com.vnpost.e_learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vnpost.e_learning.entities.MailContact;

import com.vnpost.e_learning.service.IMailContactService;

@Controller
public class MailContacVadidateController {
	@Autowired
	IMailContactService m;
  @GetMapping("/home/support/Contact")
  public String vadidateMailContac(Model model) {
   MailContact mailContact = new MailContact();
	  model.addAttribute("fom", mailContact);
	  return "user/Home/support";
  }
  @PostMapping("/home/support/Contact")
  public String vadidtate(Model model , @Validated @ModelAttribute("fom") MailContact mailContact ,BindingResult errors){
	
	  if(errors.hasErrors()) {
			 model.addAttribute("mes", "vui lòng sửa các lỗi dưới đây !");

		 }
	  else if(mailContact.getEmail().matches("^\\w+[a-z0-9]*@\\w+[a-z0-9].com$")== false) {
		  model.addAttribute("mes", "vui lòng sửa các lỗi dưới đây !");
	  }
	  else {
		  m.save(mailContact);
		  model.addAttribute("suc", "Cám ơn bạn đã gửi phản hồi tới chúng tôi");
	  }
	  return "user/Home/support";
  }
}
