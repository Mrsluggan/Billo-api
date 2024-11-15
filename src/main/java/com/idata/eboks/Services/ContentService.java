package com.idata.eboks.Services;

import com.idata.eboks.models.ContentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ContentService extends BaseService {

    @Autowired
    private RestTemplate billoApiRestTemplateBean;

    public ContentUser sendContentToUser(String tenantKey, ContentUser contentUser) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<ContentUser> entity = new HttpEntity<>(contentUser, headers);

            return billoApiRestTemplateBean.exchange(
                    createSlug(tenantKey, "/content"),
                    HttpMethod.POST,
                    entity,
                    new ParameterizedTypeReference<ContentUser>() {
                    }).getBody();

        } catch (HttpClientErrorException e) {
            System.out.println("Error response: " + e.getResponseBodyAsString());
            throw e;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException("Error processing contentUser", e);
        }
    }
}
