package com.vnpost.e_learning.dto;

import com.vnpost.e_learning.dto.RoleCourseActionDTO;

import java.util.Date;
import java.util.List;

public class CourseRoleDTO {
    private long id;

    private Date lastUpdate;

    private String nameCourse;

    private Date timeCreate;


    private List<RoleCourseActionDTO> roleCourseActions;


    private List<UserRoleCourseDTO> userRoleCourses;
}
