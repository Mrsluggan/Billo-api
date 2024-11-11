package com.idata.eboks.models;

public class Ssns {
    private String type;
    private SsnsItems items;
    private String description;

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public SsnsItems getItems() {
        return items;
    }

    public void setItems(SsnsItems value) {
        this.items = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }
}