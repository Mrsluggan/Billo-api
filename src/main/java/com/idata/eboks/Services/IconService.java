package com.idata.eboks.Services;

import com.idata.eboks.models.Icon;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;


@Service
public class IconService extends BaseService {
    
    public Icon provideIcon(String tenantKey, Icon icon) {
        logger.info("Providing icon for tenant: {}", tenantKey);
        if (icon == null) {
            logger.warn("Icon is null");
            return null;
        }
        String url = createSlug(tenantKey, "/icon");
        return sendRequest(url, HttpMethod.POST, icon, new ParameterizedTypeReference<Icon>() {});
    }
}