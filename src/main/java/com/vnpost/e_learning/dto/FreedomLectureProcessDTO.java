package com.vnpost.e_learning.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FreedomLectureProcessDTO {
    long id ;


    private int timeLearn;


    private ChapterDTO chapter;


    private FreedomLectureDTO freedomLecture;


    private UsersDTO user;
}
