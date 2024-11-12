package com.idata.eboks.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.idata.eboks.models.Tenant;
import com.idata.eboks.models.UserMatch;

@Service
public class UserMatchService {

    private static final String BASE_URL = "https://sandbox-sender-api.billo.life/v1/tenant/";

    @Autowired
    @Qualifier("billoApiRestTemplateBean")
    private RestTemplate billoApiRestTemplateBean;

    public List<UserMatch> matchUsers(String tenantKey) {
        List<UserMatch> chatResponse = billoApiRestTemplateBean.exchange(
                CreateSlug(tenantKey, "/user"),
                HttpMethod.GET, null, new ParameterizedTypeReference<List<UserMatch>>() {
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

        return tenant;
    }

    public String CreateSlug(String tenantKey, String inputPath) {
        return BASE_URL + tenantKey + inputPath;
    }
}