package com.vnpost.e_learning.api;

import com.vnpost.e_learning.dto.CourseDTO;
import com.vnpost.e_learning.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/course")
public class CourseApi {
    @Autowired
    private ICourseService courseService;
    @GetMapping("/index")
    public ResponseEntity<List<CourseDTO>> index(){
        List<CourseDTO> courses = courseService.findAll();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
    
}
