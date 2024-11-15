package com.idata.eboks.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TokenService extends BaseService {
    @Value("${billo.api.client.id}")
    private String clientId;

    @Value("${billo.api.client.secret}")
    private String clientSecret;

    
    @Autowired
    private WebClient.Builder webClientBuilder;

    public String getAccessToken() {
        WebClient webClient = webClientBuilder.build();
        String token = webClient.post()
                .uri("https://sandbox-identity.billo.life/connect/token")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .bodyValue(String.format("grant_type=client_credentials&client_id=%s&client_secret=%s", clientId,
                        clientSecret))
                .retrieve()
                .bodyToMono(String.class)
                .block();


        String[] parts = token.split("\"");
        return parts[3];
    }
}