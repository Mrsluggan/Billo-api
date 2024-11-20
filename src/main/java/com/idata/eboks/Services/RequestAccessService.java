package com.idata.eboks.Services;

import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.idata.eboks.models.RequestAccess;

@Service
public class RequestAccessService {

    private static final String BASE_URL = "https://sandbox-sender-api.billo.life/v1/tenant/";

    private final RestTemplate restTemplate;

    public RequestAccessService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public RequestAccess requestAccess(String vatNumber) {
        String url = BASE_URL + "request_access";
        var requestBody = Map.of("vat_number", vatNumber);
        return restTemplate.postForObject(url, requestBody, RequestAccess.class);
    }
}
