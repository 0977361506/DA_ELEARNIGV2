package com.vnpost.e_learning.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocumentDTO {
    private long id;

    private String describes;

    private String idUnit;

    private Date lastUpdate;

    private String linkFile;

    private String name;

    private int shares;

    private int status;

    private Date timeCreate;

    //bi-directional many-to-one association to CourseDocument


    private List<CourseDTO> courses = new ArrayList<>();
    //bi-directional many-to-one association to DocumentCategory

    private DocumentCategoryDTO documentCategory;


    private LimitDocumentDTO limitDocument;


    private PrioritizeDTO prioritize;
}
