package com.idata.eboks.models;

public class V1TenantTenantKeyUsermatchPost {
    private String operationID;
    private String summary;
    private String description;
    private String[] tags;
    private FluffyParameter[] parameters;
    private IndigoRequestBody requestBody;
    private IndecentResponses responses;

    public String getOperationID() {
        return operationID;
    }

    public void setOperationID(String value) {
        this.operationID = value;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String value) {
        this.summary = value;
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

    public IndigoRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(IndigoRequestBody value) {
        this.requestBody = value;
    }

    public IndecentResponses getResponses() {
        return responses;
    }

    public void setResponses(IndecentResponses value) {
        this.responses = value;
    }
}