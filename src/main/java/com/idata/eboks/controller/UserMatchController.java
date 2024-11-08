package com.idata.eboks.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.idata.eboks.Services.UserMatchService;
import com.idata.eboks.models.UserMatch;

@RestController
@RequestMapping("/v1/tenant")
public class UserMatchController {

    @Value("${billo.api.client.tenantKey}")
    private String tenantKey;

    @Autowired
    private UserMatchService userMatchService;


    // Kollar om mottagare finns för tenants
    @PostMapping("/{tenantKey}/usermatch")
    public ResponseEntity<UserMatch> matchUsers(@PathVariable String tenantKey, @RequestBody UserMatch userMatchRequest) {
        UserMatch response = userMatchService.matchUsers(userMatchRequest);
        return ResponseEntity.ok(response);
    }
}
