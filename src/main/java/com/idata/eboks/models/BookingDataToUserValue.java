package com.idata.eboks.models;

import java.time.LocalDate;

public class BookingDataToUserValue {
    private String ssn;
    private String subject;
    private LocalDate generatedAt;
    private String type;
    private boolean retain;
    private FileElement[] files;
    private PurpleContext context;
    private Long retentionDays;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String value) {
        this.ssn = value;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String value) {
        this.subject = value;
    }

    public LocalDate getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDate value) {
        this.generatedAt = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public boolean getRetain() {
        return retain;
    }

    public void setRetain(boolean value) {
        this.retain = value;
    }

    public FileElement[] getFiles() {
        return files;
    }

    public void setFiles(FileElement[] value) {
        this.files = value;
    }

    public PurpleContext getContext() {
        return context;
    }

    public void setContext(PurpleContext value) {
        this.context = value;
    }

    public Long getRetentionDays() {
        return retentionDays;
    }

    public void setRetentionDays(Long value) {
        this.retentionDays = value;
    }
}
