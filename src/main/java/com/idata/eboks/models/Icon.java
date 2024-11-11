package com.idata.eboks.models;

public class Icon {
    private String type;
    private String[] required;
    private IconProperties properties;

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

    public IconProperties getProperties() {
        return properties;
    }

    public void setProperties(IconProperties value) {
        this.properties = value;
    }
}