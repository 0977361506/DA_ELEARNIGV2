package com.vnpost.e_learning.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vnpost.e_learning.bean.Dates;
import com.vnpost.e_learning.entities.Course;
import com.vnpost.e_learning.entities.CourseCategoryTree;
import com.vnpost.e_learning.entities.Coursecategory;
import com.vnpost.e_learning.entities.Eventt;
import com.vnpost.e_learning.entities.MailContact;
import com.vnpost.e_learning.entities.New;
import com.vnpost.e_learning.service.ICourseService;
import com.vnpost.e_learning.service.ICoursesCategoryTreeService;
import com.vnpost.e_learning.service.IEventService;
import com.vnpost.e_learning.service.INewService;


@Controller
public class HomeController {
	@Autowired
	ICourseService ccc;
	@Autowired
	IEventService  newService;
	@Autowired
	Dates dd;
	@Autowired
	INewService n;
	@Autowired(required = true)
	ICoursesCategoryTreeService d;
		@Autowired
	    private ICourseService courseService;
		
	@RequestMapping("/home/index")
	  public String trangchu(Model model) {
		List<Course> co = courseService.findAlls();
		List<Course> coursess = new ArrayList<Course>();
		List<Course> courses = ccc.findbyhightlight(); // khoa học nổi bật
		  List<Eventt> list2 = newService.findAll();
		  List<Eventt> listnew2 = new ArrayList<Eventt>();
		 List<New>  listnew = new ArrayList<New>();
		List<New> list = n.findbyidHightlight();
		  for(New c : list) {
			   c.setTomtat(c.getContent().substring(0, 50).concat("..."));
		   }
		 

		  
		  // su kien
		  for(Eventt cNew :list2) {
				if( dd.days(cNew.getTimeStart())<0 &&  dd.days(cNew.getTimeStart())*(-1)<= 5) {
					listnew2.add(cNew);
				}
			
		  }
		  
		  for(Course cNew :co) { // khoa shojc moi 
				if( dd.days(cNew.getCourseConfig().getStarts())>0 &&  dd.days(cNew.getCourseConfig().getStarts())<= 3) {
					coursess.add(cNew);
				}
			
		  }
		 model.addAttribute("cou", courses); // khóa học nôi bạt 
		 model.addAttribute("cous", coursess); // khóa học moi 
		model.addAttribute("list", list);
		model.addAttribute("list2", listnew2);
		  return "user/Home/index";
	  }

	@RequestMapping("/home/introduce") // gioi thieu ve vnpost
	  public String introduce() {
		  return "user/Home/introduce";
	  }
	
	@RequestMapping("/home/support")
	  public String support(Model model) {
		model.addAttribute("fom", new MailContact());
		  return "user/Home/support";
	  }
	@RequestMapping("/home/mycourse")
	  public String mycourse() {
		  return "user/Home/mycourse";
	  }
	@RequestMapping("/home/courses")
	  public String courses(Model model) {
		List<Course> list = courseService.findAlls();
		List<Coursecategory> list2 = d.findAll();
        
		model.addAttribute("list1",list2);
		model.addAttribute("list",list);
		  return "user/Home/courses";
	  }

}
