package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the ImageSlideShow database table.
 * 
 */
@Entity
@Table(name = "ImageSlideShow")
@Getter
@Setter
public class ImageSlideShow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "linkImage",columnDefinition = "nvarchar(255)")
	private String linkImage;
	@CreatedDate
	private Date timeCreate;

	public ImageSlideShow() {
	}


}