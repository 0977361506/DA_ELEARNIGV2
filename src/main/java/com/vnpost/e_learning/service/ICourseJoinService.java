package com.vnpost.e_learning.service;

import java.util.List;

import com.vnpost.e_learning.entities.Course;
import com.vnpost.e_learning.entities.CourseJoin;


public interface ICourseJoinService {
	public List<Course> getListByCourseJion(Long id);
}
