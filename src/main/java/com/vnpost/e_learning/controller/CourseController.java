package com.vnpost.e_learning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vnpost.e_learning.bean.CourseConfigWare;
import com.vnpost.e_learning.bean.VNCharacterUtils;
import com.vnpost.e_learning.dto.ClassCouresDTO;
import com.vnpost.e_learning.entities.Course;
import com.vnpost.e_learning.entities.Coursecategory;
import com.vnpost.e_learning.service.ICourseJoinService;
import com.vnpost.e_learning.service.ICourseService;
import com.vnpost.e_learning.service.ICoursesCategoryTreeService;
import com.vnpost.e_learning.service.IRateService;

@Controller
public class CourseController {
	@Autowired
	VNCharacterUtils vn;
	 @Autowired
	 IRateService rat;
	@Autowired
	ICourseJoinService cc;
	@Autowired
	ICourseService c;
	@Autowired(required = true)
	ICoursesCategoryTreeService d;
	@RequestMapping("/home/detail/course/{id}")
	public String detailCourses(Model model ,@PathVariable("id") Long id) {
		  List<Course> list = c.findbyDetailCategory(id);
		  List<Coursecategory> list2 = d.findAll();
		  model.addAttribute("list",list);
		  model.addAttribute("list1",list2);
		  
		  if(list.isEmpty()) {
			  model.addAttribute("mes","không tìm thấy khóa học nào !");
		  }
		   model.addAttribute("list", list);
		   model.addAttribute("list1", list2);
		  return "user/courses/DetailCourses";
	}
	@RequestMapping("/home/search/courses") // tim kiêm tất cả khóa học theo tên gần dung
	public String  findbyKeywword(Model model , @RequestParam("key") String key){
		String search = vn.removeAccent(key);
		System.out.println(search);
		List<Course> list = c.findByKeyWord(key);
		List<Coursecategory> list2 = d.findAll();
		  
		model.addAttribute("list1",list2);
		model.addAttribute("list", list);
		  return "user/Home/courses";
	}
	
	@RequestMapping("/home/search/mycourses") // tìm kiếm khóa hojccuar tôi theo tên gần dúng
	public String  findbyKeywwords(Model model , @RequestParam("mykey") String key){
		String search = vn.removeAccent(key);
		  List<Course> list = cc.getListByCourseJion((long) 4);
	    List<Course> list2 = new ArrayList<Course>();
	    for(Course c: list) {
	    	if(c.getName().toLowerCase().contains(key.toLowerCase())) {
	    		list2.add(c);
	    	}
	    }
		model.addAttribute("list", list2);
		return "user/courses/myCourse";
	}
	
	   @GetMapping("/home/mycourses") // liệt kê khóa học của tôi
	   public String getlisst(Model model){
		  
		   List<Course> list = cc.getListByCourseJion((long) 4);
	
		 model.addAttribute("list", list);
		  return "user/courses/myCourse";
	   }
	   
}
