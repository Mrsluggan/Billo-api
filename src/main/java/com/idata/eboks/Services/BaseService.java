package com.idata.eboks.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.*;

import com.idata.eboks.configs.auth.BilloApiConfig;

@Service
public class BaseService {

    @Autowired
    private BilloApiConfig billoApiConfig;

    @Autowired 
    protected RestTemplate billoApiRestTemplateBean;

    private final String BASE_URL = "https://sandbox-sender-api.billo.life/v1/tenant/";

    private String url = "https://sandbox-sender-api.billo.life/v1/tenant";

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    public String createSlug(String tenantKey, String inputPath) {
        return BASE_URL + tenantKey + inputPath;
    }

    public BilloApiConfig getBilloApiConfig() {
        return billoApiConfig;
    }

    public String getUrl() {
        return url;
    }

    public <T> T sendRequest(
        String url,
        HttpMethod httpMethod,
        Object requestBody,
        ParameterizedTypeReference<T> responseType
    ){
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Object>entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<T> response = billoApiRestTemplateBean.exchange(url, httpMethod, entity, responseType);

            logger.info("Response Status: {}", response.getStatusCode());
            logger.info("Response Headers: {}", response.getHeaders());
            logger.info("Response Body: {}", response.getBody());

            return response.getBody();
        } catch (HttpClientErrorException e) {
            logger.error("Error response: {}", e.getResponseBodyAsString(), e);
            throw e;
        } catch (Exception e) {
            logger.error("Error: {}", e.getMessage(), e);
            throw new RuntimeException("Error processing request", e);
        }
    }
}