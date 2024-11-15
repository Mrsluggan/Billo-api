package com.idata.eboks.configs.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BilloApiConfig {

    @Value("${billo.api.client.id}")
    private String clientId;

    @Value("${billo.api.client.secret}")
    private String clientSecret;

    @Value("${billo.api.client.tenantKey}")
    private String tenantKey;

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getTenantKey() {
        return tenantKey;
    }
}
