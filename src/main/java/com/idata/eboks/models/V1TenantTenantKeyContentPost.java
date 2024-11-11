package com.idata.eboks.models;

public class V1TenantTenantKeyContentPost {
    private String summary;
    private String operationID;
    private String description;
    private String[] tags;
    private FluffyParameter[] parameters;
    private StickyRequestBody requestBody;
    private StickyResponses responses;

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

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] value) {
        this.tags = value;
    }

    public FluffyParameter[] getParameters() {
        return parameters;
    }

    public void setParameters(FluffyParameter[] value) {
        this.parameters = value;
    }

    public StickyRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(StickyRequestBody value) {
        this.requestBody = value;
    }

    public StickyResponses getResponses() {
        return responses;
    }

    public void setResponses(StickyResponses value) {
        this.responses = value;
    }
}