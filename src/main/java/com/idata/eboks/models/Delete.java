package com.idata.eboks.models;

public class Delete {
    private String[] tags;
    private String summary;
    private String operationID;
    private String description;
    private DeleteParameter[] parameters;
    private DeleteResponses responses;
    private DeleteRequestBody requestBody;

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

    public DeleteResponses getResponses() {
        return responses;
    }

    public void setResponses(DeleteResponses value) {
        this.responses = value;
    }

    public DeleteRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(DeleteRequestBody value) {
        this.requestBody = value;
    }
}