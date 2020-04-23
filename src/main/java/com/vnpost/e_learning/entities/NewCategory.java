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
 * The persistent class for the NewCategory database table.
 * 
 */
@Entity
@Table(name = "NewCategory")
@Getter
@Setter
public class NewCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "nameDetail",columnDefinition = "nvarchar(255)")
	private String nameDetail;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to New
	@OneToMany(mappedBy="newCategory")
	private List<New> news;

	//bi-directional many-to-one association to TreeCategory
	@OneToMany(mappedBy="newCategory1")
	private List<TreeCategory> treeCategories1;

	//bi-directional many-to-one association to TreeCategory
	@OneToMany(mappedBy="newCategory2")
	private List<TreeCategory> treeCategories2;

	public NewCategory() {
	}



}