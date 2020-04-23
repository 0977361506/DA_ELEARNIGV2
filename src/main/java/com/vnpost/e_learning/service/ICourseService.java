package com.vnpost.e_learning.service;

import com.vnpost.e_learning.bean.CourseConfigWare;
import com.vnpost.e_learning.dto.CourseDTO;
import com.vnpost.e_learning.entities.Course;

import java.util.List;

import org.springframework.data.domain.Example;

public interface ICourseService {
    List<CourseDTO> findAll();
    CourseDTO findById(long id);
    CourseDTO save(CourseDTO courseDTO);
    CourseDTO update(CourseDTO courseDTO);
    public  List<Course> findAlls(Example<Course> example);
    public List<Course> findAlls() ;
    public Course findById(Long id);
    public List<Course> findbyCategory(Long id, Long id2);
    public List<Course> findbyhightlight();
    public List<Course> findbyDetailCategory(Long id);

    public List<String> getTenHocLieeuForCourse();
    public List<CourseConfigWare> getCourseConfigWares();
    public List<Course> findByKeyWord(String key);
}
