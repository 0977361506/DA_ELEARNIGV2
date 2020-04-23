package com.vnpost.e_learning.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "CourseWareProcess")
@Entity
@Setter
@Getter
public class CourseWareProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "status")
    private int status;
    @Column(name = "comments",columnDefinition = "nvarchar(255)")
    private String comments;

    @Column(name = "contents",columnDefinition = "TEXT")
    private String contents;

    private int lastView;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_chapter")
    private Chapter chapter;
    @ManyToOne
    @JoinColumn(name = "id_course_ware")
    private CourseWare courseWare;

    @OneToMany(mappedBy = "courseWareProcess")
    private List<HomeWorkAnswer> homeWorkAnswers = new ArrayList<>();
}
