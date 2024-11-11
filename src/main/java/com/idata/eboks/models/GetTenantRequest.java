package com.idata.eboks.models;

public class GetTenantRequest {
    private String type;
    private GetTenantRequestProperties properties;
    private boolean additionalProperties;

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public GetTenantRequestProperties getProperties() {
        return properties;
    }

    public void setProperties(GetTenantRequestProperties value) {
        this.properties = value;
    }

    public boolean getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(boolean value) {
        this.additionalProperties = value;
    }
}