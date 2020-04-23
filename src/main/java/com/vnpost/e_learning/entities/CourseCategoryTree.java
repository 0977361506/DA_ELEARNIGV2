package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Table(name = "CourseCategoryTree")
@Entity
@Setter
@Getter
public class CourseCategoryTree {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @LastModifiedDate
    private Date lastUpdate;
    @CreatedDate
    private Date timeCreate;

    //bi-directional many-to-one association to DetailCategoryEvent
   @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idCourseCategoryOne")
    private Coursecategory courseCategoryOne;

    //bi-directional many-to-one association to DetailCategoryEvent

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idCourseCatgeoryTwo")
    private Coursecategory courseCategoryTwo;
}
