package com.vnpost.e_learning.dto;

import org.springframework.stereotype.Component;

import com.vnpost.e_learning.entities.Coursecategory;
@Component
public class CourseCategoryDtos {
    private long id;

    private String name;
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CourseCategoryDtos convertTodto(Coursecategory c) {
    	CourseCategoryDtos categoryDtos = new CourseCategoryDtos();
    	try {
    		categoryDtos.setId(c.getId());
        	categoryDtos.setName(c.getName());
		} catch (Exception e) {
			System.out.println("ko tim thấy");
			categoryDtos.setName("không tìm thấy danh mục nào !");
		}
    	return categoryDtos;
    }
	public Coursecategory converttoEntity(CourseCategoryDtos c) {
		Coursecategory cc= new Coursecategory();
		cc.setId(c.getId());
		cc.setName(c.getName());
		return cc;
	}
}
