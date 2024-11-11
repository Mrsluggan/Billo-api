package com.idata.eboks.models;

public class VatNumbers {
    private String type;
    private ContentType items;
    private boolean nullable;

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

    public boolean getNullable() {
        return nullable;
    }

    public void setNullable(boolean value) {
        this.nullable = value;
    }
}
