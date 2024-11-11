package com.idata.eboks.models;

import java.time.LocalDate;

public class ContentToUserValue {
    private String ssn;
    private String subject;
    private LocalDate generatedAt;
    private String type;
    private FileElement[] files;

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

    public FileElement[] getFiles() {
        return files;
    }

    public void setFiles(FileElement[] value) {
        this.files = value;
    }
}
