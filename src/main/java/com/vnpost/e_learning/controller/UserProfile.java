package com.vnpost.e_learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserProfile {
  @RequestMapping("/user/myprofile")
  public String MyProfile() {
	  return "user/Home/MyProfile";
  }
}
