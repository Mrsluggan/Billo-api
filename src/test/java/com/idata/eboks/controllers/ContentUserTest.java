package com.idata.eboks.controllers;


import com.idata.eboks.BilloApplication;
import com.idata.eboks.Services.ContentService;
import com.idata.eboks.Services.RequestAccessService;
import com.idata.eboks.controller.ContentController;
import com.idata.eboks.controller.RequestAccessController;
import com.idata.eboks.models.ContentUser;
import com.idata.eboks.models.File;
import com.idata.eboks.models.RequestAccess;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = BilloApplication.class)
public class ContentUserTest {

    @Mock
    private ContentService contentService;

    @InjectMocks
    private ContentController contentController;

    private ContentUser testContentUser;

    @BeforeEach
    public void setup() {

        // Create the File object to be used in ContentUser
        File newFile = new File("filename.pdf", "REVBREJFRUY=", "application/pdf", null);

        // Build the ContentUser object and assign it to the content field
        testContentUser = ContentUser.builder()
                .ssn("199406100298")
                .subject("Test letter to test user")
                .type("letter")
                .files(new ArrayList<>(List.of(newFile))) // Add newFile to the list directly
                .build();
    }

    @Test
    void testSendContent() {

        contentController.sendContentToUser("test",testContentUser);

    }


}

