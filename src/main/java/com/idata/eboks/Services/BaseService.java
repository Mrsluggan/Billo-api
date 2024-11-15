package com.idata.eboks.Services;

import com.idata.eboks.configs.auth.BilloApiConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService {

    @Autowired
    private BilloApiConfig billoApiConfig;

    private final String BASE_URL = "https://sandbox-sender-api.billo.life/v1/tenant/";

    private String url = "https://sandbox-sender-api.billo.life/v1/tenant";


    public String createSlug(String tenantKey, String inputPath) {
        return BASE_URL + tenantKey + inputPath;
    }

    public BilloApiConfig getBilloApiConfig() {
        return billoApiConfig;
    }

    public String getUrl() {
        return url;
    }
}
