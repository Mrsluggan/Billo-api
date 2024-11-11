package com.idata.eboks.models;

import java.io.IOException;

public enum Format {
    HEXADECIMAL, HEXADECIMAL_VALUE, URL;

    public String toValue() {
        switch (this) {
            case HEXADECIMAL:
                return "hexadecimal";
            case HEXADECIMAL_VALUE:
                return "hexadecimal value";
            case URL:
                return "url";
        }
        return null;
    }

    public static Format forValue(String value) throws IOException {
        if (value.equals("hexadecimal"))
            return HEXADECIMAL;
        if (value.equals("hexadecimal value"))
            return HEXADECIMAL_VALUE;
        if (value.equals("url"))
            return URL;
        throw new IOException("Cannot deserialize Format");
    }
}