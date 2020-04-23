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
 * The persistent class for the GroupReport database table.
 * 
 */
@Entity
@Table(name = "GroupReport")
@Getter
@Setter
public class GroupReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "nameGroup",columnDefinition = "nvarchar(255)")
	private String nameGroup;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to ConfigReport
	@OneToMany(mappedBy="groupReport")
	private List<ConfigReport> configReports;

	public GroupReport() {
	}



}