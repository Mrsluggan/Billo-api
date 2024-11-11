package com.idata.eboks.models;

public class ContextInvoice {
    private PaymentClass payment;
    private InvoiceReference invoiceReference;

    public PaymentClass getPayment() {
        return payment;
    }

    public void setPayment(PaymentClass value) {
        this.payment = value;
    }

    public InvoiceReference getInvoiceReference() {
        return invoiceReference;
    }

    public void setInvoiceReference(InvoiceReference value) {
        this.invoiceReference = value;
    }
}
