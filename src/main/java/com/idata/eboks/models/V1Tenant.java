package com.idata.eboks.models;

public class V1Tenant {
    private V1TenantPost post;
    private V1TenantGet get;

    public V1TenantPost getPost() {
        return post;
    }

    public void setPost(V1TenantPost value) {
        this.post = value;
    }

    public V1TenantGet getGet() {
        return get;
    }

    public void setGet(V1TenantGet value) {
        this.get = value;
    }
}
