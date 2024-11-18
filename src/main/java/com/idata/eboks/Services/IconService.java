package com.idata.eboks.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.idata.eboks.models.Icon;

@Service
public class IconService extends BaseService {
    
    @Autowired
    private RestTemplate billoApiRestTemplateBean;
    
    public Icon provideIcon(String tenantKey, Icon icon) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Icon> entity = new HttpEntity<>(icon, headers);
    
            return billoApiRestTemplateBean.exchange(
                createSlug(tenantKey, "/icon"),
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<Icon>() {
                }).getBody();

        } catch (HttpClientErrorException e) {
            System.out.println("Error response: " + e.getResponseBodyAsString());
            throw e;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException("Error processing icon", e);
        }
    }
}