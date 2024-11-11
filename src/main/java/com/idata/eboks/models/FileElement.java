package com.idata.eboks.models;

public class FileElement {
    private NameEnum name;
    private Data data;
    private Enum contentType;
    private FileElement responsivePart;

    public NameEnum getName() {
        return name;
    }

    public void setName(NameEnum value) {
        this.name = value;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data value) {
        this.data = value;
    }

    public Enum getContentType() {
        return contentType;
    }

    public void setContentType(Enum value) {
        this.contentType = value;
    }

    public FileElement getResponsivePart() {
        return responsivePart;
    }

    public void setResponsivePart(FileElement value) {
        this.responsivePart = value;
    }
}
