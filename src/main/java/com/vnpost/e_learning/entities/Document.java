package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Document database table.
 * 
 */
@Entity
@Table(name = "Document")
@Setter
@Getter
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "describes",columnDefinition = "TEXT")
	private String describes;
	@ManyToOne
	@JoinColumn(name = "idUnit")
	private PoscodeVnpost poscodeVnpost;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "linkFile",columnDefinition = "TEXT")
	private String linkFile;
	@Column(name = "nameDocument")
	private String name;

	private int shares;
	@Column(name = "statusDocument")
	private int status;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to CourseDocument

	@ManyToMany(mappedBy = "documents")
	private List<Course> courses = new ArrayList<>();
	//bi-directional many-to-one association to DocumentCategory
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idDocumentCategory")
	private DocumentCategory documentCategory;

	//bi-directional many-to-one association to LimitDocument
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idLimit")
	private LimitDocument limitDocument;

	//bi-directional many-to-one association to Prioritize
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idPrioritize")
	private Prioritize prioritize;

	public Document() {
	}



	

}