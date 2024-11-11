package com.idata.eboks.models;

public class Welcome4 {
    private String openapi;
    private Server[] servers;
    private Info info;
    private Tag[] tags;
    private XTagGroup[] xTagGroups;
    private Paths paths;
    private Components components;

    public String getOpenapi() {
        return openapi;
    }

    public void setOpenapi(String value) {
        this.openapi = value;
    }

    public Server[] getServers() {
        return servers;
    }

    public void setServers(Server[] value) {
        this.servers = value;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info value) {
        this.info = value;
    }

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] value) {
        this.tags = value;
    }

    public XTagGroup[] getXTagGroups() {
        return xTagGroups;
    }

    public void setXTagGroups(XTagGroup[] value) {
        this.xTagGroups = value;
    }

    public Paths getPaths() {
        return paths;
    }

    public void setPaths(Paths value) {
        this.paths = value;
    }

    public Components getComponents() {
        return components;
    }

    public void setComponents(Components value) {
        this.components = value;
    }
}
