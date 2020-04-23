package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;




/**
 * The persistent class for the Eventt database table.
 * 
 */
@Entity
@Table(name = "Eventt")
@Getter
@Setter
public class Eventt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private int highlinghtEvent;
	@ManyToOne
	@JoinColumn(name = "idUnit")
	private PoscodeVnpost poscodeVnpost;
     private String tomtat;
     private String content;
     private String title;
     private String image;
	@LastModifiedDate
	private Date lastUpdate;
	@CreatedDate
	private Date timeCreate;

	private Date timeEnd;

	private Date timeStart;

	//bi-directional many-to-one association to DetailCategoryEvent
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idDetailCategoryEvent")
	private DetailCategoryEvent detailCategoryEvent;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private User user;


	
}