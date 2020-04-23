package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TypeData database table.
 * 
 */
@Entity
@Table(name = "TypeData")
@Getter
@Setter
public class TypeData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "nameType",columnDefinition = "nvarchar(255)")
	private String nameType;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to Configurationn
	@OneToMany(mappedBy="typeData")
	private List<Configurationn> configurationns;

	public TypeData() {
	}


}