package com.idata.eboks.models;

public class MinAmount {
    private Type type;
    private String description;
    private boolean nullable;

    public Type getType() {
        return type;
    }

    public void setType(Type value) {
        this.type = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public boolean getNullable() {
        return nullable;
    }

    public void setNullable(boolean value) {
        this.nullable = value;
    }
}
