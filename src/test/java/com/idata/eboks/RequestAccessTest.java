package com.idata.eboks;

import com.idata.eboks.Services.RequestAccessService;
import com.idata.eboks.controller.RequestAccessController;
import com.idata.eboks.models.RequestAccess;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Map;

@SpringBootTest(classes = BilloApplication.class)
public class RequestAccessTest {

    @Mock
    private RequestAccessService requestAccessService;

    @InjectMocks
    private RequestAccessController requestAccessController;

    @BeforeEach
    void setUp() {
        RequestAccess mockRequestAccess = new RequestAccess();
        mockRequestAccess.setVatNumber("123456789");
        when(requestAccessService.requestAccess("123456789")).thenReturn(mockRequestAccess);
    }

    @Test
    void testPostRequestAccess() {
        String vatNumber = "123456789";
        RequestAccess result = requestAccessController.postRequestAccess("123", Map.of("vatNumber", vatNumber));
        assertEquals(vatNumber, result.getVatNumber());
    }

    @Test
    void testGetRequestAccess() {
        String vatNumber = "123456789";
        String tenantKey = "testTenantKey";
        RequestAccess mockRequestAccess = new RequestAccess();
        mockRequestAccess.setVatNumber(vatNumber);
        mockRequestAccess.setStatus("PENDING");
        mockRequestAccess.setTenant_name("TestTenant");
        when(requestAccessService.requestAccess(vatNumber)).thenReturn(mockRequestAccess);
        RequestAccess result = requestAccessController.getRequestAccess(tenantKey, vatNumber);
        assertEquals(vatNumber, result.getVatNumber());
        assertEquals("PENDING", result.getStatus());
        assertEquals("TestTenant", result.getTenant_name());
    }
}

// (\(\
// (-.-)
// o_(")(")