package com.vnpost.e_learning.converter;

import com.vnpost.e_learning.dto.CourseDTO;
import com.vnpost.e_learning.entities.Course;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseConverter implements IDTO<CourseDTO>,IEntity<Course> {
@Autowired
private ModelMapper modelMapper;
    @Override
    public CourseDTO convertToDTO(Object entity) {
        CourseDTO dto = modelMapper.map(entity,CourseDTO.class);
        return dto;
    }

    @Override
    public Course convertToEntity(Object dto) {
        Course entity = modelMapper.map(dto,Course.class);
        return entity;
    }
}
