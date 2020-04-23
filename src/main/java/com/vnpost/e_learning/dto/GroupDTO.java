package com.vnpost.e_learning.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vnpost.e_learning.entities.Course;

import java.util.Date;
import java.util.List;

public class GroupDTO {
    private long id;

    private String createdBy;

    private Date createdDate;

    private String modifiedBy;

    private Date modifiedDate;

    private String name;

    //bi-directional many-to-one association to CourseJoin

    private List<CourseJoinDTO> courseJoins;

    @JsonIgnore
    private Course course;
}
