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
 * The persistent class for the DetailPermisstion database table.
 * 
 */
@Entity
@Table(name = "DetailPermisstion")
@Getter
@Setter
public class DetailPermisstion implements Serializable {
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

	//bi-directional many-to-one association to Permistion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idPermistion")
	private Permistion permistion;


}