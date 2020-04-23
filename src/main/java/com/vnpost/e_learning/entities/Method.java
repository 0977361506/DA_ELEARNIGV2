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
 * The persistent class for the Method database table.
 * 
 */
@Entity
@Table(name = "Method")
@Getter
@Setter
public class Method implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@LastModifiedDate
	private Date lastUpdate;
	@Column(name = "nameMethod",columnDefinition = "nvarchar(255)")
	private String nameMethod;
	@CreatedDate
	private Date timeCreate;

	//bi-directional many-to-one association to StatisticalAction
	@OneToMany(mappedBy="method")
	private List<StatisticalAction> statisticalActions;

	public Method() {
	}



	

}