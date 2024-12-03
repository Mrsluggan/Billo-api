package com.idata.eboks.models;
//

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestAccess {
    private String requestKey; // Read-only
    private String createdAt; // Read-only
    private String createdBy; // Read-only
    private String status; // Read-only
    private String clientId;
    private String clientName; // Read-only
    private String tenantName; // Read-only
    private TenantKey tenantKey; // Read-only
    private String vatNumber;

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getVatNumber() {
        return vatNumber;
    }
}
