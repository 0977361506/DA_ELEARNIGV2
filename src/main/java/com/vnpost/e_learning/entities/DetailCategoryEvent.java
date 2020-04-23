package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import org.apache.poi.poifs.property.Parent;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DetailCategoryEvent database table.
 * 
 */
@Entity
@Table(name = "DetailCategoryEvent")
@Getter
@Setter
public class DetailCategoryEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private Date lastUpdate;
	@Column(name = "nameDetail",columnDefinition = "nvarchar(255)")
	private String nameDetail;
	@CreatedDate
	private Date timeCreate;
	
	private Long parent;
	
	

	//bi-directional many-to-one association to Eventt
	@OneToMany(mappedBy="detailCategoryEvent")
	private List<Eventt> eventts;

	//bi-directional many-to-one association to TreeEvent
	@OneToMany(mappedBy="detailCategoryEvent1")
	private List<TreeEvent> treeEvents1;

	//bi-directional many-to-one association to TreeEvent
	@OneToMany(mappedBy="detailCategoryEvent2")
	private List<TreeEvent> treeEvents2;


	
}