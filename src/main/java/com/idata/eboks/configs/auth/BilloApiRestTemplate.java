package com.idata.eboks.configs.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class BilloApiRestTemplate {

    @Autowired
    private TokenService billoAuth;

    @Bean(name = "billoApiRestTemplateBean")
    @Qualifier("billoApiRestTemplateBean")
    public RestTemplate billoApiRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
    
        restTemplate.getInterceptors().add((request, body, execution) -> {
            String apiKey = billoAuth.getAccessToken();
            if (apiKey != null) {
                System.out.println(apiKey);
                request.getHeaders().add("Authorization", "Bearer " + apiKey);
            } else {
                System.out.println("API key is null, unable to add authorization header");
            }
            return execution.execute(request, body);
        });
        return restTemplate;
    }
    
}
