package com.ajsw.microdb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.Date;

@Document
public class Request implements Serializable { //Solicitud
    @Id
    private String id;
    @Indexed(unique = true, direction = IndexDirection.ASCENDING, dropDups = true)
    private String applicantId;
    private String typeJob;
    private Date date;
    private String zone;
    private String description;
    private boolean state;

    public Request() {
    }

    public Request(String applicantId, String typeJob, Date date, String zone, String description, boolean state) {
        this.applicantId = applicantId;
        this.typeJob = typeJob;
        this.date = date;
        this.zone = zone;
        this.description = description;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getTypeJob() {
        return typeJob;
    }

    public void setTypeJob(String typeJob) {
        this.typeJob = typeJob;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isState() {
        return state;
    }

    public boolean getState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
}
