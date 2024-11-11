package com.idata.eboks.models;

import java.io.IOException;

public enum Enum {
    APPLICATION_PDF, IMAGE_PNG, TEXT_HTML;

    public String toValue() {
        switch (this) {
            case APPLICATION_PDF:
                return "application/pdf";
            case IMAGE_PNG:
                return "image/png";
            case TEXT_HTML:
                return "text/html";
        }
        return null;
    }

    public static Enum forValue(String value) throws IOException {
        if (value.equals("application/pdf"))
            return APPLICATION_PDF;
        if (value.equals("image/png"))
            return IMAGE_PNG;
        if (value.equals("text/html"))
            return TEXT_HTML;
        throw new IOException("Cannot deserialize Enum");
    }
}
