package com.idata.eboks.models;

public class EditSecurityLevel {
    private String description;
    private String type;
    private boolean readOnly;
    private long example;
    private long[] editSecurityLevelEnum;
    private boolean deprecated;

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean value) {
        this.readOnly = value;
    }

    public long getExample() {
        return example;
    }

    public void setExample(long value) {
        this.example = value;
    }

    public long[] getEditSecurityLevelEnum() {
        return editSecurityLevelEnum;
    }

    public void setEditSecurityLevelEnum(long[] value) {
        this.editSecurityLevelEnum = value;
    }

    public boolean getDeprecated() {
        return deprecated;
    }

    public void setDeprecated(boolean value) {
        this.deprecated = value;
    }
}