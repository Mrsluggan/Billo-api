package com.idata.eboks.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Tenant {

    private String name; // Required
    @JsonProperty("company_id")
    private List<CompanyID> companyId; // Required
    private Integer editSecurityLevel; // Read-only, deprecated
    private List<String> groups; // Read-only, deprecated
    private String visibility; // Read-only, deprecated
    private String createdAt; // Read-only
    private String createdBy; // Read-only
    private String status; // Read-only
    @JsonProperty("class")
    private String tenantClass; // Read-only, deprecated

}
