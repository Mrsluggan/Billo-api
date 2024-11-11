package com.idata.eboks.models;

public class TentacledParameter {
    private String name;
    private String in;
    private boolean required;
    private String description;
    private IndecentSchema schema;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String value) {
        this.in = value;
    }

    public boolean getRequired() {
        return required;
    }

    public void setRequired(boolean value) {
        this.required = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public IndecentSchema getSchema() {
        return schema;
    }

    public void setSchema(IndecentSchema value) {
        this.schema = value;
    }
}