package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DocumentCategory database table.
 * 
 */
@Entity
@Table(name = "DocumentCategory")
@Setter
@Getter
public class DocumentCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "describes",columnDefinition = "TEXT")
	private String describes;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "nameDocument",columnDefinition = "nvarchar(255)")
	private String nameDocument;
	@CreatedDate
	private Date timeCreate;
	private Long parent;
	
	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="documentCategory")
	private List<Document> documents;

	//bi-directional many-to-one association to TreeDocument
	@OneToMany(mappedBy="documentCategory1")
	private List<TreeDocument> treeDocuments1;

	//bi-directional many-to-one association to TreeDocument
	@OneToMany(mappedBy="documentCategory2")
	private List<TreeDocument> treeDocuments2;


}