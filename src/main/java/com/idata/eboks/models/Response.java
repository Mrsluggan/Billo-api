package com.idata.eboks.models;

public class Response {
    private String description;
    private ResponseContent content;
    private ResponseHeaders headers;

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public ResponseContent getContent() {
        return content;
    }

    public void setContent(ResponseContent value) {
        this.content = value;
    }

    public ResponseHeaders getHeaders() {
        return headers;
    }

    public void setHeaders(ResponseHeaders value) {
        this.headers = value;
    }
}