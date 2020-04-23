package com.vnpost.e_learning.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Getter
@Setter

public class CourseDTO {
    private Long id;

    private String avatar;



    private String description;

    private int highlight;


    private String name;

    private int price;

    private int showName;

    private int status;

    private int stepbystep;


    private List<CommentDTO> comments;

    //bi-directional many-to-one association to Coursecategory

    private CoursecategoryDTO coursecategory;

    //bi-directional many-to-one association to CourseConfig
    private CourseConfigDTO courseConfig;

    //bi-directional many-to-many association to Course
   @JsonIgnore
    private List<CourseDTO> courses1;

    @JsonIgnore
    private List<CourseDTO> courses2;

    //bi-directional many-to-one association to CourseRequirement

    private List<CourseRequirementDTO> courseRequirements;

    //bi-directional many-to-one association to Group

    private List<GroupDTO> groups;

    //bi-directional many-to-one association to Outline

    private OutlineDTO outline;

    //bi-directional many-to-one association to Rate

    private List<RateDTO> rates = new ArrayList<>();

    //bi-directional many-to-one association to UserRoleCourse

    private List<UserRoleCourseDTO> userRoleCourses = new ArrayList<>();
    List<DocumentDTO> documents = new ArrayList<>();
    private String createdBy;

    private Date createdDate;

    private String modifiedBy;

    private Date modifiedDate;
}
