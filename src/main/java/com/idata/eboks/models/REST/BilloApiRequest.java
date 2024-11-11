package com.idata.eboks.models.REST;



public class BilloApiRequest {

    private String endpoint;

    public BilloApiRequest(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
    
    
}
