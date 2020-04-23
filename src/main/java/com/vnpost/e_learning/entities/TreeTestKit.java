package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;




/**
 * The persistent class for the TreeTestKit database table.
 * 
 */
@Entity
@Table(name = "TreeTestKit")
@Getter
@Setter
public class TreeTestKit implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@LastModifiedDate
	private Date lastUpdate;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to TestKit
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idTestKidOne")
	private TestKit testKit1;

	//bi-directional many-to-one association to TestKit
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idTestKidTwo")
	private TestKit testKit2;


}