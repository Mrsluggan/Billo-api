package com.idata.eboks.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tenant {

    private String name; // Required
    @JsonProperty("company_id")
    private List<CompanyID> company_id; // Required
    private Integer edit_security_level; // Read-only, deprecated
    private List<String> groups; // Read-only, deprecated
    private String visibility; // Read-only, deprecated
    private String created_at; // Read-only
    private String created_by; // Read-only
    private String status; // Read-only
    @JsonProperty("class")
    private String tenantClass; // Read-only, deprecated

}
