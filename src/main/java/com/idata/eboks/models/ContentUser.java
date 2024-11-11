package com.idata.eboks.models;

public class ContentUser {
    private String type;
    private String[] required;
    private ContentUserProperties properties;

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String[] getRequired() {
        return required;
    }

    public void setRequired(String[] value) {
        this.required = value;
    }

    public ContentUserProperties getProperties() {
        return properties;
    }

    public void setProperties(ContentUserProperties value) {
        this.properties = value;
    }
}