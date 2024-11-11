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


    @PostMapping("/{tenantKey}/content")
    public ResponseEntity<UserMatch> sendcontent(@PathVariable String tenantKey) {

        // todo, lägg till content_user, sedan skapa funktion för skapa content

        return ResponseEntity.ok(null);
    }


    @GetMapping("/test")
    public ResponseEntity<Tenant> testMap() {
        return ResponseEntity.ok(userMatchService.updateTenantName("Bosse"));
    }

}
