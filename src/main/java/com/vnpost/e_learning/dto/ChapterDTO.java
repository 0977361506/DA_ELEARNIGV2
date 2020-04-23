package com.vnpost.e_learning.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChapterDTO {
    private long id;
    @JsonIgnore
    private OutlineDTO outline ;


    private String createdBy;

    private Date createdDate;

    private String modifiedBy;

    private Date modifiedDate;

    private String name;


    private List<ChapterFreedomLectureDTO> chapterFreedomLectures = new ArrayList<>();


    private List<ChapterHomeworkDTO> chapterHomeWorks = new ArrayList<>();


    private List<ChapterPowerPointLectureDTO> chapterPowerpointlectures = new ArrayList<>();


    private List<ChapterScormLectureDTO> chapterScormLectures = new ArrayList<>();


    private List<ChapterVideoLectureDTO> chapterVideoLectures = new ArrayList<>();


    private List<CourseWareDTO> courseWares = new ArrayList<>();

    @JsonIgnore
    private List<FreedomLectureProcessDTO> freedomLectureProcesses = new ArrayList<>();




    private List<HomeworkLectureProcessDTO> homeWorkLectureProcesses = new ArrayList<>();


    private List<InteractiveLectureChapterDTO> interActiveLectureChapters = new ArrayList<>();


    private List<InteractiveLectureProcessDTO> interActiveLectureprocesses = new ArrayList<>();

    //bi-directional many-to-one association to PowerpointLectureProcess

    private List<PowerPointLectureProcessDTO> powerpointLectureProcesses = new ArrayList<>();

    //bi-directional many-to-one association to ScormLectureProcess

    private List<ScormLectureProcessDTO> scormLectureProcesses = new ArrayList<>();


    private List<VideoLectureProcessDTO> videoLectureProcesses = new ArrayList<>();
}
