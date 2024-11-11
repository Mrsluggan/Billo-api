package com.idata.eboks.models;

public class Groups {
    private String type;
    private ContentType items;
    private boolean readOnly;
    private String description;
    private Object[] example;
    private boolean deprecated;

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public ContentType getItems() {
        return items;
    }

    public void setItems(ContentType value) {
        this.items = value;
    }

    public boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean value) {
        this.readOnly = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public Object[] getExample() {
        return example;
    }

    public void setExample(Object[] value) {
        this.example = value;
    }

    public boolean getDeprecated() {
        return deprecated;
    }

    public void setDeprecated(boolean value) {
        this.deprecated = value;
    }
}