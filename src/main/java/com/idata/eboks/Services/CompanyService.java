package com.idata.eboks.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.idata.eboks.models.CompanyID;

@Service
public class CompanyService extends BaseService {

    @Autowired
    private RestTemplate billoApiRestTemplateBean;

    public CompanyID associateCompanyId(String tenantKey, CompanyID companyID) {
        System.out.println("Starting associateCompanyId operation");
        System.out.println("Tenant Key: " + tenantKey);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<CompanyID> entity = new HttpEntity<>(companyID, headers);
            String url = createSlug(tenantKey, "/company_id");
            System.out.println("Request URL: " + url);
            ResponseEntity<CompanyID> response = billoApiRestTemplateBean.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    new ParameterizedTypeReference<CompanyID>() {
                    });

            System.out.println("Response received: " + response.getBody());
            return response.getBody();
        } catch (HttpClientErrorException e) {
            // Log specific HTTP errors
            System.err.println("HTTP Error: " + e.getStatusCode());
            System.err.println("Response Body: " + e.getResponseBodyAsString());
            throw new RuntimeException("HTTP Error during associateCompanyId operation: " + e.getStatusCode(), e);
        } catch (Exception e) {
            // Log generic exceptions
            System.err.println("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Unexpected error during associateCompanyId operation", e);
        }
    }

}
