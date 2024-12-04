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
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

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

        File newFile = new File("filename.pdf", "REVBREJFRUY=", "application/pdf", null);

        testContentUser = ContentUser.builder()
                .ssn("199406100298") // Detta behövs
                .subject("Test letter to test user")
                .type("letter") // Detta behövs
                .files(new ArrayList<>(List.of(newFile))) // Detta behövs
                .build();
    }

    @Test
    void testSendContent() {

        when(contentService.sendContentToUser(anyString(), any(ContentUser.class)))
                .thenReturn(testContentUser); // Mockat svar från contentService

        // Act
        ResponseEntity<ContentUser> response = contentController.sendContentToUser("testTenant", testContentUser);

        // Assert
        assertEquals(201, response.getStatusCodeValue()); // Kontrollera statuskod
        assertEquals(testContentUser, response.getBody()); // Kontrollera responsens kropp
        verify(contentService, times(1)).sendContentToUser(eq("testTenant"), eq(testContentUser)); // Kontrollera att mocken anropades
    }


}

