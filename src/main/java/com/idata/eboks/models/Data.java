package com.idata.eboks.models;

import java.io.IOException;

public enum Data {
    P_GGX_PM_NVBN_RLBN_Q8_L2_GX_PG, REVBREJFRUY, REVBR_EJFRUY;

    public String toValue() {
        switch (this) {
            case P_GGX_PM_NVBN_RLBN_Q8_L2_GX_PG:
                return "PGgxPmNvbnRlbnQ8L2gxPg==";
            case REVBREJFRUY:
                return "REVBREJFRUY=";
            case REVBR_EJFRUY:
                return "REVBR ...... EJFRUY=";
        }
        return null;
    }

    public static Data forValue(String value) throws IOException {
        if (value.equals("PGgxPmNvbnRlbnQ8L2gxPg=="))
            return P_GGX_PM_NVBN_RLBN_Q8_L2_GX_PG;
        if (value.equals("REVBREJFRUY="))
            return REVBREJFRUY;
        if (value.equals("REVBR ...... EJFRUY="))
            return REVBR_EJFRUY;
        throw new IOException("Cannot deserialize Data");
    }
}
