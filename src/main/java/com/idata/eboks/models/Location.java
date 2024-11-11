package com.idata.eboks.models;

public class Location {
    private String description;
    private LocationSchema schema;

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public LocationSchema getSchema() {
        return schema;
    }

    public void setSchema(LocationSchema value) {
        this.schema = value;
    }
}
