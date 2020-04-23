package com.vnpost.e_learning.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class OutlineDTO {
    private long id;

    private String name;

   @JsonIgnore
    private CourseDTO course;

    private List<ChapterDTO> chapters = new ArrayList<>();
}
