package com.idata.eboks.Services;

import com.idata.eboks.models.EndUser;
import com.idata.eboks.models.UserMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService extends BaseService {

    @Autowired
    private RestTemplate billoApiRestTemplateBean;
    

    public UserMatch matchUsers(String tenantKey) {
        List<EndUser> chatResponse = billoApiRestTemplateBean.exchange(
                createSlug(tenantKey, "/user"),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<EndUser>>() {
                }).getBody();

        return new UserMatch(chatResponse);
    }
}
