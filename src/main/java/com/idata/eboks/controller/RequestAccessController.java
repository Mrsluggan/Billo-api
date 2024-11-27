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

    @GetMapping("/request-access")
    public RequestAccess getRequestAccess(@RequestParam String requestKey) {
        System.out.println("nu kom det en get");
        System.out.println(requestKey);
        return requestAccessService.checkRequestStatus(requestKey);
    }

    @PostMapping("/request-access")
    public RequestAccess postRequestAccess(@RequestBody Map<String, String> requestBody) {
        String vatNumber = requestBody.get("vat_number");
        System.out.println("nu kom det en post");
        System.out.println(vatNumber);
        return requestAccessService.requestAccess(vatNumber);
    }
}
