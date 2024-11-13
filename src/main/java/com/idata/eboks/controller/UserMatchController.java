package com.idata.eboks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.idata.eboks.Services.UserMatchService;
import com.idata.eboks.models.Tenant;
import com.idata.eboks.models.UserMatch;

@RestController
@RequestMapping("/v1/tenant")
public class UserMatchController {

    @Value("${billo.api.client.id}")
    private String clientId;

    @Value("${billo.api.client.secret}")
    private String clientSecret;

    @Value("${billo.api.client.tenantKey}")
    private String tenantKey;

    @Autowired
    private UserMatchService userMatchService;
    
    // Kollar om mottagare finns för tenants
    @GetMapping("/{tenantKey}/users")
    public ResponseEntity<List<UserMatch>> userMatch(@PathVariable String tenantKey) {
        return ResponseEntity.ok(userMatchService.matchUsers(tenantKey));
    }
    
    @PostMapping("/{tenantKey}/content")
    public ResponseEntity<UserMatch> sendcontent(@PathVariable String tenantKey) {
        // todo, lägg till content_user, sedan skapa funktion för skapa content
        return ResponseEntity.ok(null);
    }
    
    // Skapar en ny tenant 
    @PostMapping 
    public ResponseEntity<Tenant> createTenant(@RequestBody Tenant tenant) { 
        System.out.println("Received tenant: " + tenant);
        Tenant createdTenant = userMatchService.createTenant(tenant); 
        return ResponseEntity.status(createdTenant != null ? 201 : 200).body(createdTenant); 
    }

    // Listar alla tenants 
    @GetMapping 
    public ResponseEntity<List<Tenant>> listTenants(@RequestParam(required = false) String orgnr) { 
        List<Tenant> tenants = userMatchService.listTenants(orgnr); 
        return ResponseEntity.ok(tenants); 
    }

    //Ändrar namn på tenant
    @GetMapping("{tenantKey}/name")
    public ResponseEntity<Tenant> updateTenantName(@PathVariable String tenantKey) {
        return ResponseEntity.ok(userMatchService.updateTenantName(tenantKey, "Bosse"));
    }

}
