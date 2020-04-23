package com.vnpost.e_learning.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class UserRoleCourseDTO {
    private long id;

    private Date lastUpdate;

    private int status;

    private Date timeCreate;


    private CourseDTO course;


    private CourseRoleDTO courseRole;


    private UsersDTO user;
}
