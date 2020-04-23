package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate    
    private Date createdDate;


    @LastModifiedDate
    private Date modifiedDate;
    //@Setter(AccessLevel.PRIVATE)

    @CreatedBy
    @Column(name = "createdBy",columnDefinition = "nvarchar(255)")
    private String createdBy;


    @LastModifiedBy
    @Column(name = "modifiedBy",columnDefinition = "nvarchar(255)")
    private String modifiedBy;
}
