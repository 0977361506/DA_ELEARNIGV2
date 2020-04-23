package com.vnpost.e_learning.newcategory.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vnpost.e_learning.entities.New;
import com.vnpost.e_learning.entities.NewCategory;
import com.vnpost.e_learning.service.INewService;
import com.vnpost.e_learning.service.impl.NewCategoryService;



@Controller
public class NewCategoryController { // lay tat ca danh muc tin tuc
	@Autowired
	NewCategoryService  newcategory;
	@Autowired
	INewService newService;
  @RequestMapping("/home/blogsimple")
  public String listNewCategory(Model model) {
	  List<NewCategory> list = newcategory.findAll();
	  List<New>  listnews = newService.findAll();
	  model.addAttribute("list",list);
	  model.addAttribute("listnews",listnews);
	  return "user/Home/courseSimple";
  }
}
