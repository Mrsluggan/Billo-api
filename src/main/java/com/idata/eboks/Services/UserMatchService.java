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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.idata.eboks.models.ContentUser;
import com.idata.eboks.models.Tenant;
import com.idata.eboks.models.TenantKey;
import com.idata.eboks.models.UserMatch;

@Service
public class UserMatchService {

    private String BASE_URL = "https://sandbox-sender-api.billo.life/v1/tenant/";
    private String url = "https://sandbox-sender-api.billo.life/v1/tenant";

    @Autowired
    @Qualifier("billoApiRestTemplateBean")
    private RestTemplate billoApiRestTemplateBean;

    public String createSlug(String tenantKey, String inputPath) {
        return BASE_URL + tenantKey + inputPath;
    }

    public List<UserMatch> matchUsers(String tenantKey) {
        List<UserMatch> chatResponse = billoApiRestTemplateBean.exchange(
                createSlug(tenantKey, "/user"),
                HttpMethod.GET, 
                null, 
                new ParameterizedTypeReference<List<UserMatch>>() {
                }).getBody();

        System.out.println(chatResponse);
        return chatResponse;
    }

    public ContentUser sendContentToUser(String tenantKey, ContentUser contentUser) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<ContentUser> entity = new HttpEntity<>(contentUser, headers);
            System.out.println("\n");
            System.out.println(entity);
            System.out.println("\n");
            ContentUser newMessage = billoApiRestTemplateBean.exchange(
                    createSlug(tenantKey, "/content"),
                    HttpMethod.POST,
                    entity,
                    new ParameterizedTypeReference<ContentUser>() {
                    }).getBody();

            return newMessage;

        } catch (HttpClientErrorException e) {
            System.out.println("Error response: " + e.getResponseBodyAsString());
            throw e; // rethrow the exception to propagate it further
        } catch (Exception e) {
            // Handle any other exceptions
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException("Error processing contentUser", e);
        }
    }

    public Tenant updateTenantName(String tenantKey, String newName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the JSON body containing the new name
        String requestBody = String.format("{\"name\": \"%s\"}", newName);
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        Tenant tenant = billoApiRestTemplateBean.exchange(
                createSlug(tenantKey, "/name"),
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
    public List<List<TenantKey>> listTenants(String orgnr) {
        if (orgnr != null && !orgnr.isEmpty()) {
            url += "?orgnr=" + orgnr;
        }
        ResponseEntity<List<List<TenantKey>>> response = billoApiRestTemplateBean.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<List<TenantKey>>>() {}
        );
                
        List<List<TenantKey>> tenants = response.getBody();
 
        System.out.println(tenants);
        return tenants;
    }
}