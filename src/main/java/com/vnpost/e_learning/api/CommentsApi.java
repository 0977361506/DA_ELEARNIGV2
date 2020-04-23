package com.vnpost.e_learning.api;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.vnpost.e_learning.dto.ClassCouresDTO;
import com.vnpost.e_learning.dto.CommentDTO;
import com.vnpost.e_learning.entities.AnswerComment;
import com.vnpost.e_learning.entities.Comment;
import com.vnpost.e_learning.entities.Course;
import com.vnpost.e_learning.service.IAnswerCommentService;
import com.vnpost.e_learning.service.ICommentServicce;
import com.vnpost.e_learning.service.ICourseService;

@RestController
public class CommentsApi {
	@Autowired
	CommentDTO cmdto;
	@Autowired
	IAnswerCommentService ans;
	@Autowired
	ClassCouresDTO dto;
	@Autowired
	ICourseService co;
	@Autowired
	ICommentServicce c;
  @GetMapping("/api/comment/{a}/{b}")
  public ResponseEntity<Comment> getComment(@PathVariable("a") String comment ,@PathVariable("b") Long b){
	  if(!comment.equals("")) {
		  List<Course> list = co.findAlls();
		   
		  Course cc = timkiem(list, b); // tim kiếm khoa học trong list khóa học
		  ClassCouresDTO couresDTO = dto.converttoEntityCourse(cc);
		  Course kCourse = new Course();
		  kCourse.setId(couresDTO.getId());
		  kCourse.setName(couresDTO.getName());
		  Comment comment2 = new Comment();
		  comment2.setContents(comment);
		  comment2.setCreatedBy("LeHieu");
		  comment2.setCreatedDate(new Date());
		  comment2.setCourse(kCourse);
		  c.save(comment2);
		
		  return new ResponseEntity<Comment>(comment2, HttpStatus.OK);
	  }
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
	public Course timkiem(List<Course> list , Long id) {
		
		 for(Course c: list) {
			  if(c.getId() == id) {
				 return c;
			  }
		   }
		 return null;
	}
	
	@GetMapping("/api/recomment/{b}")
	  public ResponseEntity<List<AnswerComment>> getReComment(@PathVariable("b") Long b){
		
	         
			  Comment comment2 = c.findById(b); 
			  CommentDTO commentDTO = cmdto.convertFromComment(comment2);
			  List<AnswerComment> list = commentDTO.getList();
		
			
			  return new ResponseEntity<List<AnswerComment>>( list, HttpStatus.OK);
		
	  }
	@GetMapping("/api/recomments/{a}/{b}")
	  public ResponseEntity<AnswerComment> getReComment(@PathVariable("a") String comment,@PathVariable("b") Long b){
		
	         
		 if(!comment.equals("")) {
			 Comment commentss = c.findById(b); 
			
		
			  AnswerComment comment2 = new AnswerComment();
			  comment2.setContents(comment);
			  comment2.setCreatedBy("LeHieu");
			  comment2.setCreatedDate(new Date());
			 comment2.setComment(commentss);
			  ans.save(comment2);
			
			  return new ResponseEntity<AnswerComment>(comment2, HttpStatus.OK);
		  }
		
			
			  return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		
	  }
	
}
