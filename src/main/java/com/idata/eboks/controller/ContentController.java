package com.idata.eboks.controller;

import com.idata.eboks.Services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idata.eboks.Services.ContentService;
import com.idata.eboks.models.ContentUser;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/v1/tenant")
public class ContentController extends BaseService {

    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping("/{tenantKey}/content")
    public ResponseEntity<ContentUser> sendContentToUser(@PathVariable String tenantKey, @RequestBody ContentUser contentUser) {

        logger.info("Received request to send content for tenantKey: {}", tenantKey);

        try {
            ContentUser response = contentService.sendContentToUser(tenantKey, contentUser);
            logger.info("Content successfully sent for tenantKey: {}", tenantKey);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error processing request for tenantKey: {}", tenantKey, e);
            return ResponseEntity.status(500).build();
        }

    }
    
}
