/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author HP B&O
 */
@Entity
@Table(name = "mst_enquiry_sources")
public class EnquirySource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "source_name")
    private String name;
    @Column(name = "source_color")
    private String color;
    @CreationTimestamp
    @Column(name = "created_date", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @UpdateTimestamp
    @Column(name = "modified_date", nullable = true, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Column(name = "deleted_date", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;
    @Column(name = "is_deleted", nullable = true)
    private boolean deleted;
    @Column(name = "status")
    private boolean status;

    public EnquirySource() {
    }

    public EnquirySource(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
