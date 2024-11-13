package com.idata.eboks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyID {
    private String name; // Required
    private String orgnr; // Required
}
