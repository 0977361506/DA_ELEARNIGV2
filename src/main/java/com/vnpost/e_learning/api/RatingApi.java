package com.vnpost.e_learning.api;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vnpost.e_learning.bean.Stars;
import com.vnpost.e_learning.entities.Course;
import com.vnpost.e_learning.entities.Rate;
import com.vnpost.e_learning.service.ICourseJoinService;
import com.vnpost.e_learning.service.ICourseService;
import com.vnpost.e_learning.service.IRateService;

@RestController
public class RatingApi {
   @Autowired
   ICourseService c;
	@Autowired
	IRateService rat;
	@Autowired
	ICourseJoinService cj;
   @GetMapping("/rating/star/{eID}/{m}")
   public  Object[]  getrating(@PathVariable("eID") int a , @PathVariable("m") long sl) {
	   double avg = 0;
	   List<Integer> songuyen1 = new ArrayList<Integer>();

	 
	   List<Course> list = c.findAlls();
	   Course course = timkiem(list, sl);
	   
	   List<Rate> list2 = rat.findAll();
	  
	  double tong = tong(list2);
	   double m = list2.size()+1;
	   Rate rate = new Rate();
	   rate.setValuess(a);
	  
	   rate.setCourse(course);
	   rat.save(rate);
	   List<Rate> slrate= course.getRates();
	   // trung binh danh giá
	   double  tong2 = tong(slrate);
	   DecimalFormat df = new DecimalFormat("#.##");
	   String formatted = df.format(tong2/slrate.size()); 
	   //...........
	   List<Rate> list3 = rat.getRateFromCourse(sl);
	   for(Rate r: list3) {
		   songuyen1.add(r.getValuess());
		  
	   }
	
	   
	   Object[] mangObjects = {slrate.size(),songuyen1,formatted,rate.getId()};
	
	 
	   return mangObjects;
	   
   }
	public Course timkiem(List<Course> list , Long id) {
		
		 for(Course c: list) {
			  if(c.getId() == id) {
				 return c;
			  }
		   }
		 return null;
	}
	public double tong(List<Rate> list) {
		double m = 0.0 ;
		 for(Rate rate : list) {
			   m +=rate.getValuess();
		   }
		 return m;
	}
	
	// lấy các đánh giá 
@RequestMapping("/show/review")
	public boolean getStar(@RequestBody Stars stars) {
		if(stars!=null) {
			Rate rate = rat.findbyId(stars.getIdRate());
			if(rate!=null) {
				rate.setStar_one(stars.getStarOne());
				rate.setStar_two(stars.getStarTwo());
				rate.setStar_three(stars.getStarThree());
				rate.setStar_for(stars.getStarFor());
				rate.setStar_five(stars.getStarFive());
				rat.save(rate);
				return true;
			}
			
		}
		
		return false;
	
	}

// check quyền xem user đăng kí khoa shocj này chưa 
 @GetMapping("/check/role/user/{id}")
 public String chekRole(@PathVariable("id") Long id) {
	
	   List<Course> list = c.findAlls();
	   Course cc= timkiem(list, id);
	   
	 List<Course> courseJoins = cj.getListByCourseJion((long) 4); // khoa hocn ma usẻ tham gia
	  Course course = timkiem(courseJoins, cc.getId()); // kiểm tra xem kháo học này user tham gia chưa
	  if(course!=null) {
		 
		 return  "bạn có thể  bình luận đăng kí"; // neu tồn tại thì có thể bình luận kháo học
	  }
	  return "";
 }

}
