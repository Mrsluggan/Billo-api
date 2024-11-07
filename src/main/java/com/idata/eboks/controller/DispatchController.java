package com.idata.eboks.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.idata.eboks.Services.DispatchService;
import com.idata.eboks.models.Dispatch;
import com.idata.eboks.models.DispatchResponse;

@RestController
@RequestMapping("/api/dispatch")
public class DispatchController {

    @Autowired
    private DispatchService dispatchService;

    @PostMapping("/create")
    public DispatchResponse createDispatch(@RequestBody Dispatch dispatch) {
        return dispatchService.createSingleDispatch(dispatch);
    }

    @GetMapping("/{messageId}/status")
    public Dispatch getDispatchStatus(@PathVariable String messageId) {
        return dispatchService.getDispatchStatus(messageId);
    }

    @DeleteMapping("/{messageId}/recall")
    public void recallDispatch(@PathVariable String messageId) {
        dispatchService.recallDispatch(messageId);
    }
}