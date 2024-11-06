package com.idata.eboks.models;

import lombok.Data;

@Data
public class Attachment {
    private String name;
    private long sizeInBytes;
    private String content; 
}