package com.vnpost.e_learning.news.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vnpost.e_learning.bean.Dates;
import com.vnpost.e_learning.entities.*;
import com.vnpost.e_learning.service.INewService;
import com.vnpost.e_learning.service.impl.NewCategoryService;


@Controller
public class NewsapiController {  // lay tat ca  bai viet
	@Autowired
	Dates d;
	@Autowired
	INewService newService;
	@Autowired
	NewCategoryService  newcategory;
	@RequestMapping("/home/news")
   public String findall(Model model ){
	   List<New>  list = newService.findAll();
	   for(New c : list) {
		   c.setTomtat(c.getContent().substring(0, 50).concat("..."));
	   }
	   model.addAttribute("listnews", list);
	   return "user/Home/news";
   }
	@RequestMapping("/new/chitiet/{id}") // chi tiết bài viêt
	public String chitiet(Model model,@PathVariable("id") Long id) {

		 List<New>  listnew = new ArrayList<New>();
		New news = newService.findById(id);
//		System.out.println("thoi gian hiene tai cua he thong la"+news.getTimeCreate().getTime());
		 List<NewCategory> list = newcategory.findAll();
		  List<New>  listnews = newService.findAll();
		
		  for(New cNew : listnews) {
			if( d.days(cNew.getTimeCreate())>0 &&  d.days(cNew.getTimeCreate())<=2) {
				listnew.add(cNew);
			}
		
	  }
		  model.addAttribute("list",list);
		  model.addAttribute("listnews",listnew);
		model.addAttribute("baiviet", news);
		  return "user/Home/courseSimple";
	}
	
	@RequestMapping("/news/category/detail/{id}")
	public String newOfCategory(Model model,@PathVariable("id") Long id) {
		List<New> list = newService.findbyidCategory(id);
		model.addAttribute("list",list);
		return "user/Home/newDetail";
	}
	
	
	

}
