package com.idata.eboks.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.*;
import com.idata.eboks.Services.RequestAccessService;
import com.idata.eboks.models.RequestAccess;

@RestController
@RequestMapping("/v1/tenant")
public class RequestAccessController {

    private final RequestAccessService requestAccessService;

    public RequestAccessController(RequestAccessService requestAccessService) {
        this.requestAccessService = requestAccessService;
    }

    @GetMapping("/{tenantKey}/request-access")
    public RequestAccess getRequestAccess(@PathVariable String tenantKey, @RequestParam String vatNumber) {
        return requestAccessService.requestAccess(vatNumber);
    }

    @PostMapping("/{tenantKey}/request-access")
    public RequestAccess postRequestAccess(@PathVariable String tenantKey,
            @RequestBody Map<String, String> requestBody) {
        String vatNumber = requestBody.get("vatNumber");
        return requestAccessService.requestAccess(vatNumber);
    }
}
