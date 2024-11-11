package com.idata.eboks.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.idata.eboks.models.Tenant;
import com.idata.eboks.models.UserMatch;

@Service
public class UserMatchService {

    @Autowired
    @Qualifier("billoApiRestTemplateBean")
    private RestTemplate billoApiRestTemplateBean;

    public List<UserMatch> matchUsers() {
        List<UserMatch> chatResponse = billoApiRestTemplateBean.exchange(
                "https://sandbox-sender-api.billo.life/v1/tenant/50746fd6-158b-4583-bb7f-655e5d98a5ed/user",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<UserMatch>>() {
                }).getBody();
        return chatResponse;
    }

    public Tenant updateTenantName(String newName) {
        Tenant tenant = billoApiRestTemplateBean.exchange(
                "https://sandbox-sender-api.billo.life/v1/tenant/50746fd6-158b-4583-bb7f-655e5d98a5ed/name",
                HttpMethod.PUT, null, new ParameterizedTypeReference<Tenant>() {
                }).getBody();
        
        return tenant;
    }

}