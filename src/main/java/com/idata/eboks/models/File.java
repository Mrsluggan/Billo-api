package com.idata.eboks.models;

import lombok.Data;

@Data
public class File {
    private String name; // Required
    private String data; // Required
    private String contentType; // Required
    private ResponsivePart responsivePart;


    @Data
    public static class ResponsivePart {
        private String name; // Required
        private String data; // Required
        private String contentType; // Required
    }
}
