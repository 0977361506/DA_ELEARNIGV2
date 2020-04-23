package com.vnpost.e_learning.news.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.vnpost.e_learning.entities.New;
import com.vnpost.e_learning.service.INewService;


@RestController
@RequestMapping("/news")
public class NewsApi {
	@Autowired
	INewService n;
    @GetMapping("/detail/{id}")
    public ResponseEntity<New> findbyid(@PathVariable("id")Long id){
    	
    	New aNew = n.findById(id);
    	System.out.println(aNew.getTitle());
    	  if (aNew== null) {
              System.out.println("User with id " + id + " not found");
              return new ResponseEntity<New>(HttpStatus.NOT_FOUND);
          }
    	return new ResponseEntity<New>(aNew,HttpStatus.OK);
    }
    
    // lấy toàn bộ tin tức
    
    @GetMapping("/lists/{id}")
    public ResponseEntity<List<New>> findAll(@PathVariable("id") int id){
    	List<New> list = n.phantrang(2, id);
    	 for(New c : list) {
  		   c.setTomtat(c.getContent().substring(0, 50).concat("..."));
  	   }
    	 if (list.isEmpty()) {
             return new ResponseEntity<List<New>>(HttpStatus.NO_CONTENT);
         }
         return new ResponseEntity<List<New>>(list, HttpStatus.OK);
    }
    
    //
    @GetMapping("/category/{a}")
 public ResponseEntity<List<New>> findbyidCategory(@PathVariable("a") Long id){
    	
    	List<New> list = n.findbyidCategory(id);
    	
    	
    	return new ResponseEntity<List<New>>(list,HttpStatus.OK);
    }
    
}
