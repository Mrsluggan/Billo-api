package com.idata.eboks.models;

import java.io.IOException;

public enum NameEnum {
    FANCY_ICON, FILENAME_HTML, FILENAME_PDF;

    public String toValue() {
        switch (this) {
            case FANCY_ICON:
                return "fancy icon";
            case FILENAME_HTML:
                return "filename.html";
            case FILENAME_PDF:
                return "filename.pdf";
        }
        return null;
    }

    public static NameEnum forValue(String value) throws IOException {
        if (value.equals("fancy icon"))
            return FANCY_ICON;
        if (value.equals("filename.html"))
            return FILENAME_HTML;
        if (value.equals("filename.pdf"))
            return FILENAME_PDF;
        throw new IOException("Cannot deserialize NameEnum");
    }
}