package com.idata.eboks.models;

import java.util.List;

import lombok.Data;

@Data
public class Tenant {

    private String name; // Required
    private List<CompanyID> companyId; // Required
    private Integer editSecurityLevel; // Read-only, deprecated
    private List<String> groups; // Read-only, deprecated
    private String visibility; // Read-only, deprecated
    private String createdAt; // Read-only
    private String createdBy; // Read-only
    private String status; // Read-only
    private String tenantClass; // Read-only, deprecated

}
