package com.idata.eboks.controller;

import com.idata.eboks.models.UserMatch;
import com.idata.eboks.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/tenant/{tenantKey}/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<UserMatch> userMatch(@PathVariable String tenantKey) {
        return ResponseEntity.ok(userService.matchUsers(tenantKey));
    }
}
