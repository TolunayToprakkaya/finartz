package com.project.finartz.base.type;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.Date;

public abstract class AbstractEditableEntity {

    @Basic
    @CreatedDate
    @Column(name = "cdate", columnDefinition = "TIMESTAMP")
    private Date cdate;

    @Basic
    @LastModifiedDate
    @Column(name = "udate", columnDefinition = "TIMESTAMP", insertable = false)
    private Date udate;

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Date getUdate() {
        return udate;
    }

    public void setUdate(Date udate) {
        this.udate = udate;
    }
}
