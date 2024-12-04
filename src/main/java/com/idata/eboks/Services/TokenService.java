package com.idata.eboks.Services;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import io.github.cdimascio.dotenv.Dotenv;

@Service
public class TokenService extends BaseService {

    private String clientId;
    private String clientSecret;

    private WebClient.Builder webClientBuilder;

    @Autowired
    public TokenService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
        loadDotenv();
    }

    private void loadDotenv() {
        Dotenv dotenv = Dotenv.load();
        this.clientId = dotenv.get("CLIENT_ID");
        this.clientSecret = dotenv.get("CLIENT_SECRET");
        System.out.println("clientId: " + clientId + " clientSecret: " + clientSecret);
    }

    public String getAccessToken() {
        try {
            WebClient webClient = webClientBuilder.build();
            String encodedClientId = URLEncoder.encode(clientId, StandardCharsets.UTF_8);
            String encodedClientSecret = URLEncoder.encode(clientSecret, StandardCharsets.UTF_8);
            String token = webClient.post()
                    .uri("https://sandbox-identity.billo.life/connect/token")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .bodyValue(String.format("grant_type=client_credentials&client_id=%s&client_secret=%s", encodedClientId,
                    encodedClientSecret))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
                    System.out.println("token: " + token);

            String[] parts = token.split("\"");
            return parts[3];
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException("Error getting access token ", e);
        }
    }
}