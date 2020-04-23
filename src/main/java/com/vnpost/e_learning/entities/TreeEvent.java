package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;




/**
 * The persistent class for the TreeEvent database table.
 * 
 */
@Entity
@Table(name = "TreeEvent")
@Getter
@Setter
public class TreeEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@LastModifiedDate
	private Date lastUpdate;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to DetailCategoryEvent
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idDetailCategoryEventOne")
	private DetailCategoryEvent detailCategoryEvent1;

	//bi-directional many-to-one association to DetailCategoryEvent
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idDetailCategoryEventTwo")
	private DetailCategoryEvent detailCategoryEvent2;

	public TreeEvent() {
	}


}