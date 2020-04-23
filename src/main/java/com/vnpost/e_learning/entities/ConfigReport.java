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
 * The persistent class for the ConfigReport database table.
 * 
 */
@Entity
@Table(name = "ConfigReport")
@Getter
@Setter
public class ConfigReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "configFilter",columnDefinition = "TEXT")
	private String configFilter;
	@Column(name = "dataSources",columnDefinition = "TEXT")
	private String dataSources;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "nameConfig",columnDefinition = "nvarchar(255)")
	private String nameConfig;
	@Column(name = "nameFile",columnDefinition = "nvarchar(255)")
	private String nameFile;
	@Column(name = "statusConfig",columnDefinition = "nvarchar(255)")
	private String statusConfig;//Nên để là int
	@CreatedDate
	private Date timeCreate;
	@Column(name = "urlConfig",columnDefinition = "nvarchar(255)")
	private String urlConfig;

	//bi-directional many-to-one association to GroupReport
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idGroupReport")
	private GroupReport groupReport;



}