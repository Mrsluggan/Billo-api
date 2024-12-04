package com.idata.eboks.Services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import com.idata.eboks.models.Tenant;
import com.idata.eboks.models.TenantKey;

@ExtendWith(MockitoExtension.class)
public class TenantServiceTest {

    @Mock
    private RestTemplate billoApiRestTemplateBean;

    @InjectMocks
    private TenantService tenantService;

    private Tenant tenant; 
    private String tenantKey; 
    private String newName;

    @BeforeEach 
    public void setup() { 
        tenant = new Tenant(); 
        tenant.setName("Test Tenant"); 
        tenantKey = "testKey"; 
        newName = "New Tenant Name"; 
    }

    @Test
    public void createTenant_withValidTenant_shouldReturnCreatedTenant() {

        ResponseEntity<Tenant> responseEntity = new ResponseEntity<>(tenant, HttpStatus.CREATED);
        when(billoApiRestTemplateBean.postForEntity(
            anyString(), 
            any(HttpEntity.class), 
            eq(Tenant.class))
        ).thenReturn(responseEntity);
        
        // Call service method 
        Tenant createdTenant = tenantService.createTenant(tenant); 

        // Verify 
        assertEquals(tenant, createdTenant); 
        verify(billoApiRestTemplateBean, 
        times(1)).postForEntity(
            anyString(), 
            any(HttpEntity.class), 
            eq(Tenant.class)
        );
    }

    @Test 
    public void listTenants_withValidOrgNr_shouldReturnListOfTenants() { 

        // Setup mock response 
        List<List<TenantKey>> tenants = Collections.singletonList(Collections.singletonList(new TenantKey())); 
        ResponseEntity<List<List<TenantKey>>> responseEntity = new ResponseEntity<>(tenants, HttpStatus.OK); 
        when(billoApiRestTemplateBean.exchange(
            anyString(), 
            eq(HttpMethod.GET), 
            any(), 
            eq(new ParameterizedTypeReference<List<List<TenantKey>>>() {}))
        ).thenReturn(responseEntity); 

        // Call service method 
        List<List<TenantKey>> returnedTenants = tenantService.listTenants("123456789"); 

        // Verify 
        assertEquals(tenants, returnedTenants); 
        verify(billoApiRestTemplateBean, 
        times(1)).exchange(
            anyString(), 
            eq(HttpMethod.GET), 
            any(), 
            eq(new ParameterizedTypeReference<List<List<TenantKey>>>() {})
        ); 
    } 
        
    @Test 
    public void updateTenantName_withValidTenantKeyAndName_shouldReturnUpdatedTenant() { 

        // Setup mock response 
        ResponseEntity<Tenant> responseEntity = new ResponseEntity<>(tenant, HttpStatus.OK); 
        when(billoApiRestTemplateBean.exchange(
            eq("https://sandbox-sender-api.billo.life/v1/tenant/testKey/name"), 
            eq(HttpMethod.PUT), 
            any(HttpEntity.class), 
            eq(new ParameterizedTypeReference<Tenant>() {}))
        ).thenReturn(responseEntity); 
            
        // Call service method 
        Tenant updatedTenant = tenantService.updateTenantName(tenantKey, newName); 
        
        // Verify 
        assertEquals(tenant, updatedTenant); 
        verify(billoApiRestTemplateBean, 
        times(1)) 
        .exchange(eq("https://sandbox-sender-api.billo.life/v1/tenant/testKey/name"), 
        eq(HttpMethod.PUT), 
        any(HttpEntity.class), 
        eq(new ParameterizedTypeReference<Tenant>(){})
        );
    }

}