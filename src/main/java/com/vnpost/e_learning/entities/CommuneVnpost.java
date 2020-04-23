package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "CommuneVnpost")
@Entity
@Getter
@Setter
public class CommuneVnpost {
    @Id
    @Column(name = "CommuneCode",columnDefinition = "nvarchar")
    private Long id;
    @Column(name = "CommuneName",columnDefinition = "nvarchar(255)")
    private String name;
    @ManyToOne
    @JoinColumn(name = "DistrictCode")
    private DistrictVnpost districtVnpost;
    @OneToMany(mappedBy = "communeVnpost")
    private List<UnitVnpost> unitVnposts = new ArrayList<>();

    @OneToMany(mappedBy = "communeVnpost")
    private List<PoscodeVnpost> poscodeVnposts = new ArrayList<>();

}
