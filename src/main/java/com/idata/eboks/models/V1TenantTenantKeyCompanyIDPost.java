package com.idata.eboks.models;

import java.util.Map;

public class V1TenantTenantKeyCompanyIDPost {
    private String[] tags;
    private String summary;
    private String operationID;
    private String description;
    private DeleteParameter[] parameters;
    private Map<String, ClientID> responses;
    private TentacledRequestBody requestBody;

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

    public DeleteParameter[] getParameters() {
        return parameters;
    }

    public void setParameters(DeleteParameter[] value) {
        this.parameters = value;
    }

    public Map<String, ClientID> getResponses() {
        return responses;
    }

    public void setResponses(Map<String, ClientID> value) {
        this.responses = value;
    }

    public TentacledRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(TentacledRequestBody value) {
        this.requestBody = value;
    }
}