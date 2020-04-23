package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long>
{
	
}
