package com.idata.eboks.models;

import java.util.List;

public class UserMatch {
    private List<String> ssns;
    private String[] required;
    private String type;
    private UserMatchProperties properties;
    private UserMatchExample example;

    public List<String> getSsns() {
        return ssns;
    }

    public void setSsns(List<String> ssns) {
        this.ssns = ssns;
    }
    
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

    public UserMatchProperties getProperties() {
        return properties;
    }

    public void setProperties(UserMatchProperties value) {
        this.properties = value;
    }

    public UserMatchExample getExample() {
        return example;
    }

    public void setExample(UserMatchExample value) {
        this.example = value;
    }
}

