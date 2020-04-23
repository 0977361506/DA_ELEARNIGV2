package com.vnpost.e_learning.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UnitVnpostDTO {
    private String id;

    private String name;

    private String parentUnitCode;


    private String unitTypeCode;

    private CommuneVnpostDTO communeVnpost;


    private List<PoscodeVnpostDTO> poscodeVnposts = new ArrayList<>();
}
