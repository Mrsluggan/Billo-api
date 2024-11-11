package com.idata.eboks.models;

public class V1TenantGet {
    private String[] tags;
    private String summary;
    private String operationID;
    private String description;
    private PurpleParameter[] parameters;
    private PurpleResponses responses;

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] value) {
        this.tags = value;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String value) {
        this.summary = value;
    }

    public String getOperationID() {
        return operationID;
    }

    public void setOperationID(String value) {
        this.operationID = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public PurpleParameter[] getParameters() {
        return parameters;
    }

    public void setParameters(PurpleParameter[] value) {
        this.parameters = value;
    }

    public PurpleResponses getResponses() {
        return responses;
    }

    public void setResponses(PurpleResponses value) {
        this.responses = value;
    }
}