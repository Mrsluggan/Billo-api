package com.idata.eboks.Services;

import com.idata.eboks.models.Tenant;
import com.idata.eboks.models.TenantKey;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantService extends BaseService {

    public Tenant createTenant(Tenant tenant) {
        logger.info("Creating tenant: {}", tenant);
        String url = getUrl();
        return sendRequest(url, HttpMethod.POST, tenant, new ParameterizedTypeReference<Tenant>() {});
    }

    public List<List<TenantKey>> listTenants(String orgnr) {
        logger.info("Listing tenants for orgnr: {}", orgnr);
        String url = getUrl();
        if (orgnr != null && !orgnr.isEmpty()) {
            url += "?orgnr=" + orgnr;
        }
        return sendRequest(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<List<TenantKey>>>() {});
    }

    public Tenant updateTenantName(String tenantKey, String newName) {
        logger.info("Updating tenant name for tenantKey: {}", tenantKey);
        String url = createSlug(tenantKey, "/name");
        return sendRequest(url, HttpMethod.PUT, newName, new ParameterizedTypeReference<Tenant>() {});
    }

    public Tenant getTenant(String tenantKey) {
        logger.info("Getting tenant for tenantKey: {}", tenantKey);
        String url = createSlug(tenantKey, "");
        return sendRequest(url, HttpMethod.GET, null, new ParameterizedTypeReference<Tenant>() {});
    }
}
