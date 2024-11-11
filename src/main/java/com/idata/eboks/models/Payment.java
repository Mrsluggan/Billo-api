package com.idata.eboks.models;

public class Payment {
    private String[] required;
    private String type;
    private PaymentProperties properties;
    private boolean additionalProperties;

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

    public PaymentProperties getProperties() {
        return properties;
    }

    public void setProperties(PaymentProperties value) {
        this.properties = value;
    }

    public boolean getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(boolean value) {
        this.additionalProperties = value;
    }
}