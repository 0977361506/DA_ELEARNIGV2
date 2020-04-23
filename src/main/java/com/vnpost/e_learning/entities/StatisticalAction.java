package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;




/**
 * The persistent class for the StatisticalAction database table.
 * 
 */
@Entity
@Table(name = "StatisticalAction")
@Getter
@Setter
public class StatisticalAction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "nameStatistical",columnDefinition = "nvarchar(255)")
	private String nameStatistical;
	@CreatedDate
	private Date timeCreate;

	private Date timeUp;
	@Column(name = "urlStatistical",columnDefinition = "nvarchar(255)")
	private String urlStatistical;

	//bi-directional many-to-one association to Method
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idMethod")
	private Method method;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private User user;

	public StatisticalAction() {
	}



}