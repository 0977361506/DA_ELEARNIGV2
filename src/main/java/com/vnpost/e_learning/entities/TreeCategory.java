package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;




/**
 * The persistent class for the TreeCategory database table.
 * 
 */
@Entity
@Table(name = "TreeCategory")
@Getter
@Setter
public class TreeCategory implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@LastModifiedDate
	private Date lastUpdate;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to NewCategory
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idDetailCategoryOne",insertable = false, updatable = false)
	private NewCategory newCategory1;

	//bi-directional many-to-one association to NewCategory
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idDetailCategoryTwo")
	private NewCategory newCategory2;

	public TreeCategory() {
	}



}