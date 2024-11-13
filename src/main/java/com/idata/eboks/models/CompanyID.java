package com.idata.eboks.models;

import lombok.Data;

@Data
public class CompanyID {
    private String name; // Required
    private String orgnr; // Required

    // Getters and setters
    public String getOrgnr() {
        return orgnr;
    }

    public void setOrgnr(String orgnr) {
        this.orgnr = orgnr;
    }

    public String getCompanyName() {
        return name;
    }

    public void setCompanyName(String companyName) {
        this.name = companyName;
    }

}
