package com.idata.eboks.controller;

import com.idata.eboks.models.EndUser;
import com.idata.eboks.models.UserMatch;
import com.idata.eboks.Services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/tenant/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{tenantKey}/usermatch")
    public ResponseEntity<UserMatch> userMatch(@PathVariable String tenantKey, @RequestBody UserMatch userMatch) {
        return ResponseEntity.ok(userService.matchUsers(tenantKey,userMatch));
    }
        // Kollar alla mottagare för tenants
    @GetMapping("/{tenantKey}/users")
    public ResponseEntity<List<EndUser>> findAllUsers(@PathVariable String tenantKey) {
        return ResponseEntity.ok(userService.findUsersFromTenants(tenantKey));
    }
}
