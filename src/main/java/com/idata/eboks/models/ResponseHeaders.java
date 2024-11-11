package com.idata.eboks.models;

public class ResponseHeaders {
    private Location billoObjkey;
    private BilloRetained billoRetained;
    private Location location;

    public Location getBilloObjkey() {
        return billoObjkey;
    }

    public void setBilloObjkey(Location value) {
        this.billoObjkey = value;
    }

    public BilloRetained getBilloRetained() {
        return billoRetained;
    }

    public void setBilloRetained(BilloRetained value) {
        this.billoRetained = value;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location value) {
        this.location = value;
    }
}
