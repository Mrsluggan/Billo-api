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
        logger.info("Here comes a new letter: " + tenantKey , contentUser);
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
            logger.error("Error while making request:  " +e.getResponseBodyAsString());

            throw new AppException("Error while making request: ", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Error: " + e.getMessage() , e);
            throw new RuntimeException("Error processing contentUser", e);
        }
    }
}
