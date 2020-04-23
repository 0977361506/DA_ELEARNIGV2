package com.vnpost.e_learning.converter;

import com.vnpost.e_learning.dto.CourseCategoryDtos;
import com.vnpost.e_learning.dto.CoursecategoryDTO;
import com.vnpost.e_learning.entities.Coursecategory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseCategoryConverter implements IDTO<CoursecategoryDTO>,IEntity<Coursecategory>  {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CoursecategoryDTO convertToDTO(Object entity) {
        CoursecategoryDTO dto = modelMapper.map(entity,CoursecategoryDTO.class);
        return dto;
    }

    @Override
    public Coursecategory convertToEntity(Object dto) {
        Coursecategory entity = modelMapper.map(dto,Coursecategory.class);
        return entity;
    } 

    
}
