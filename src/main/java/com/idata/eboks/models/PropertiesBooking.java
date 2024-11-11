package com.idata.eboks.models;

public class PropertiesBooking {
    private String type;
    private String description;
    private BookingItems items;

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public BookingItems getItems() {
        return items;
    }

    public void setItems(BookingItems value) {
        this.items = value;
    }
}