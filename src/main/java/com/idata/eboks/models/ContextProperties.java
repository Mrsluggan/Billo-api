package com.idata.eboks.models;

public class ContextProperties {
    private PropertiesInvoice invoice;
    private PropertiesBooking booking;

    public PropertiesInvoice getInvoice() {
        return invoice;
    }

    public void setInvoice(PropertiesInvoice value) {
        this.invoice = value;
    }

    public PropertiesBooking getBooking() {
        return booking;
    }

    public void setBooking(PropertiesBooking value) {
        this.booking = value;
    }
}
