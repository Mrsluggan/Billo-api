package com.idata.eboks.configs.auth;
import com.idata.eboks.Services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.idata.eboks.Services.TokenService;

@Configuration
public class BilloApiRestTemplate extends BaseService {

    @Autowired
    private TokenService billoAuth;

    
    @Bean(name = "billoApiRestTemplateBean")
    @Qualifier("billoApiRestTemplateBean")
    public RestTemplate billoApiRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getInterceptors().add((request, body, execution) -> {
            String token = billoAuth.getAccessToken();
            if (token != null) {
                request.getHeaders().add("Authorization", "Bearer " + token);
            } else {
                logger.error("Authorization header is empty");
            }
            return execution.execute(request, body);
        });

        return restTemplate;
    }
}
