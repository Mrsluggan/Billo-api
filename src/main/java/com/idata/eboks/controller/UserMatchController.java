package com.idata.eboks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.idata.eboks.Services.UserMatchService;
import com.idata.eboks.models.ContentUser;
import com.idata.eboks.models.EndUser;
import com.idata.eboks.models.Tenant;
import com.idata.eboks.models.TenantKey;
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
    public ResponseEntity<UserMatch> userMatch(@PathVariable String tenantKey) {
        return ResponseEntity.ok(userMatchService.matchUsers(tenantKey));
    }
    
    @PostMapping("/{tenantKey}/content")
    public ResponseEntity<ContentUser> sendcontent(@PathVariable String tenantKey, @RequestBody ContentUser contentUser) {

        System.out.println("--------------  här kommer Meddelandet ------------");
    
        System.out.println(contentUser);
        
        System.out.println("--------------  ------------------ ------------");

        return ResponseEntity.ok(userMatchService.sendContentToUser(tenantKey, contentUser));
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
    public ResponseEntity<List<List<TenantKey>>> listTenants(@RequestParam(required = false) String orgnr) { 
        System.out.println("listed tenant: " + orgnr);
        List<List<TenantKey>> tenants = userMatchService.listTenants(orgnr); 
        return ResponseEntity.ok(tenants);
    }
  
    @GetMapping("{tenantKey}/test")
    public ResponseEntity<ContentUser> test(@PathVariable String tenantKey, @RequestBody ContentUser contentUser) {
        return ResponseEntity.ok(contentUser);
    }

    // Ändrar namn på tenant
    @GetMapping("{tenantKey}/name")
    public ResponseEntity<Tenant> updateTenantName(@PathVariable String tenantKey) {
        return ResponseEntity.ok(userMatchService.updateTenantName(tenantKey, "Bosse"));
    }

}
