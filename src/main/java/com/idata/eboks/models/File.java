package com.idata.eboks.models;

public class File {
    private String[] required;
    private String type;
    private FileProperties properties;
    private boolean additionalProperties;

    public String[] getRequired() {
        return required;
    }

    public void setRequired(String[] value) {
        this.required = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public FileProperties getProperties() {
        return properties;
    }

    public void setProperties(FileProperties value) {
        this.properties = value;
    }

    public boolean getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(boolean value) {
        this.additionalProperties = value;
    }
}