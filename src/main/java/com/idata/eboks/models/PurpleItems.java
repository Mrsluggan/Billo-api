package com.idata.eboks.models;

public class PurpleItems {
    private String type;
    private FluffyProperties properties;
    private ExampleElement[] example;

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public FluffyProperties getProperties() {
        return properties;
    }

    public void setProperties(FluffyProperties value) {
        this.properties = value;
    }

    public ExampleElement[] getExample() {
        return example;
    }

    public void setExample(ExampleElement[] value) {
        this.example = value;
    }
}