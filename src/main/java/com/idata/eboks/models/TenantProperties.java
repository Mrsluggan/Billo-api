package com.idata.eboks.models;

public class TenantProperties {
    private EmailClass name;
    private CompanyIDClass companyID;
    private EditSecurityLevel editSecurityLevel;
    private Groups groups;
    private EmailClass visibility;
    private NameClass createdAt;
    private NameClass createdBy;
    private EmailClass status;
    private EmailClass propertiesClass;

    public EmailClass getName() {
        return name;
    }

    public void setName(EmailClass value) {
        this.name = value;
    }

    public CompanyIDClass getCompanyID() {
        return companyID;
    }

    public void setCompanyID(CompanyIDClass value) {
        this.companyID = value;
    }

    public EditSecurityLevel getEditSecurityLevel() {
        return editSecurityLevel;
    }

    public void setEditSecurityLevel(EditSecurityLevel value) {
        this.editSecurityLevel = value;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups value) {
        this.groups = value;
    }

    public EmailClass getVisibility() {
        return visibility;
    }

    public void setVisibility(EmailClass value) {
        this.visibility = value;
    }

    public NameClass getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(NameClass value) {
        this.createdAt = value;
    }

    public NameClass getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(NameClass value) {
        this.createdBy = value;
    }

    public EmailClass getStatus() {
        return status;
    }

    public void setStatus(EmailClass value) {
        this.status = value;
    }

    public EmailClass getPropertiesClass() {
        return propertiesClass;
    }

    public void setPropertiesClass(EmailClass value) {
        this.propertiesClass = value;
    }
}