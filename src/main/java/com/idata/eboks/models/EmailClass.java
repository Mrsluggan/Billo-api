package com.idata.eboks.models;

public class EmailClass {
    private String type;
    private Boolean writeOnly;
    private String description;
    private ContextProperties properties;
    private SchemaClass items;
    private ContextExample example;
    private Boolean readOnly;
    private Boolean readonly;
    private Boolean deprecated;
    private String[] contextEnum;

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public Boolean getWriteOnly() {
        return writeOnly;
    }

    public void setWriteOnly(Boolean value) {
        this.writeOnly = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public ContextProperties getProperties() {
        return properties;
    }

    public void setProperties(ContextProperties value) {
        this.properties = value;
    }

    public SchemaClass getItems() {
        return items;
    }

    public void setItems(SchemaClass value) {
        this.items = value;
    }

    public ContextExample getExample() {
        return example;
    }

    public void setExample(ContextExample value) {
        this.example = value;
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean value) {
        this.readOnly = value;
    }

    public Boolean getReadonly() {
        return readonly;
    }

    public void setReadonly(Boolean value) {
        this.readonly = value;
    }

    public Boolean getDeprecated() {
        return deprecated;
    }

    public void setDeprecated(Boolean value) {
        this.deprecated = value;
    }

    public String[] getContextEnum() {
        return contextEnum;
    }

    public void setContextEnum(String[] value) {
        this.contextEnum = value;
    }
}