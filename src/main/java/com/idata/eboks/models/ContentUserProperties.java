package com.idata.eboks.models;

public class ContentUserProperties {
    private EmailClass ssn;
    private EmailClass subject;
    private NameClass generatedAt;
    private EmailClass type;
    private EmailClass retain;
    private EmailClass retentionDays;
    private EmailClass email;
    private EmailClass files;
    private EmailClass context;

    public EmailClass getSsn() {
        return ssn;
    }

    public void setSsn(EmailClass value) {
        this.ssn = value;
    }

    public EmailClass getSubject() {
        return subject;
    }

    public void setSubject(EmailClass value) {
        this.subject = value;
    }

    public NameClass getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(NameClass value) {
        this.generatedAt = value;
    }

    public EmailClass getType() {
        return type;
    }

    public void setType(EmailClass value) {
        this.type = value;
    }

    public EmailClass getRetain() {
        return retain;
    }

    public void setRetain(EmailClass value) {
        this.retain = value;
    }

    public EmailClass getRetentionDays() {
        return retentionDays;
    }

    public void setRetentionDays(EmailClass value) {
        this.retentionDays = value;
    }

    public EmailClass getEmail() {
        return email;
    }

    public void setEmail(EmailClass value) {
        this.email = value;
    }

    public EmailClass getFiles() {
        return files;
    }

    public void setFiles(EmailClass value) {
        this.files = value;
    }

    public EmailClass getContext() {
        return context;
    }

    public void setContext(EmailClass value) {
        this.context = value;
    }
}
