package com.idata.eboks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Icon {
    private String name; // Required
    private String data; // Required
    private String contentType; // Required

}