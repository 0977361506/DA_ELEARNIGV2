package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the News database table.
 * 
 */
@Entity
@Table(name="News")
@Getter
@Setter
public class New implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
    private String tomtat;
    private String images;
    private String content;
	private int highlightNew;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idUnit")
	private PoscodeVnpost poscodeVnpost;
	@LastModifiedDate
	private Date lastUpdate;

	private int statusNew;
	@CreatedDate
	private Date timeCreate;
	@Column(name = "title",columnDefinition = "nvarchar(255)")
	private String title;

	//bi-directional many-to-one association to NewCategory
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idDetailCategory")
	private NewCategory newCategory;

	//bi-directional many-to-one association to User
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private User user;

	public New() {
	}


}