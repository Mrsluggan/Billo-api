package com.idata.eboks.models;

public class Account {
    private Type type;
    private String description;

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
}