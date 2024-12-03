package com.idata.eboks.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
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

    @GetMapping("/check")
    public ResponseEntity<String> checkSomething(@RequestParam String code) {
        if ("julglädje".equals(code)) {
            return ResponseEntity.ok("🎄 Ho Ho Ho!Glad jul önskar praktikant teamet");
        }
        return ResponseEntity.ok("Detta är inget speciellt.");
    }

}
