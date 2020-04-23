package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "UnitVnpost")
@Entity
public class UnitVnpost {
    @Id
    @Column(name = "UnitCode")
    private Long id;
    @Column(name = "UnitName",columnDefinition = "nvarchar(255)")
    private String name;
    @Column(name = "ParentUnitCode",columnDefinition = "nvarchar(255)")
    private String parentUnitCode;

    @Column(name = "UnitTypeCode",columnDefinition = "nvarchar(255)")
    private String unitTypeCode;
    @ManyToOne
    @JoinColumn(name = "CommuneCode")
    private CommuneVnpost communeVnpost;

    @OneToMany(mappedBy = "unitVnpost")
    private List<PoscodeVnpost> poscodeVnposts = new ArrayList<>();
}
