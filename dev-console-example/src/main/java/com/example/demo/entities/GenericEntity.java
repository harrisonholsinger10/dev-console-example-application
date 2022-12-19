package com.example.demo.entities;

import java.util.Date;

/**
 * Generic interface for database entities
 *
 * Copied from domain-beans
 */
public abstract class GenericEntity {

    protected String createdBy;
    protected Date createdDate;
    protected String updatedBy;
    protected Date updatedDate;
    protected String entityInstance;

    public String getCreatedBy() {
        return createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public GenericEntity getEntity() {
        return this;
    }

    public String getEntityInstance() {
        return entityInstance;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setEntityInstance(String entityInstance) {
        this.entityInstance = entityInstance;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

}
