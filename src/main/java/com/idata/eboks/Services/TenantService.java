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
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Tenant> request = new HttpEntity<>(tenant, headers);

        ResponseEntity<Tenant> response = billoApiRestTemplateBean.postForEntity(
                getUrl(),
                request,
                Tenant.class);

        return response.getBody();
    }

    public List<List<TenantKey>> listTenants(String orgnr) {
        String requestUrl = getUrl();
        if (orgnr != null && !orgnr.isEmpty()) {
            requestUrl += "?orgnr=" + orgnr;
        }
        ResponseEntity<List<List<TenantKey>>> response = billoApiRestTemplateBean.exchange(
                requestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<List<TenantKey>>>() {}
        );

        return response.getBody();
    }

    public Tenant updateTenantName(String tenantKey, String newName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(newName, headers);

        return billoApiRestTemplateBean.exchange(
                createSlug(tenantKey, "/name"),
                HttpMethod.PUT,
                entity,
                new ParameterizedTypeReference<Tenant>() {
                }).getBody();
    }
}
