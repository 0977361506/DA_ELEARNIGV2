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
 * The persistent class for the Formemail database table.
 * 
 */
@Entity
@Table(name = "Formemail")
@Getter
@Setter
public class Formemail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "functionemail",columnDefinition = "nvarchar(255)")
	private String functionemail;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "nameForm",columnDefinition = "nvarchar(255)")
	private String nameForm;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private User user;





}