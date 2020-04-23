package com.vnpost.e_learning.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DistrictVnpostDTO {
    private String id;

    private String name;

    private String description;

    private ProvinceVnpostDTO provinceVnpost;


    private List<CommuneVnpostDTO> communeVnposts = new ArrayList<>();
}
