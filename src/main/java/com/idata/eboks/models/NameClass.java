package com.idata.eboks.models;

public class NameClass {
    private String description;
    private Type type;
    private String example;
    private String format;
    private Enum[] nameEnum;
    private Boolean readOnly;

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type value) {
        this.type = value;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String value) {
        this.example = value;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String value) {
        this.format = value;
    }

    public Enum[] getNameEnum() {
        return nameEnum;
    }

    public void setNameEnum(Enum[] value) {
        this.nameEnum = value;
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean value) {
        this.readOnly = value;
    }
}