package com.vnpost.e_learning.dto;

import com.vnpost.e_learning.entities.HomeWorkAnswer;
import com.vnpost.e_learning.entities.HomeWorkLectureProcess;
import com.vnpost.e_learning.entities.InterActiveLectureprocess;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UsersDTO {
    private long id;

    private Date birthday;

    private String email;

    private long idPosition;

    private String idUnit;

    private String imageUsers;


    private String name_Users;

    private String passwordUsers;

    private String phoneNumber;

    private String place;

    private int gender;

    private int status;

    private Date lastUpdate;

    private Date timeCreate;


    private List<CandidateDTO> candidates;

    //bi-directional many-to-one association to Certificatee

    private List<CertificateDTO> certificatees;


    private List<CommentDTO> comments;

    //bi-directional many-to-one association to CourseJoin
    private List<CourseJoinDTO> courseJoins;

    //bi-directional many-to-one association to Eventt

    private List<EventDTO> eventts;

    //bi-directional many-to-one association to Formemail

    private List<FormEmailDTO> formemails;

    //bi-directional many-to-one association to FreedomLectureProcess

    private List<FreedomLectureProcessDTO> freedomLectureProcesses;

    //bi-directional many-to-one association to HomeWorkAnswer

    private List<HomeworkAnswerDTO> homeWorkAnswers;

    //bi-directional many-to-one association to HomeWorkLectureProcess

    private List<HomeworkLectureProcessDTO> homeWorkLectureProcesses;

    //bi-directional many-to-one association to InterActiveLectureprocess

    private List<InteractiveLectureProcessDTO> interActiveLectureprocesses;

    //bi-directional many-to-one association to New

    private List<NewsDTO> news;


    private List<PowerPointLectureProcessDTO> powerpointLectureProcesses;


    private List<RateDTO> rates;


    private List<ResultDTO> results;


    private List<ScormLectureProcessDTO> scormLectureProcesses;


    private List<StatisticalActionDTO> statisticalActions;


    private List<StatisticalRoundTestDTO> statisticalRoundTests;


    private List<SubjectDTO> subjects;


    private List<TestDTO> tests;

    //bi-directional many-to-one association to UserPermistion

    private List<UserPermissDTO> userPermistions;


    private List<UserRoleCourseDTO> userRoleCourses;


    private WardDTO ward;


    private List<VideoLectureProcessDTO> videoLectureProcesses;
}
