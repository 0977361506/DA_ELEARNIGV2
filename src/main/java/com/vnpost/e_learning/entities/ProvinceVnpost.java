package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "ProvinceVnpost")
@Entity
@Getter
@Setter
public class ProvinceVnpost {
    @Id
    @Column(name = "ProvinceCode")
    private Long provinceCode;
    @Column(name = "ProvinceName",columnDefinition = "nvarchar(255)")
    private String name;
    @Column(name = "Description",columnDefinition = "nvarchar(255)")
    private String description;

    @OneToMany(mappedBy = "provinceVnpost")
    List<DistrictVnpost> districtVnposts = new ArrayList<>();
}
