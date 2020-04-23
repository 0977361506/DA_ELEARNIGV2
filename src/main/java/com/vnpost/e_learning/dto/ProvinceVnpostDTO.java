package com.vnpost.e_learning.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProvinceVnpostDTO {
    private String provinceCode;

    private String name;

    private String description;


    List<DistrictVnpostDTO> districtVnposts = new ArrayList<>();
}
