package com.idata.eboks.models;

public class Put {
    private String summary;
    private String[] tags;
    private String description;
    private DeleteParameter[] parameters;
    private PutRequestBody requestBody;
    private PutResponses responses;

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

    public DeleteParameter[] getParameters() {
        return parameters;
    }

    public void setParameters(DeleteParameter[] value) {
        this.parameters = value;
    }

    public PutRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(PutRequestBody value) {
        this.requestBody = value;
    }

    public PutResponses getResponses() {
        return responses;
    }

    public void setResponses(PutResponses value) {
        this.responses = value;
    }
}
