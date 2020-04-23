package com.vnpost.e_learning.controller.admin;

import com.vnpost.e_learning.dto.CourseDTO;
import com.vnpost.e_learning.repository.CourseRepository;
import com.vnpost.e_learning.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "adminCourseController")
@RequestMapping("/admin/course")
public class CourseController {
    @Autowired
    private ICourseService courseService;
    @Autowired
    private CourseRepository courseRepository;
    @GetMapping("/index")
    public ModelAndView index(@ModelAttribute(name = "search")CourseDTO search){
        ModelAndView mav = new ModelAndView("admin/course/index");
        mav.addObject("courses",courseRepository.findAll());
        mav.addObject("search",search);
        return mav;
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable(name = "id") long id){
        ModelAndView mav = new ModelAndView("admin/course/detail");
        //mav.addObject("course",courseService.findById(id));
        return mav;
    }
}
