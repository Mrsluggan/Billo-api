package com.idata.eboks.models;

public class FluffyParameter {
    private String name;
    private String in;
    private boolean required;
    private ContentType schema;

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

    public ContentType getSchema() {
        return schema;
    }

    public void setSchema(ContentType value) {
        this.schema = value;
    }
}