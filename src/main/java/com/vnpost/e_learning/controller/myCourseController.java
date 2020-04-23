package com.vnpost.e_learning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vnpost.e_learning.bean.Dates;
import com.vnpost.e_learning.entities.Course;
import com.vnpost.e_learning.service.ICourseJoinService;

@Controller
public class myCourseController {
      @Autowired
      Dates d;
	@Autowired
		ICourseJoinService cc;  
    @RequestMapping("/user/mycourse/current")
    public String myCourseCurent(Model model) {
		  List<Course> list2 = new ArrayList<Course>();
    	// khóa học đang học
    		  List<Course> list = cc.getListByCourseJion((long) 4);
    		  for(Course c: list) {
    			  if(d.days(c.getCourseConfig().getStarts()) < d.someday(c.getCourseConfig().getEnds(), c.getCourseConfig().getStarts())){
    				  list2.add(c);
    		
    		  
    	}

    }
    			model.addAttribute("list", list2);
    	    	return "user/courses/myCourse";
  }
    @RequestMapping("/user/mycourse/finnish")
    public String myCourseFinnish(Model model) {
		  List<Course> list2 = new ArrayList<Course>();
    	// khóa học đang học
    		  List<Course> list = cc.getListByCourseJion((long) 4);
    		  for(Course c: list) {
    			  if(d.days(c.getCourseConfig().getStarts()) > d.someday(c.getCourseConfig().getEnds(), c.getCourseConfig().getStarts())){
    				  list2.add(c);
    		
    		  
    	}

    }
    			model.addAttribute("list", list2);
    	    	return "user/courses/myCourse";
  }
    
}
