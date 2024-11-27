package com.idata.eboks.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import com.idata.eboks.Services.CompanyService;
import com.idata.eboks.models.CompanyID;

@RestController
@RequestMapping("/v1/tenant")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/{tenantKey}/company_id")
    public ResponseEntity<CompanyID> associateCompanyId(@PathVariable String tenantKey,@RequestBody CompanyID companyID) {
        try {
            return ResponseEntity.ok(companyService.associateCompanyId(tenantKey, companyID));

        } catch (HttpClientErrorException e) {
            System.out.println("Error during REST call: {}" + e.getResponseBodyAsString());
            return null;// Log the error response
        }
    }

    @DeleteMapping("/{tenantKey}/company_id/{orgnr}")
    public ResponseEntity<Void> deleteCompanyByOrgnr(@PathVariable String tenantKey, @PathVariable String orgnr) {

        return ResponseEntity.ok().build();

    }

}
