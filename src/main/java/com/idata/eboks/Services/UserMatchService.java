package com.idata.eboks.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.idata.eboks.models.Tenant;
import com.idata.eboks.models.UserMatch;

@Service
public class UserMatchService {

    private String BASE_URL = "https://sandbox-sender-api.billo.life/v1/tenant/";
    private String url = "https://sandbox-sender-api.billo.life/v1/tenant";

    @Autowired
    @Qualifier("billoApiRestTemplateBean")
    private RestTemplate billoApiRestTemplateBean;

    public String CreateSlug(String tenantKey, String inputPath) {
        return BASE_URL + tenantKey + inputPath;
    }

    public List<UserMatch> matchUsers(String tenantKey) {
        List<UserMatch> chatResponse = billoApiRestTemplateBean.exchange(
                CreateSlug(tenantKey, "/user"),
                HttpMethod.GET, 
                null, 
                new ParameterizedTypeReference<List<UserMatch>>() {
                }).getBody();

        System.out.println(chatResponse);
        return chatResponse;
    }

    public Tenant updateTenantName(String tenantKey, String newName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the JSON body containing the new name
        String requestBody = String.format("{\"name\": \"%s\"}", newName);
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        Tenant tenant = billoApiRestTemplateBean.exchange(
                CreateSlug(tenantKey, "/name"),
                HttpMethod.PUT,
                entity,
                new ParameterizedTypeReference<Tenant>() {
                }).getBody();

        System.out.println(tenant);
        return tenant;
    }

    //Skapar en ny tenant. 
    public Tenant createTenant (Tenant tenant) {
        // Ställ in headers för begäran
        HttpHeaders headers = new HttpHeaders(); 
        headers.set("Content-Type", "application/json");
         
        // Skapa en HttpEntity med tenant-objektet och headers 
        HttpEntity<Tenant> request = new HttpEntity<>(tenant, headers);
        
        // Skicka POST-begäran för att skapa en ny tenant
        ResponseEntity<Tenant> response = billoApiRestTemplateBean.postForEntity(
            url,
            request,
            Tenant.class);

        System.out.println("POST to create new tenant: " + response.getBody());
        return response.getBody();
    }

    //Listar alla tenants.
    public List<Tenant> listTenants(String orgnr) {
        if (orgnr != null && !orgnr.isEmpty()) {
            url += "?orgnr=" + orgnr;
        }
        List<Tenant> tenants = billoApiRestTemplateBean.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Tenant>>() {
                }).getBody();
 
        System.out.println(tenants);
        return tenants;
    }
}