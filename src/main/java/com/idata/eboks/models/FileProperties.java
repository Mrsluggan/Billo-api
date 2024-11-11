package com.idata.eboks.models;

public class FileProperties {
    private ContentType name;
    private ContentType data;
    private ContentType contentType;
    private ResponsivePart responsivePart;

    public ContentType getName() {
        return name;
    }

    public void setName(ContentType value) {
        this.name = value;
    }

    public ContentType getData() {
        return data;
    }

    public void setData(ContentType value) {
        this.data = value;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType value) {
        this.contentType = value;
    }

    public ResponsivePart getResponsivePart() {
        return responsivePart;
    }

    public void setResponsivePart(ResponsivePart value) {
        this.responsivePart = value;
    }
}