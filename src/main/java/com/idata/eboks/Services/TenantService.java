package com.idata.eboks.Services;

import com.idata.eboks.models.Tenant;
import com.idata.eboks.models.TenantKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TenantService extends BaseService {

    @Autowired
    private RestTemplate billoApiRestTemplateBean;

    public Tenant createTenant(Tenant tenant) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Tenant> request = new HttpEntity<>(tenant, headers);

            ResponseEntity<Tenant> response = billoApiRestTemplateBean.postForEntity(
                    getUrl(),
                    request,
                    Tenant.class);

            return response.getBody();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException("Error creating a new tenant", e);
        }

    }

    public List<List<TenantKey>> listTenants(String orgnr) {
        try {
            String requestUrl = getUrl();
            if (orgnr != null && !orgnr.isEmpty()) {
                requestUrl += "?orgnr=" + orgnr;
            }
            ResponseEntity<List<List<TenantKey>>> response = billoApiRestTemplateBean.exchange(
                    requestUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<List<TenantKey>>>() {
                    });

            return response.getBody();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException("Error processing list of tenants", e);
        }
    }

    public Tenant updateTenantName(String tenantKey, String newName) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(newName, headers);
            return billoApiRestTemplateBean.exchange(
                    createSlug(tenantKey, "/name"),
                    HttpMethod.PUT,
                    entity,
                    new ParameterizedTypeReference<Tenant>() {
                    }).getBody();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException("Error processing tenant update", e);
        }
    }

    public Tenant getTenant(String tenantKey) {
        try {

            return billoApiRestTemplateBean.exchange(
                    createSlug(tenantKey, ""),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Tenant>() {
                    }).getBody();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException("Error processing tenant update", e);
        }
    }
}
