package com.vnpost.e_learning.dto;

import java.util.ArrayList;
import java.util.List;

public class CommuneVnpostDTO {
    private String id;

    private String name;

    private DistrictVnpostDTO districtVnpost;

    private List<UnitVnpostDTO> unitVnposts = new ArrayList<>();


    private List<PoscodeVnpostDTO> poscodeVnposts = new ArrayList<>();
}
