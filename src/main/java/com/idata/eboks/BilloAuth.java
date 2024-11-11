package com.idata.eboks;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Component;

@Component
public class BilloAuth {
    @Value("${CLIENT_ID}")
    private String clientId;

    @Value("${billo.client-secret}")
    private String clientSecret;
    private static final String TOKEN_URL = "https://sandbox-identity.billo.life/connect/token";

    // private static final String CLIENT_ID =
    // private static final String CLIENT_SECRET =

    private final RestTemplate restTemplate;

    public BilloAuth(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getAccessToken() {
        try {
            if (clientId == null || clientSecret == null) {
                System.out.println("Client ID eller Client Secret är inte satt i miljövariabler.");
                return null;
            }

            String postData = "grant_type=client_credentials" +
                    "&client_id=" + clientId +
                    "&client_secret=" + clientSecret;

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED);

            HttpEntity<String> requestEntity = new HttpEntity<>(postData, headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    TOKEN_URL, HttpMethod.POST, requestEntity, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                return extractAccessToken(response.getBody());
            } else {
                System.out.println("Fel vid autentisering: " + response.getStatusCode());
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String extractAccessToken(String responseBody) {
        String token = null;
        try {
            int start = responseBody.indexOf("\"access_token\":\"") + "\"access_token\":\"".length();
            int end = responseBody.indexOf("\"", start);
            token = responseBody.substring(start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    public static void main(String[] args) {
        BilloAuth auth = new BilloAuth(new RestTemplate());
        String accessToken = auth.getAccessToken();
        if (accessToken != null) {
            System.out.println("Access token: " + accessToken);
            BilloApiRequest apiRequest = new BilloApiRequest(new RestTemplate());
            apiRequest.makeApiRequest(accessToken);
        }
    }
}
