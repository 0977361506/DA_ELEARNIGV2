package com.vnpost.e_learning.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vnpost.e_learning.bean.Dates;
import com.vnpost.e_learning.entities.DetailCategoryEvent;
import com.vnpost.e_learning.entities.Eventt;

import com.vnpost.e_learning.service.IDetailCategoryEventService;
import com.vnpost.e_learning.service.IEventService;


@Controller
public class EventController {
	@Autowired
	Dates d;
	@Autowired
	IEventService  newService;
	@Autowired
	IDetailCategoryEventService  newcategory;


	@RequestMapping("/event/chitiet/{id}") // chi tiết su kiên
	public String chitiet(Model model,@PathVariable("id") Long id) {
		  List<Eventt> list = new ArrayList<Eventt>();
		  
		Eventt news = newService.findbyid(id);
	
	newService.save(news);
		  List<Eventt> list3 = newService.findAll();
        List<DetailCategoryEvent> list2 = newcategory .findAll();
        
  	  for(Eventt cNew :list3) {
  			if( d.days(cNew.getTimeCreate())>0 &&  d.days(cNew.getTimeCreate())<=2) {
  				list.add(cNew);
  			}
  		
  	  }
        
	    model.addAttribute("list",list2);
	    model.addAttribute("listnews",list);
		model.addAttribute("baiviet", news);
		  return "user/Event/EventDetail";
	}
	
	@RequestMapping("/event/category/detail/{id}") // danh sach  danh muc su kien 
	public String newOfCategory(Model model,@PathVariable("id") Long id) {
		List<Eventt> list = newService.findbyidCategory(id);
		model.addAttribute("list",list);
		  return "user/Event/EventCategoryDetail";
	}
	
  @RequestMapping("/home/events")
 public String event(Model model) {
	  List<Eventt> list = newService.findAll();
	List<DetailCategoryEvent> list2 = newcategory .findAll();
	 
	   for(Eventt c : list) {
		   c.setTomtat(c.getContent().substring(0, 50).concat("..."));
	   }
	   model.addAttribute("list", list);
	   model.addAttribute("list2", list2);
	   return "user/Event/news";
 }
}
