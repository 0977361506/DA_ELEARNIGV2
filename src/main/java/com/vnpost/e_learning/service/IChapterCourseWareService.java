package com.vnpost.e_learning.service;

import java.util.List;

import com.vnpost.e_learning.entities.CourseWare;

public interface IChapterCourseWareService {
	 public List<CourseWare> getListCourseWareFromChapterCourseWare(Long id);
}
