package com.vnpost.e_learning.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CourseRequirementDTO {
    private int id;

    @JsonIgnore
    private CourseDTO course;


    private PositionNameDTO positionName;
}
