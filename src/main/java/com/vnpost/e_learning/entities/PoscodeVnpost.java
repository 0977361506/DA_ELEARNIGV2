package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "PoscodeVnpost")
@Entity
public class PoscodeVnpost {
    @Id
    @Column(name = "POSCode")
    private Long id;
    @Column(name = "POSName",columnDefinition = "nvarchar(255)")
    private String name;
    @Column(name = "Address",columnDefinition = "nvarchar(255)")
    private String address;
    @Column(name = "POSTypeCode",columnDefinition = "nvarchar(255)")
    private String typeCode;
    @Column(name = "POSLevelCode",columnDefinition = "nvarchar(255)")
    private String levelCode;
    @Column(name = "isOffline",columnDefinition = "nvarchar(255)")
    private String isOffice;
    @Column(name = "Status",columnDefinition = "nvarchar(255)")
    private String status;
    @ManyToOne
    @JoinColumn(name = "CommuneCode")
    private CommuneVnpost communeVnpost;
    @ManyToOne
    @JoinColumn(name = "UnitCode")
    private UnitVnpost unitVnpost;
    @OneToMany(mappedBy = "poscodeVnpost")
    List<Competition> competitions = new ArrayList<>();
    @OneToMany(mappedBy = "poscodeVnpost")
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "poscodeVnpost")
    private List<Document> documents = new ArrayList<>();

    @OneToMany(mappedBy = "poscodeVnpost")
    private List<Eventt> events = new ArrayList<>();
    @OneToMany(mappedBy = "poscodeVnpost")
    private List<Groupposition> grouppositions = new ArrayList<>();
    @OneToMany(mappedBy = "poscodeVnpost")
    private List<New> news = new ArrayList<>();
    @OneToMany(mappedBy = "poscodeVnpost")
    private List<QuestionCategory> questionCategories = new ArrayList<>();
    @OneToMany(mappedBy = "poscodeVnpost")
    private List<StructTest> structTests = new ArrayList<>();

    @OneToMany(mappedBy = "poscodeVnpost")
    private List<User> users = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "poscode_vnpost_course"
            ,	joinColumns = @JoinColumn(name = "id_poscode_vnpost")
            ,inverseJoinColumns = @JoinColumn(name = "id_course"))
    private List<Course> coursesStudy = new ArrayList<>();

}
