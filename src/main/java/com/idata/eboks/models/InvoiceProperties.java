package com.idata.eboks.models;

public class InvoiceProperties {
    private SchemaClass payment;
    private NameClass invoiceReference;

    public SchemaClass getPayment() {
        return payment;
    }

    public void setPayment(SchemaClass value) {
        this.payment = value;
    }

    public NameClass getInvoiceReference() {
        return invoiceReference;
    }

    public void setInvoiceReference(NameClass value) {
        this.invoiceReference = value;
    }
}
