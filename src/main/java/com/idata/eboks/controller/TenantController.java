package com.idata.eboks.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idata.eboks.models.CompanyID;

@RestController
@RequestMapping("/v1/tenant")
public class TenantController {

    private static final Map<String, CompanyID> tenantCompanyMap = new HashMap<>();

    
    @PostMapping("/{tenantKey}/company_id")
    public ResponseEntity<Void> assocateCompanyId(@PathVariable String tenantKey, @RequestBody CompanyID companyID) {
        
        tenantCompanyMap.put(tenantKey, companyID);

      
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{tenantKey}/company_id")
    public ResponseEntity<CompanyID> getCompanyId(@PathVariable String tenantKey) {
        CompanyID companyID = tenantCompanyMap.get(tenantKey);

        if (companyID != null) {
            return ResponseEntity.ok(companyID);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
