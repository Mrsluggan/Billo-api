package com.idata.eboks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idata.eboks.Services.ContentService;
import com.idata.eboks.models.ContentUser;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/v1/tenant")
public class ContentController {

    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    // Skickar in en ny innehållsförändring till Billo
    @PostMapping("/{tenantKey}/content")
    public ResponseEntity<ContentUser> sendcontentToUser(@PathVariable String tenantKey, @RequestBody ContentUser contentUser) {

        System.out.println("--------------  här kommer Meddelandet ------------");
    
        System.out.println(contentUser);
        
        System.out.println("--------------  ------------------ ------------");

        return ResponseEntity.ok(contentService.sendContentToUser(tenantKey, contentUser));
    }
    
}
