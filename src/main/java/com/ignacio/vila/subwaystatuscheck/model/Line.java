package com.ignacio.vila.subwaystatuscheck.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Line {
    @Id
    @GeneratedValue
    private Integer id;

    private String lineName;
    private String lineStatus;
    private Integer lineFrequency;

    public Line() {
    }

    public Line(String lineName, String lineStatus, Integer lineFrequency) {
        this.lineName = lineName;
        this.lineStatus = lineStatus;
        this.lineFrequency = lineFrequency;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getLineStatus() {
        return lineStatus;
    }

    public void setLineStatus(String lineStatus) {
        this.lineStatus = lineStatus;
    }

    public Integer getLineFrequency() {
        return lineFrequency;
    }

    public void setLineFrequency(Integer lineFrequency) {
        this.lineFrequency = lineFrequency;
    }
}