package com.idata.eboks.models;

public class V1TenantRequestAccessPost {
    private String[] tags;
    private String summary;
    private String operationID;
    private String description;
    private FluffyResponses responses;
    private FluffyRequestBody requestBody;

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

    public FluffyResponses getResponses() {
        return responses;
    }

    public void setResponses(FluffyResponses value) {
        this.responses = value;
    }

    public FluffyRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(FluffyRequestBody value) {
        this.requestBody = value;
    }
}
