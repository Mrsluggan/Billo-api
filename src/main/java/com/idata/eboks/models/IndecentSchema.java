package com.idata.eboks.models;

public class IndecentSchema {
    private String type;
    private String[] schemaEnum;
    private FluffyExample example;
    private Long schemaDefault;

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String[] getSchemaEnum() {
        return schemaEnum;
    }

    public void setSchemaEnum(String[] value) {
        this.schemaEnum = value;
    }

    public FluffyExample getExample() {
        return example;
    }

    public void setExample(FluffyExample value) {
        this.example = value;
    }

    public Long getSchemaDefault() {
        return schemaDefault;
    }

    public void setSchemaDefault(Long value) {
        this.schemaDefault = value;
    }
}