package com.idata.eboks.models;

public class PropertiesInvoice {
    private String[] required;
    private String type;
    private String description;
    private InvoiceProperties properties;

    public String[] getRequired() {
        return required;
    }

    public void setRequired(String[] value) {
        this.required = value;
    }

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

    public InvoiceProperties getProperties() {
        return properties;
    }

    public void setProperties(InvoiceProperties value) {
        this.properties = value;
    }
}