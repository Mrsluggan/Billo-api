package com.idata.eboks.models;

public class Tenant {
    private String type;
    private String[] required;
    private TenantProperties properties;

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String[] getRequired() {
        return required;
    }

    public void setRequired(String[] value) {
        this.required = value;
    }

    public TenantProperties getProperties() {
        return properties;
    }

    public void setProperties(TenantProperties value) {
        this.properties = value;
    }
}