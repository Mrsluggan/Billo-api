package com.idata.eboks.controller;

import com.idata.eboks.models.Tenant;
import com.idata.eboks.models.TenantKey;
import com.idata.eboks.Services.TenantService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/tenant")
public class TenantController {

    @Autowired
    private final TenantService tenantService;

    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    // Skapar en ny tenant 
    @PostMapping 
    public ResponseEntity<Tenant> createTenant(@RequestBody Tenant tenant) { 
        System.out.println("Received tenant: " + tenant);
        Tenant createdTenant = tenantService.createTenant(tenant); 
        return ResponseEntity.status(createdTenant != null ? 201 : 200).body(createdTenant); 
    }

    // Listar alla tenants 
    @GetMapping 
    public ResponseEntity<List<List<TenantKey>>> listTenants(@RequestParam(required = false) String orgnr) { 
        System.out.println("listed tenant: " + orgnr);
        List<List<TenantKey>> tenants = tenantService.listTenants(orgnr); 
        return ResponseEntity.ok(tenants);
    }

    // Ändrar namn på tenant
    @GetMapping("{tenantKey}/name")
    public ResponseEntity<Tenant> updateTenantName(@PathVariable String tenantKey) {
        return ResponseEntity.ok(tenantService.updateTenantName(tenantKey, "Bosse"));
    }
}
