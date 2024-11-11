package com.idata.eboks;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BilloApiRequest {

    private static final String API_URL = "https://api.billo.life/tenant/50746fd6-158b-4583-bb7f-655e5d98a5ed/objects";
    private final RestTemplate restTemplate;

    public BilloApiRequest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void makeApiRequest(String accessToken) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(accessToken);
            HttpEntity<String> requestEntity = new HttpEntity<>(headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    API_URL, HttpMethod.GET, requestEntity, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                System.out.println("API Response: " + response.getBody());
            } else {
                System.out.println("Fel vid API-anrop: " + response.getStatusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
