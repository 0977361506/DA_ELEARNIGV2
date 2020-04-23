package com.vnpost.e_learning.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class CourseConfigDTO {
    private long id;

    private int approveAuto;

    private Date endLearning;

    private Date ends;

    private int freedomRegister;

    private Date registerEnd;

    private Date registerStart;

    private Date startLearning;

    private Date starts;

   @JsonIgnore
    private CourseDTO course;
}
