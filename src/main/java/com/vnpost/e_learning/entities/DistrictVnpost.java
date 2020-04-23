package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "DistrictVnpost")
@Entity
@Getter
@Setter
public class DistrictVnpost {
    @Id
    @Column(name = "DistrictCode")
    private Long id;
    @Column(name = "DistrictName",columnDefinition = "nvarchar(255)")
    private String name;
    @Column(name = "Description",columnDefinition = "nvarchar(255)")
    private String description;
    @ManyToOne
    @JoinColumn(name = "ProvinceCode")
    private ProvinceVnpost provinceVnpost;

    @OneToMany(mappedBy = "districtVnpost")
    private List<CommuneVnpost> communeVnposts = new ArrayList<>();
}
