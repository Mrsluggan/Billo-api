package com.idata.eboks.Services;

import com.idata.eboks.configs.exceptions.AppException;
import com.idata.eboks.controller.ContentController;
import com.idata.eboks.models.ContentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ContentService extends BaseService {

    private final RestTemplate billoApiRestTemplateBean;

    public ContentService(RestTemplate billoApiRestTemplateBean) {
        this.billoApiRestTemplateBean = billoApiRestTemplateBean;
    }


    public ContentUser sendContentToUser(String tenantKey, ContentUser contentUser) {
        logger.info("Here comes a new letter: " + tenantKey, contentUser);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<ContentUser> entity = new HttpEntity<>(contentUser, headers);
            ResponseEntity<ContentUser> response = billoApiRestTemplateBean.exchange(
                    createSlug(tenantKey, "/content"),
                    HttpMethod.POST,
                    entity,
                    new ParameterizedTypeReference<ContentUser>() {}
            );

            logger.info("Response Status: {}", response.getStatusCode());
            logger.info("Response Headers: {}", response.getHeaders());
            logger.info("Response Body: {}", response.getBody());

            return response.getBody();
        } catch (Exception e) {
            logger.error("Error occurred while sending content to user", e);
            throw e;
        }
    }

}
