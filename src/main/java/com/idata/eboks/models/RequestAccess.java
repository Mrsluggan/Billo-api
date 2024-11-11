package com.idata.eboks.models;

public class RequestAccess {
    private String type;
    private RequestAccessProperties properties;

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public RequestAccessProperties getProperties() {
        return properties;
    }

    public void setProperties(RequestAccessProperties value) {
        this.properties = value;
    }
}