package com.idata.eboks.controllers;


import com.idata.eboks.BilloApplication;
import com.idata.eboks.Services.ContentService;
import com.idata.eboks.controller.ContentController;
import com.idata.eboks.models.ContentUser;
import com.idata.eboks.models.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.wiremock.spring.EnableWireMock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = BilloApplication.class)
public class ContentUserTest {

    @Mock
    private ContentService contentService;

    @InjectMocks
    private ContentController contentController;

    private ContentUser testContentUser;

    @Value("${billo.api.url}")
    private String wireMockUrl;

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
                .thenReturn(testContentUser);


        ResponseEntity<ContentUser> response = contentController.sendContentToUser("testTenant", testContentUser);


        assertEquals(400, response.getStatusCode().value());
        assertEquals(testContentUser, response.getBody()); // Kontrollera responsens kropp
        verify(contentService, times(1)).sendContentToUser(eq("testTenant"), eq(testContentUser));
    }

    @Test
    void testSendContent_ExceptionThrown() {
        when(contentService.sendContentToUser(anyString(), any(ContentUser.class)))
                .thenThrow(new RuntimeException("Unexpected error"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            contentController.sendContentToUser("testTenant", testContentUser);
        });

        assertEquals("Error processing request", exception.getMessage());
        verify(contentService, times(1)).sendContentToUser(eq("testTenant"), eq(testContentUser));
    }
    @Test
    void testSendContent_InvalidInput() {
        ContentUser invalidUser = ContentUser.builder()
                .ssn(null) // Saknar SSN
                .subject(null) // Saknar subject
                .build();

        ResponseEntity<ContentUser> response = contentController.sendContentToUser("testTenant", invalidUser);

        assertEquals(400, response.getStatusCode().value());
        verify(contentService, times(0)).sendContentToUser(anyString(), any(ContentUser.class));
    }
    @Test
    void testSendContent_EmptyFiles() {
        ContentUser userWithEmptyFiles = ContentUser.builder()
                .ssn("199406100298")
                .subject("Test letter to test user")
                .type("letter")
                .files(new ArrayList<>()) // Tom lista, som är no no
                .build();

        ResponseEntity<ContentUser> response = contentController.sendContentToUser("testTenant", userWithEmptyFiles);

        assertEquals(400, response.getStatusCode().value());
        verify(contentService, times(0)).sendContentToUser(anyString(), any(ContentUser.class));
    }
}

