package com.idata.eboks.models;

public class RequestAccessProperties {
    private EmailClass requestKey;
    private EmailClass createdAt;
    private EmailClass createdBy;
    private EmailClass status;
    private ClientID clientID;
    private EmailClass clientName;
    private EmailClass tenantName;
    private EmailClass tenantKey;

    public EmailClass getRequestKey() {
        return requestKey;
    }

    public void setRequestKey(EmailClass value) {
        this.requestKey = value;
    }

    public EmailClass getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(EmailClass value) {
        this.createdAt = value;
    }

    public EmailClass getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(EmailClass value) {
        this.createdBy = value;
    }

    public EmailClass getStatus() {
        return status;
    }

    public void setStatus(EmailClass value) {
        this.status = value;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public void setClientID(ClientID value) {
        this.clientID = value;
    }

    public EmailClass getClientName() {
        return clientName;
    }

    public void setClientName(EmailClass value) {
        this.clientName = value;
    }

    public EmailClass getTenantName() {
        return tenantName;
    }

    public void setTenantName(EmailClass value) {
        this.tenantName = value;
    }

    public EmailClass getTenantKey() {
        return tenantKey;
    }

    public void setTenantKey(EmailClass value) {
        this.tenantKey = value;
    }
}