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
 * The persistent class for the Configurationn database table.
 * 
 */
@Entity
@Table(name = "Configurationn")
@Getter
@Setter
public class Configurationn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@LastModifiedDate
	private Date lastUpdate;

	private int statusConfigurationn;
	@CreatedDate
	private Date timeCreate;
	@Column(name = "valueConfigurationn",columnDefinition = "TEXT")
	private String valueConfigurationn;

	//bi-directional many-to-one association to TypeData
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idTypeData")
	private TypeData typeData;

	public Configurationn() {
	}



	
}