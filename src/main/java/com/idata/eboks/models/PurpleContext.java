package com.idata.eboks.models;

public class PurpleContext {
    private BookingElement[] booking;
    private ContextInvoice invoice;
    private InvoiceReference invoiceReference;

    public BookingElement[] getBooking() {
        return booking;
    }

    public void setBooking(BookingElement[] value) {
        this.booking = value;
    }

    public ContextInvoice getInvoice() {
        return invoice;
    }

    public void setInvoice(ContextInvoice value) {
        this.invoice = value;
    }

    public InvoiceReference getInvoiceReference() {
        return invoiceReference;
    }

    public void setInvoiceReference(InvoiceReference value) {
        this.invoiceReference = value;
    }
}