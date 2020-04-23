package com.vnpost.e_learning.controller;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vnpost.e_learning.api.RatingApi;
import com.vnpost.e_learning.bean.CourseConfigWare;
import com.vnpost.e_learning.entities.Chapter;
import com.vnpost.e_learning.entities.Comment;
import com.vnpost.e_learning.entities.Course;
import com.vnpost.e_learning.entities.Document;
import com.vnpost.e_learning.entities.Rate;
import com.vnpost.e_learning.repository.CourseRepository;
import com.vnpost.e_learning.service.ICommentServicce;
import com.vnpost.e_learning.service.ICourseJoinService;
import com.vnpost.e_learning.service.ICourseService;
import com.vnpost.e_learning.service.IRateService;

@Controller
public class CourseDetailController { // chi tiết khóa học
	@Autowired
	IRateService r;
	@Autowired
	ICommentServicce comment; // commnet
  @Autowired
  ICourseService c;
	@Autowired
	ICourseJoinService cj;
 
	@RequestMapping("/home/courses/detail/{id}") //chiteit khoa hocj
	  public String mycoursedetail(Model model , @PathVariable("id") Long id) {
    List<Course> list = c.findAlls();
  Course cc = timkiem(list, id); // tim kiếm khoa học trong list khóa học
  List<Document> documents = cc.getDocuments();
  List<Rate> rates = cc.getRates(); // danh sach đnáh giá kháo học
  List<Rate> rates2 = r.sortByid(id); // 
   if(rates2.size()==0) {
	   Rate rate = new Rate();
	  rate.setStar_one("width:0%;");
	  rate.setStar_two("width:0%;");
	  rate.setStar_three("width:0%;");
	  rate.setStar_for("width:0%;");
	  rate.setStar_five("width:0%;");
			  model.addAttribute("rate",rate);
		  // lấy ra đánh giá cao nhất 
   }
   else {
	   Rate rate = rates2.get(0);
	   if(rate!= null){
			  model.addAttribute("rate",rate);
		  }// lấy ra đánh giá cao nhất 
}
  
  int sl = rates.size(); 
  double  tong = tong(rates);
  DecimalFormat df = new DecimalFormat("#.##");
  String formatted = df.format(tong/sl); 


 
  model.addAttribute("slvote",  formatted);
  model.addAttribute("sldanhgia", sl);
  List<Comment> comments = cc.getComments(); // danh sach comment cha
  List<Chapter> chapters =cc.getOutline().getChapters();//  chương mục của khóa học
  List<Course> courseJoins = cj.getListByCourseJion((long) 4); // khoa hocn ma usẻ tham gia
  Course course = timkiem(courseJoins, cc.getId()); // kiểm tra xem kháo học này user tham gia chưa
  if(course!=null) {
	  model.addAttribute("yes","ban da tham gia khoa hoc nay"); // neu tồn tại thì có thể bình luận kháo học
  }


  List<Course> list1 = c.findbyCategory(cc.getCoursecategory().getId(),cc.getId());
  if(list1.isEmpty()) {model.addAttribute("mes", "Không tìm thấy khóa học nào liên quan !");}
         
         model.addAttribute("tailieu", documents);
		 model.addAttribute("chitiet",  cc);
		 model.addAttribute("list", list1);
         model.addAttribute("comments", comments);
		 model.addAttribute("list4", chapters);
		  return "user/courses/detail";
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
	
}
