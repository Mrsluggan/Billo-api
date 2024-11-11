package com.idata.eboks.models;

public class V1TenantTenantKeyUserGet {
    private String operationID;
    private String summary;
    private String[] tags;
    private String description;
    private TentacledParameter[] parameters;
    private IndigoResponses responses;

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

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] value) {
        this.tags = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public TentacledParameter[] getParameters() {
        return parameters;
    }

    public void setParameters(TentacledParameter[] value) {
        this.parameters = value;
    }

    public IndigoResponses getResponses() {
        return responses;
    }

    public void setResponses(IndigoResponses value) {
        this.responses = value;
    }
}
