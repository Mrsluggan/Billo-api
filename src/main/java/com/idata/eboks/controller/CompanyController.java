package com.idata.eboks.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.idata.eboks.models.CompanyID;

@RestController
@RequestMapping("/v1/tenant")
public class TenantController {

    private static final Map<String, List<CompanyID>> tenantCompanyMap = new HashMap<>();

    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_URL = "https://sandbox-sender-api.billo.life/v1/tenant/";

    @PostMapping("/{tenantKey}/company_id")
    public ResponseEntity<Void> associateCompanyId(@PathVariable String tenantKey, @RequestBody CompanyID companyID) {

        if (tenantCompanyMap.values().stream()
                .flatMap(List::stream)
                .anyMatch(existing -> existing.getOrgnr().equals(companyID.getOrgnr()))) {
            return ResponseEntity.status(409).build();
        }

        tenantCompanyMap.computeIfAbsent(tenantKey, k -> new ArrayList<>()).add(companyID);

        try {
            restTemplate.postForEntity(BASE_URL, new HttpEntity<>(companyID), Void.class);
        } catch (Exception e) {
            System.out.println("Error calling Billogram API: " + e.getMessage());
        }

        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{tenantKey}/company_id/{orgnr}")
    public ResponseEntity<Void> deleteCompanyByOrgnr(@PathVariable String tenantKey, @PathVariable String orgnr) {

        List<CompanyID> companyList = tenantCompanyMap.get(tenantKey);

        if (companyList != null && companyList.removeIf(company -> company.getOrgnr().equals(orgnr))) {

            try {
                restTemplate.exchange(BASE_URL + "/" + orgnr, HttpMethod.DELETE,
                        new HttpEntity<>(new HttpHeaders()), Void.class);
            } catch (Exception e) {
                System.out.println("Error calling Billogram API: " + e.getMessage());
            }
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/company_id/all")
    public ResponseEntity<List<CompanyID>> getAllCompanyIds() {
        List<CompanyID> allCompanyIds = tenantCompanyMap.values().stream()
                .flatMap(List::stream)
                .toList();
        return ResponseEntity.ok(allCompanyIds);
    }
}
