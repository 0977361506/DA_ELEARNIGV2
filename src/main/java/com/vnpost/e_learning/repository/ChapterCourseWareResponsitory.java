package com.vnpost.e_learning.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vnpost.e_learning.entities.ChapterCourseWare;

@Repository
public interface ChapterCourseWareResponsitory extends CrudRepository<ChapterCourseWare,Long> {

}
