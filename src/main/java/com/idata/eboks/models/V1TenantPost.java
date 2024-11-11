package com.idata.eboks.models;

import java.util.Map;

public class V1TenantPost {
    private String summary;
    private String description;
    private String[] tags;
    private PurpleRequestBody requestBody;
    private Map<String, Response> responses;

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

    public PurpleRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(PurpleRequestBody value) {
        this.requestBody = value;
    }

    public Map<String, Response> getResponses() {
        return responses;
    }

    public void setResponses(Map<String, Response> value) {
        this.responses = value;
    }
}