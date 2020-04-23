package com.vnpost.e_learning.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class CoursecategoryDTO {
    private long id;

    private String name;

    @JsonIgnore
    private List<CourseDTO> courses;

   
    private List<CoursecategoryDTO> coursecategories1;


    private List<CoursecategoryDTO> coursecategories2;
}
