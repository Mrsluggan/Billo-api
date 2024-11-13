package com.idata.eboks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.idata.eboks.Services.UserMatchService;
import com.idata.eboks.models.ContentUser;
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
    public ResponseEntity<ContentUser> sendcontent(@PathVariable String tenantKey,
            @RequestBody ContentUser contentUser) {
        System.out.println("nu hände det något");

        return ResponseEntity.ok(userMatchService.sendContentToUser(tenantKey, contentUser));
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
