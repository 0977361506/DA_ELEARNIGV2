package com.vnpost.e_learning.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vnpost.e_learning.entities.CourseWare;
import com.vnpost.e_learning.entities.CourseWareType;




@Component
public class CourseWareDTO {
	private Long id;
	
	private String name;
	//@JsonIgnore
	private CourseWareType courseWareType;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CourseWareType getCourseWareType() {
		return courseWareType;
	}

	public void setCourseWareType(CourseWareType courseWareType) {
		this.courseWareType = courseWareType;
	}

	public CourseWareDTO convertToCourseWareDTO(CourseWare courseWare) {
		CourseWareDTO c = new CourseWareDTO();
		c.setId(courseWare.getId());
		c.setName(courseWare.getName());
	c.setCourseWareType(courseWare.getCourseWareType());
		return c;
	}
}
