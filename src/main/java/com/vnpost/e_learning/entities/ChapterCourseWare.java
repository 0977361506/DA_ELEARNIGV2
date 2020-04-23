package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "chapter_course_ware")
@Getter
@Setter
public class ChapterCourseWare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position")
    private Integer position;
    @Column(name = "percent_finished")
    private Float percentFinished;

    @Column(name = "limited_date")
    private Date limitedDate;

    @ManyToOne
    @JoinColumn(name = "id_chapter")
    private Chapter chapter;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_course_ware")
    private CourseWare courseWare;

}