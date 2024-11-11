package com.idata.eboks.models;

import java.io.IOException;

public enum Type {
    BOOLEAN, STRING;

    public String toValue() {
        switch (this) {
            case BOOLEAN:
                return "boolean";
            case STRING:
                return "string";
        }
        return null;
    }

    public static Type forValue(String value) throws IOException {
        if (value.equals("boolean")) return BOOLEAN;
        if (value.equals("string")) return STRING;
        throw new IOException("Cannot deserialize Type");
    }
}