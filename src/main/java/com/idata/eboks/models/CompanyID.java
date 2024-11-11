package com.idata.eboks.models;

public class CompanyID {
    private String type;
    private String[] required;
    private CompanyIDProperties properties;

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

    public CompanyIDProperties getProperties() { 
        return properties; 
    }

    public void setProperties(CompanyIDProperties value) { 
        this.properties = value; 
    }

}