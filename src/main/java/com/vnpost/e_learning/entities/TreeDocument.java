package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;




/**
 * The persistent class for the TreeDocument database table.
 * 
 */
@Entity
@Table(name = "TreeDocument")
@Getter
@Setter
public class TreeDocument implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@LastModifiedDate
	private Date lastUpdate;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to DocumentCategory
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idDocumentCategoryOne")
	private DocumentCategory documentCategory1;

	//bi-directional many-to-one association to DocumentCategory
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idDocumentCategoryTwo")
	private DocumentCategory documentCategory2;



}