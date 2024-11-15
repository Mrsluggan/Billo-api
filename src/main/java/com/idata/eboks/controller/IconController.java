package com.idata.eboks.controller;

import com.idata.eboks.models.Icon;
import com.idata.eboks.Services.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/tenant/{tenantKey}/icon")
public class IconController {

    private final IconService iconService;

    @Autowired
    public IconController(IconService iconService) {
        this.iconService = iconService;
    }

    @PostMapping
    public ResponseEntity<Icon> provideIcon(@PathVariable String tenantKey, @RequestBody Icon icon) {
        return ResponseEntity.ok(iconService.provideIcon(tenantKey, icon));
    }
}
