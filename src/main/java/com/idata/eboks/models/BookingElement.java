package com.idata.eboks.models;

import java.time.OffsetDateTime;

public class BookingElement {
    private String title;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
    private String description;
    private String location;
    private String infoURL;

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetDateTime value) {
        this.startTime = value;
    }

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(OffsetDateTime value) {
        this.endTime = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String value) {
        this.location = value;
    }

    public String getInfoURL() {
        return infoURL;
    }

    public void setInfoURL(String value) {
        this.infoURL = value;
    }
}