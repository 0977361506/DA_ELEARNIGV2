package com.vnpost.e_learning.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vnpost.e_learning.dto.ClassCouresDTO;
import com.vnpost.e_learning.dto.CourseCategoryDtos;
import com.vnpost.e_learning.dto.CourseDTO;
import com.vnpost.e_learning.dto.CourseWareDTO;
import com.vnpost.e_learning.dto.CoursecategoryDTO;
import com.vnpost.e_learning.entities.Course;
import com.vnpost.e_learning.entities.CourseCategoryTree;
import com.vnpost.e_learning.entities.CourseJoin;
import com.vnpost.e_learning.entities.CourseWare;
import com.vnpost.e_learning.entities.Coursecategory;
import com.vnpost.e_learning.service.IChapterCourseWareService;
import com.vnpost.e_learning.service.ICourseJoinService;
import com.vnpost.e_learning.service.ICourseService;
import com.vnpost.e_learning.service.ICoursesCategoryTreeService;

@RestController
@RequestMapping("/api")
public class CoursesAPIs {
	@Autowired
	CourseWareDTO dtos;
	@Autowired
	CourseCategoryDtos dto;
	 @Autowired
	 ClassCouresDTO cl;
	@Autowired
	ICourseJoinService cc;
	@Autowired
	ICourseService c;
	@Autowired
	ICoursesCategoryTreeService cate;
	@Autowired
	IChapterCourseWareService chap;
	
	
	@GetMapping("/outline/{a}") // lấy ra các học liêu thuộc một chương
	public ResponseEntity<List<CourseWareDTO>> getOutlineForCuorse(@PathVariable("a") Long id) {
		List<CourseWare> courseWares = chap.getListCourseWareFromChapterCourseWare(id);
		List<CourseWareDTO> courseWareDTOs = new ArrayList<CourseWareDTO>();
		for(CourseWare c: courseWares) {
			courseWareDTOs.add(dtos.convertToCourseWareDTO(c));
		}
		if(courseWareDTOs!=null) {
			return new ResponseEntity<List<CourseWareDTO>>(courseWareDTOs,HttpStatus.OK);
		}
		return new ResponseEntity<List<CourseWareDTO>>(courseWareDTOs,HttpStatus.NOT_FOUND);
	}
	
   @GetMapping("/courses")
   public ResponseEntity<List<CourseDTO>> index(){
       List<CourseDTO> courses = c.findAll();
       
       return new ResponseEntity<>(courses, HttpStatus.OK);
   }
   
   
   @GetMapping("/myCourses")
   public ResponseEntity<List<ClassCouresDTO>> getlisst(){
	 
	   List<Course> list = cc.getListByCourseJion((long) 4);
	   List<ClassCouresDTO> list2 = new ArrayList<ClassCouresDTO>();
	   for(Course c: list) {
		   list2.add(cl.converttoEntityCourse(c));
		   
	   }
	   if(list2!=null) {
		   return new ResponseEntity<List<ClassCouresDTO>>(list2,HttpStatus.OK);
	   }
	  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
   
   
   @GetMapping("/courseCategory/{id}") //tim kiem danh muc
   public ResponseEntity<List<CourseCategoryDtos>> getCAtegory(@PathVariable("id") Long id){
	   List<CourseCategoryTree> list = cate.findCategoryByid(id);
	   List<CourseCategoryDtos> list2 = new ArrayList<CourseCategoryDtos>();
	   for(CourseCategoryTree c: list) {
		   list2.add(dto.convertTodto(c.getCourseCategoryTwo()));
	   }
	  try {
		  if(list2!=null) return new ResponseEntity<List<CourseCategoryDtos>>(list2,HttpStatus.OK);
	} catch (Exception e) {
		System.out.println("không tim thấy dữ liệu");
	}
	  
		   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	   
   }
   
   @GetMapping("/detail/mycourses/{id}") // tim khiem các khóa học theo danh muc
   public ResponseEntity<List<ClassCouresDTO>> getCourseDetailByCategory(@PathVariable("id") Long id){
	   List<Course> list = c.findbyDetailCategory(id);
	   List<ClassCouresDTO> list2 = new ArrayList<ClassCouresDTO>();
	   for(Course c: list) {
		   list2.add(cl.converttoEntityCourse(c));
		   
	   }
	   if(list2!=null) {
		   return new ResponseEntity<List<ClassCouresDTO>>(list2,HttpStatus.OK);
	   }
	  
		   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	   
   }
   
}
