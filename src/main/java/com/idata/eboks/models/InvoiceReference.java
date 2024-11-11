package com.idata.eboks.models;

import java.io.IOException;

public enum InvoiceReference {
    INVOICE_NR_123;

    public String toValue() {
        switch (this) {
            case INVOICE_NR_123:
                return "Invoice Nr #123";
        }
        return null;
    }

    public static InvoiceReference forValue(String value) throws IOException {
        if (value.equals("Invoice Nr #123"))
            return INVOICE_NR_123;
        throw new IOException("Cannot deserialize InvoiceReference");
    }
}