package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the MailContact database table.
 * 
 */
@Entity
@Table(name = "MailContact")
@Getter
@Setter
public class MailContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
    @NotEmpty
    @Length(min = 50 ,message = "nội dung phải chứa ít nhất 50 kí tự !")
	@Column(name = "contents",columnDefinition = "TEXT")
	private String contents;
    @NotEmpty
    @Email(message = "kiểm tra lại định dạng email !")
	@Column(name = "email",columnDefinition = "nvarchar(255)")
	private String email;
	@LastModifiedDate
	private Date lastUpdate;
	@NotEmpty
	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String namemail;
	@CreatedDate
	private Date timeCreate;

	public MailContact() {
	}



}